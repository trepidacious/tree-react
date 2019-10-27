package org.rebeam.tree

import cats.Monad
import org.rebeam.tree.codec.IdCodec
import org.rebeam.tree.ot.{OTList, Operation}

/**
  * Operations on a software-transactional memory.
  *
  * Note that there are restrictions on the sequence of operations within a transaction, in order
  * for that transaction to be considered "stable".
  *
  * A stable transaction is one that will always put the same data to the same new Id's
  * when run on a client (optimistically, and concurrently with other transactions on other clients)
  * as it will  as when it is run on the server. In the future if we implement operational transformations
  * we may also extend the definition of a stable transaction to require that it will always execute
  * the same exact operational transformations in the same order on the client as on the server, to allow
  * us to produce a consistent OT history on all clients and the server.
  *
  * It is desirable to have stable transactions so that we can safely use the literal values of Ids
  * (for example Id(Guid(1,1,1)) on the client side, even before they are confirmed by the server. If we
  * were to use Id's from an unstable transaction on the client side before confirmation, we might then
  * find that on the server, and interleaved transaction from another client caused the transaction to
  * produce a different result, with a different set of Ids and data contents. We might even find that
  * on the server history, Id(Guid(1,1,1)) is never produced. When the client received this new history
  * from the server, it would be left with dangling literal Ids.
  *
  * In the future, for OT, we will also be able to ensure that when transactions are interleaved on the
  * server, each Operation will only ever see additional Operations inserted before it - we will not "lose"
  * Operations from stable transactions. This allows us to operate with a simpler OT implementation
  * having only the "after" transformation, without needing "before".
  *
  * Once transactions are classified as stable or unstable, there are two approaches to dealing with
  * an unstable transaction:
  *
  * 1. Produce an error when executing the transaction on the client, and reject it completely. This then becomes
  *    a code problem for the user of tree to fix - all transactions must be adjusted to be stable. All transactions
  *    can then be run concurrently/optimistically, giving good performance. Note that there may be a requirement
  *    for complex transactions where this is not possible.
  *
  * 2. Execute the transaction, but then enter a synchronous mode - the client will not display the result
  *    of the transaction (since it may change), and will not accept new transactions, until a response
  *    is received from the server including the unstable transaction. At this point the server result
  *    is known, and can be used as the authoritative result for further transactions. The client can display
  *    this state with some kind of spinner.
  *
  * It may also be reasonable to adapt approach 2, so that the result of the unstable transaction is not
  * displayed, but further transactions are accepted. This should work, since the unstable transaction
  * essentially is treated like and becomes equivalent to a remote transaction - its results are not visible
  * until it is executed by the server, and at this point any subsequent local client transactions will be re-run
  * to take this into account. This reduces the impact of the synchronous execution - the user will only be delayed if
  * they need to work with the data produced by the unstable transaction. This may be confusing to the user, and so
  * it may be worth displaying a notification while such transactions are pending, if possible in the UI component
  * that triggered the transaction, but otherwise globally.
  *
  * The algorithm for classifying transactions as stable or unstable is as follows:
  *
  * 1. Some operations are classified as U - this means that they can produce unstable results themselves, and/or
  *    cause subsequent operations to produce unstable results. These are essentially operations that can read state
  *    from the STM, and so can be affected by previous transactions, and expose state within the execution of later
  *    stages of the Monad that will allow those later stages to be affected by previous transactions.
  * 2. Some operations are classified as S - this means that we require them to produce the same results, regardless
  *    of STM state, in order for a transaction to be stable. These are operations that create GUIDs, and/or put new
  *    id-value pairs to the STM, and/or make use of operational transformation (OT data is both stored in the STM, and
  *    requires that all operations form a consistent history - once an operation occurs on the client, it must also
  *    occur on the server, in order to allow transformation to work on that consistent history).
  * 4. Where an operation is "compound" - i.e. it makes use of/contains other operations, notably `putF`, we consider
  *    that compound operation to inherit the U and S "flags" from those contained operations - it is U if any contained
  *    operation is U, and S if any contained operation is S.
  * 3. A transaction is stable if it contains no U operations before any S operation. Operations that are both U and
  *    S are a special case - we must consider them on a case-by-case basis to see whether the S parts of the
  *    transaction can be influenced by the U part. So for example in the case of `putF`, it is valid to use a create
  *    function that reads STM state, since the S operation (putting a new value to the STM) will proceed regardless
  *    of the state read from the STM, and the data put to the STM will be of the same type. This means that we still
  *    achieve a stable call to `putF`. However since the `putF` transaction will return the new data, potentially
  *    containing STM data, we must still classify the transaction as U (as well as S), and so no further S operations
  *    can be performed in a transaction including the putF. This logic must be handled by implementations of STMOps.
  *
  * Hence we might have a sequence of operations that are S, S, U, U and this would be a stable transaction.
  * A transaction containing operations that are say S, U, S will be unstable, since the last S operation
  * occurs after a U operation. A transaction containing a U + S operation will be unstable if that operation itself
  * is intrinsically unstable, and will be stable if the operation itself is stable and is not followed by any
  * S operations, e.g. U, U+S, U, U would be stable, U+S, S would be unstable.
  *
  * At present the "rand" operations in TransactionOps, are considered to be S operations. They need to be stable
  * if the user intends to rely on the results in later transactions - for example the user could (but shouldn't) use
  * random values to produce a conventional UUID and use that to try to search for data in a later transaction.
  * TODO: We could perhaps provide additional non-S versions of the operations, making it clear that the use of
  * non-S versions is only recommended when the data will be used only cosmetically (for example for assigning a
  * random colour for display, where this does not need to be stable).
  *
  * Some operations are generally potentially U, but also exist as a safe, non-U form.
  * For example `modifyF` reads a value from the STM, modifies it (using a sub-transaction that may also read data
  * from the STM) and returns the new value. Since this new value may contain data from the STM the operation is
  * U. However the `modifyFUnit` version of this operation does not return the modified data, and so is not U. Note
  * however that if the sub-transaction it runs is itself unstable, the modifyFUnit will also render a transaction
  * unstable. By contrast, the `modifyUnit` form of this operation is always U, and never unstable - it uses a
  * pure function to modify the STM state, and doesn't return the modified state, so cannot be unstable or U.
  *
  * @tparam F The monad used to express operations
  */
abstract class STMOps[F[_]: Monad] extends TransactionOps {

  /**
    * Get data at an [[Id]]
    *
    * U operation - makes STM data at id available to subsequent transactions.
    *
    * @param id   The data's [[Id]]
    * @tparam A   Type of data22
    * @return     The data at specified [[Id]]
    */
  def get[A](id: Id[A]): F[A]

  /**
    * Modify data at an [[Id]]
    *
    * U operation - makes the original STM data at id, and modified data, available to subsequent transactions.
    * If f is unstable, this operation will also render transactions unstable.
    *
    * @param id   The data's [[Id]]
    * @param f    Function to transform old value to new one, as an F[A]
    * @tparam A   Type of data
    * @return     The modified data
    */
  def modifyF[A](id: Id[A], f: A => F[A]): F[A]

  /**
   * Modify data at an [[Id]]
   *
   * This version does not return the modified result - this means that the operation is not U. However note that
   * if the f function renders the transaction unstable in itself, the transaction will still be unstable.
   *
   * @param id   The data's [[Id]]
   * @param f    Function to transform old value to new one, as an F[A]
   * @tparam A   Type of data
   * @return     Unit - if you require the result of the modification, use [[modifyF]] instead.
   */
  def modifyFUnit[A](id: Id[A], f: A => F[A]): F[Unit]

  /**
   * Modify data at an [[Id]] using a pure function
   *
   * U operation - makes the original STM data at id, and modified data, available to subsequent transactions.
   *
   * @param id   The data's [[Id]]
   * @param f    Function to transform old value to new one, as an A
   * @tparam A   Type of data
   * @return     The modified data
   */
  def modify[A](id: Id[A], f: A => A): F[A] = modifyF(id, f.andThen(pure))

  /**
   * Modify data at an [[Id]] using a pure function
   *
   * This version does not return the modified result - this means that this operation is not U, since it does
   * not expose the result of the modification to later operations. It will also never make a transaction unstable.
   *
   * @param id   The data's [[Id]]
   * @param f    Function to transform old value to new one, as an A
   * @tparam A   Type of data
   * @return     Unit - if you require the result of the modification, use [[modifyF]] instead.
   */
  def modifyUnit[A](id: Id[A], f: A => A): F[Unit] = modifyFUnit(id, f.andThen(pure))

  /**
   * Put a new value into the STM. This will create a new
   * Id, and this is used to create the data to add to the
   * STM (in case the data includes the Id).
   *
   * Always an S operation, since it puts a new value to the STM and creates a new Id.
   * Note that if create contains any U operations, then this is also a U operation as well as an S operation (and in
   * this case the data read from the STM may be present in the returned data - otherwise the data will contain no
   * STM data, just data from the create function itself).
   *
   * Note that this is a special case for stability - even if the create function is U, this operation does not
   * render the transaction unstable, since it will always create a value in the STM with the same Id, of the same
   * type, meeting the requirements for stability.
   *
   * @param create   Function to create data from Id, as an F[A]
   * @param idCodec  Used to encode/decode data
   *                 and deltas
   * @tparam A       The type of data
   * @return         The created data, and its Id
   */
  def putFWithId[A](create: Id[A] => F[A])(implicit idCodec: IdCodec[A]): F[(A, Id[A])]

  /**
    * Put a new value into the STM. This will create a new
    * Id, and this is used to create the data to add to the
    * STM (in case the data includes the Id).
    *
    * Always an S operation, since it puts a new value to the STM and creates a new Id.
    * Note that if create contains any U operations, then this is also a U operation as well as an S operation (and in
    * this case the data read from the STM may be present in the returned data - otherwise the data will contain no
    * STM data, just data from the create function itself).
    *
    * Note that this is a special case for stability - even if the create function is U, this operation does not
    * render the transaction unstable, since it will always create a value in the STM with the same Id, of the same
    * type, meeting the requirements for stability.
    *
    * @param create   Function to create data from Id, as an F[A]
    * @param idCodec  Used to encode/decode data
    *                 and deltas
    * @tparam A       The type of data
    * @return         The created data
    */
  def putF[A](create: Id[A] => F[A])(implicit idCodec: IdCodec[A]): F[A] = implicitly[Monad[F]].map(putFWithId(create))(_._1) // Why won't this work with just .map(_._1)?

  /**
   * Put a new value into the STM. This will create a new
   * Id, and this is used to create the data to add to the
   * STM (in case the data includes the Id).
   *
   * Always an S operation, since it puts a new value to the STM and creates a new Id. This does not return the
   * value that has been put (just the Id), and so is not U, even if the create function is U.
   *
   * Note that this is a special case for stability - even if the create function is U, this operation does not
   * render the transaction unstable, since it will always create a value in the STM with the same Id, of the same
   * type, meeting the requirements for stability. Note that if the create function is itself unstable, any transaction
   * using this operation will be unstable as well.
   *
   * @param create   Function to create data from Id, as an F[A]
   * @param idCodec  Used to encode/decode data
   *                 and deltas
   * @tparam A       The type of data
   * @return         The created data
   */
  def putFJustId[A](create: Id[A] => F[A])(implicit idCodec: IdCodec[A]): F[Id[A]]// = implicitly[Monad[F]].map(putFWithId(create))(_._2) // Why won't this work with just .map(_._2)?

  /**
    * Put a new value into the STM. This will create a new
    * Id, and this is used to create the data to add to the
    * STM (in case the data includes the Id).
    *
    * Always an S operation, since it puts a new value to the STM and creates a new Id.
    * Never a U operation, since `create` does not use the STM and so cannot contain U operations (and for
    * this reason the returned data contains no STM data that might change - only data created by the create
    * function).
    *
    * @param create   Function to create data from Id, as an A
    * @param idCodec  Used to encode/decode data
    *                 and deltas
    * @tparam A       The type of data
    * @return         The created data
    */
  def put[A](create: Id[A] => A)(implicit idCodec: IdCodec[A]): F[A] = putF(create.andThen(pure))

  /**
    * Create a new Guid for general-purpose use (e.g. for Logoot)
    *
    * S operation, since it creates a new Guid.
    *
    * @return   The new Guid
    */
  def createGuid: F[Guid]

  /**
    * Put a new List value into the STM, with operational transformation
    * support.
    * This will create a new Id, and this is used to create the data to add to the
    * STM (in case the data includes the Id).
    *
    * Note that this is a special case for stability - even if the create function is U, this operation does not
    * render the transaction unstable, since it will always create a value in the STM with the same Id, of the same
    * type, meeting the requirements for stability.
    *
    * Always an S operation, since it puts a new value to the STM and creates a new Id.
    *
    * Note that if create contains any U operations, then this is also a U operation AS WELL AS an S operation
    * (and in this case the data read from the STM may be present in the returned data - otherwise the data
    * will contain no STM data, just data from the create function itself).
    *
    * @param create   Function to create data as an `F[List[A]]`
    * @param idCodec  Used to encode/decode data
    *                 and deltas
    * @tparam A       The type of data in the List
    * @return         The created List
    */
  def createOTListF[A](create: F[List[A]])(implicit idCodec: IdCodec[OTList[A]]): F[OTList[A]]

  /**
   * Put a new List value into the STM, with operational transformation
   * support.
   *
   * This will create a new Id, and this is used to create the data to add to the
   * STM (in case the data includes the Id).
   *
   * Note that this is a special case for stability - even if the create function is U, this operation does not
   * render the transaction unstable, since it will always create a value in the STM with the same Id, of the same
   * type, meeting the requirements for stability.
   *
   * Always an S operation, since it puts a new value to the STM and creates a new Id. This does not return the
   * value that has been put (just the Id), and so is not U, even if the create function is U.
   *
   * @param create   Function to create data as an `F[List[A]]`
   * @param idCodec  Used to encode/decode data
   *                 and deltas
   * @tparam A       The type of data in the List
   * @return         The created OTList's Id
   */
  def createOTListFJustId[A](create: F[List[A]])(implicit idCodec: IdCodec[OTList[A]]): F[Id[OTList[A]]]// =
//    implicitly[Monad[F]].map(createOTListF(create))(_.id) // Why won't this work with just .map(_.id)?

  /**
    * Put a new List value into the STM, with operational transformation
    * support.
    * This will create a new Id, and this is used to create the data to add to the
    * STM (in case the data includes the Id)
    *
    * Always an S operation, since it puts a new value to the STM and creates a new Id.
    * Never a U operation, since `create` does not use the STM and so cannot contain U operations (and for
    * this reason the returned data contains no STM data that might change - only data created by the create
    * function).
    *
    * @param create   Function to create data from Id, as a `List[A]`
    * @param idCodec  Used to encode/decode data
    *                 and deltas
    * @tparam A       The type of data in the List
    * @return         The created List
    */
  def createOTList[A](create: List[A])(implicit idCodec: IdCodec[OTList[A]]): F[OTList[A]] = createOTListF(pure(create))

  /**
    * Apply an OT operation to an OTlist.
    *
    * This is an S operation - we require that all OT operations create a single history, and so OT operations
    * cannot be based on the contents of the STM. This is still useful for the most common operations, e.g. performing
    * a text edit based on user input, deleting an item from an OTList, or inserting a new item not based on the STM
    * contents.
    *
    * U operation - makes the original STM data at id, and modified data, available to subsequent transactions.
    *
    *
    * @param list The OTList
    * @param op   The operation to apply
    * @tparam A   The type of data in the list
    * @return     The new list contents
    */
  def otListOperation[A](list: OTList[A], op: Operation[A]): F[OTList[A]]

  /**
   * Apply an OT operation to an OTlist.
   *
   * This is an S operation - we require that all OT operations create a single history, and so OT operations
   * cannot be based on the contents of the STM. This is still useful for the most common operations, e.g. performing
   * a text edit based on user input, deleting an item from an OTList, or inserting a new item not based on the STM
   * contents.
   *
   * This does not return the modified OTList, and so is not a U operation
   *
   * @param list The OTList
   * @param op   The operation to apply
   * @tparam A   The type of data in the list
   * @return     The new list contents
   */
  def otListOperationUnit[A](list: OTList[A], op: Operation[A]): F[Unit]
//    implicitly[Monad[F]].map(otListOperation(list, op))(_ => ()) // Why won't this work with just .map(_.id)?
}



