package org.rebeam.tree

import cats.Monad
import cats.syntax.functor._
import org.rebeam.tree.codec.IdCodec
import org.rebeam.tree.ot.{OTList, Operation}

/**
  * Operations on a software-transactional memory.
  *
  * Note that there are restrictions on the sequence of operations within a transaction, in order
  * for that transaction to be considered "stable".
  *
  * A stable transaction is one that will always put the same type of data to the same new Ids
  * when run on a client (optimistically/concurrently with other transactions on other clients)
  * as it will when it is run on the server. Note that we don't require that the exact same data is put to each Id.
  *
  * In addition a stable transaction will always execute the same exact operational transformations in the same
  * order on the client as on the server, to allow us to produce a consistent OT history on all clients and the server.
  * Note that this is stricter than the requirement for non-OT data; we require that when creating an OT List, a stable
  * transaction will always create the same exact data, so as to be compatible with future operations.
  *
  * It is desirable to have stable transactions for Ids so that we can safely use the literal values of Ids
  * (for example Id(Guid(1,1,1)) on the client side, even before they are confirmed by the server. If we
  * were to use Id's from an unstable transaction on the client side before confirmation, we might then
  * find that on the server, and interleaved transaction from another client caused the transaction to
  * produce a different result, with a different set of Ids and/or data
  * types for those Ids. We might even find that on the server history, Id(Guid(1,1,1)) is never produced.
  * When the client received this new history from the server, it would be left with dangling literal Ids. Since
  * we know that the STM data for a given Id may change at any point, and allow for this, we do not require that
  * the client (when running optimistically) and server produce the same data for a given Id, so they may disagree
  * on the initial value of the data (until synchronised), but never its type or existence.
  *
  * For OT, we also need to ensure that when transactions are interleaved on the
  * server, each Operation will only ever see additional Operations inserted before it - we will not "lose"
  * Operations from stable transactions. This allows us to operate with a simpler OT implementation
  * having only the "after" transformation, without needing "before". Therefore we require that OT operations are
  * exactly the same whenever a transaction is run, on the server or client (before the actual operational
  * transformation step). We also require that the initial data state is identical, so that the same operations can
  * be applied.
  *
  * Once transactions are classified as stable or unstable, there are two approaches to dealing with
  * an unstable transaction:
  *
  * 1. Produce an error when executing the transaction on the client, and reject it completely. This then becomes
  *    a code problem for the user of tree to fix - all transactions must be adjusted to be stable. All transactions
  *    can then be run concurrently/optimistically, giving good performance. Note however that there may be cases where
  *    where a user wishes to implement complex transactions that cannot be made stable.
  *
  * 2. Accept the unstable transaction, but then enter a synchronous mode - the client will not execute the transaction
  *    (since it may change when executed on the server), and will not accept new transactions, until a response
  *    is received from the server including the unstable transaction. At this point the server result
  *    is known, and can be used as the authoritative result for further transactions. The client can display
  *    this state with some kind of spinner.
  *
  * It may also be reasonable to adapt approach 2, so that the unstable transaction is executed on the client but the
  * results are not displayed, while further transactions are accepted. This should work, since the unstable transaction
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
  *    cause subsequent operations to produce unstable results. These are essentially operations that:
  *    * can read state from the STM, and so can be affected by previous transactions that have altered that state, and
  *    * expose that state within the execution of later stages of the Monad that will allow those later stages to be
  *      affected by previous transactions - i.e. they return data that is influenced by the STM state they read.
  *
  * 2. Some operations are classified as S - this means that we require them to produce the same results, regardless
  *    of STM state, in order for a transaction to be stable. These are operations that create GUIDs, and/or put new
  *    id-value pairs to the STM, and/or make use of operational transformation, as described above.
  *
  * 3. Each transaction, when run, will result in a sequence of operations. Some operations implement nesting, by
  *    containing an inner transaction as part of themselves (for example putF, modifyF and createOTListF, and
  *    variants). In this case we "flatten" the execution for the purposes of monitoring stability, and
  *    simply track the operations of the inner transaction as part of the whole transaction sequence.
  *    So the inner transaction's operations will run after previous operations in the outer transaction - if the outer
  *    transaction has already executed U operations, then any S operations in the inner transaction will result in
  *    an unstable outer transaction. Similarly, any U operations performed in the inner transaction will be considered
  *    to have run before any later operations in the outer transaction. However there are some exceptions to
  *    this last point - since the inner transaction is isolated by being run inside an operation, implementations
  *    of STMOps can ensure that no data from the inner transaction is available outside that inner transaction - this
  *    is done by simply discarding the return value of the inner transaction, within the implementation of the
  *    operation. The STMOps with a "Unit" suffix must do this, and as a result will not be U, even if the inner
  *    transaction they execute is U. This may be useful to allow producing stable transactions for more complex
  *    use cases, although where possible it is simpler to just use the non-"F" versions of the operations, which
  *    use pure functions instead of inner transactions.
  *
  * 4. A transaction is stable if it contains no U operations before any S operation. Operations that are both U and
  *    S are a special case - we must consider them on a case-by-case basis to see whether the S parts of the
  *    transaction can be influenced by the U part. So for example in the case of `putF`, it is valid to use a create
  *    function that reads STM state, since the S operation (putting a new value to the STM) will proceed regardless
  *    of the state read from the STM, and the data put to the STM will be of the same type. This means that we still
  *    achieve a stable call to `putF`. However since the `putF` transaction will return the new data, potentially
  *    containing STM data, we must still classify the transaction as U (as well as S), and so no further S operations
  *    can be performed in a transaction including the putF. This logic must be handled by implementations of STMOps.
  *    Note that `createListOTF` is classified as unstable if the `create` function is U, since we require that
  *    OTLists are created with exactly the same data on the client and server, to support a single oeprational
  *    transformation history. otListOperation is both S (since OT operations must be stable) and U (since it returns
  *    the (modified) state of the OTList it operates on - however it does not depend itself on that state - it always
  *    adds the same OT operation, regardless of the state it makes available.
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
  * For example modifyF` reads a value from the STM, modifies it (using a sub-transaction that may also read data
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
  def modify[A](id: Id[A], f: A => A): F[A] =
    modifyF(id, f.andThen(pure))

  /**
   * Modify data at an [[Id]] using a pure function
   *
   * This version does not return the modified result - this means that this operation is not U, since it does
   * not expose the result of the modification to later operations. It will also never make a transaction unstable,
   * since a pure function cannot be S.
   *
   * @param id   The data's [[Id]]
   * @param f    Function to transform old value to new one, as an A
   * @tparam A   Type of data
   * @return     Unit - if you require the result of the modification, use [[modifyF]] instead.
   */
  def modifyUnit[A](id: Id[A], f: A => A): F[Unit] =
    modifyFUnit(id, f.andThen(pure))

  /**
    * Create a new Guid for general-purpose use (e.g. for Logoot)
    *
    * S operation, since it creates a new Guid.
    *
    * @return   The new Guid
    */
  def createGuid: F[Guid]

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
  def putF[A](create: Id[A] => F[A])(implicit idCodec: IdCodec[A]): F[A] =
    implicitly[Monad[F]].map(putFWithId(create))(_._1) // Why won't this work with just .map(_._1)?

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
  def putFJustId[A](create: Id[A] => F[A])(implicit idCodec: IdCodec[A]): F[Id[A]]

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
   * @return         The created data, and its Id
   */
  def putWithId[A](create: Id[A] => A)(implicit idCodec: IdCodec[A]): F[(A, Id[A])] = putFWithId(create.andThen(pure))

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
  def put[A](create: Id[A] => A)(implicit idCodec: IdCodec[A]): F[A] =
    putF(create.andThen(pure))

  /**
    * Put a new List value into the STM, with operational transformation
    * support.
    * This will create a new Id, and this is used to create the data to add to the
    * STM (in case the data includes the Id).
    *
    * Always an S operation, since it puts a new value to the STM and creates a new Id.
    *
    * Note that if `create` contains any U operations, then this is also a U operation AS WELL AS an S operation
    * (and in this case the data read from the STM may be present in the returned data - otherwise the data
    * will contain no STM data, just data from the create function itself). In this case createOTListF itself will
    * be unstable, because we require that createOTListF always creates exactly the same data for the initial state of
    * the OTList. This is different to putF, which just requires that some data of the correct type is always created
    * by a transaction, for it to be stable.
    *
    * @param create   Function to create data as an `F[List[A]]`
    * @param idCodec  Used to encode/decode data
    *                 and deltas
    * @tparam A       The type of data in the List
    * @return         The created List
    */
  def createOTListF[A](create: F[List[A]])(implicit idCodec: IdCodec[OTList[A]]): F[OTList[A]]

  // Note there is no createOTListFJustId function because any createOTListF call where `create` is U will make
  // the transaction unstable immediately (since OTLists must always be created with the exact same contents on client
  // and server)- there is no benefit in trying not to pass on the created data to later operations.

  // Note there is no createOTListFWithId since OTList contains its own Id

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
  def createOTList[A](create: List[A])(implicit idCodec: IdCodec[OTList[A]]): F[OTList[A]] =
    createOTListF(pure(create))

  /**
   * Put a new List value into the STM, with operational transformation
   * support.
   * This will create a new Id, and this is used to create the data to add to the
   * STM (in case the data includes the Id).
   *
   * This accepts a `create` function returning `String`, which will be converted to a `List[Char]`
   *
   * Always an S operation, since it puts a new value to the STM and creates a new Id.
   *
   * Note that if `create` contains any U operations, then this is also a U operation AS WELL AS an S operation
   * (and in this case the data read from the STM may be present in the returned data - otherwise the data
   * will contain no STM data, just data from the create function itself). In this case createOTListF itself will
   * be unstable, because we require that createOTListF always creates exactly the same data for the initial state of
   * the OTList. This is different to putF, which just requires that some data of the correct type is always created
   * by a transaction, for it to be stable.
   *
   * @param create   Function to create data as an `F[List[A]]`
   * @param idCodec  Used to encode/decode data
   *                 and deltas
   * @return         The created List
   */
  def createOTStringF(create: F[String])(implicit idCodec: IdCodec[OTList[Char]]): F[OTList[Char]] = createOTListF[Char](create.map(_.toList))

  /**
   * Put a new List value into the STM, with operational transformation
   * support.
   * This will create a new Id, and this is used to create the data to add to the
   * STM (in case the data includes the Id)
   *
   * This accepts a `create` function returning `String`, which will be converted to a `List[Char]`
   *
   * Always an S operation, since it puts a new value to the STM and creates a new Id.
   * Never a U operation, since `create` does not use the STM and so cannot contain U operations (and for
   * this reason the returned data contains no STM data that might change - only data created by the create
   * function).
   *
   * @param create   Function to create data from Id, as a `List[A]`
   * @param idCodec  Used to encode/decode data
   *                 and deltas
   * @return         The created List
   */
  def createOTString(create: String)(implicit idCodec: IdCodec[OTList[Char]]): F[OTList[Char]] =
    createOTStringF(pure(create))

  /**
    * Apply an OT operation to an OTlist.
    *
    * This is an S operation - we require that all OT operations create a single history, and so OT operations
    * cannot be based on the contents of the STM. This is still useful for the most common operations, e.g. performing
    * a text edit based on user input, deleting an item from an OTList, or inserting a new item not based on the STM
    * contents.
    *
    * U operation - makes the original STM data at id (the list), and modified data, available to subsequent
    * transactions. However since this state does not influence the operation itself, this operation is not itself
    * unstable.
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
   * This does not return the modified OTList, and so is not a U operation.
   *
   * @param list The OTList
   * @param op   The operation to apply
   * @tparam A   The type of data in the list
   * @return     The new list contents
   */
  def otListOperationUnit[A](list: OTList[A], op: Operation[A]): F[Unit]

}



