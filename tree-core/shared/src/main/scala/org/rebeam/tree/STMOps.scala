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
  *    from the STM, and so can be affected by previous transactions.
  * 2. Some operations are classified as S - this means that we require them to produce the same results in order for
  *    a transaction to be stable. These are operations that create GUIDs, and/or put new values to the STM. In future
  *    this may also include operations that are subject to operational transformation.
  * 4. Where an operation is "compound" - i.e. it makes use of/contains other operations, notably `putF`, we consider that
  *    compound operation to inherit the U and S "flags" from those contained operations - it is U if any contained
  *    operation is U, and S if any contained operation is S.
  * 3. A transaction is stable if it contains no operations that are both U and S, and contains no U operations before
  *    any S operation.
  *
  * Hence we might have a sequence of operations that are S, S, U, U and this would be a stable transaction. Even a
  * single operation that is U+S will make a transaction unstable (this will generally be a `putF` operation where
  * the `create` parameter itself contains U operations, and it is inherently S itself because it puts a new value
  * to the STM). A transaction containing operations that are say S, U, S will be unstable, since the last S operation
  * occurs after a U operation.
  *
  * At present the "rand" operations in TransactionOps, are considered to be S operations. They need to be stable
  * if the user intends to rely on the results in later transactions - for example the user could (but shouldn't) use
  * random values to produce a conventional UUID and use that to try to search for data in a later transaction.
  * TODO: We could perhaps provide additional non-S versions of the operations, making it clear that the use of
  * non-S versions is only recommended when the data will be used only cosmetically (for example for assigning a
  * random colour for display, where this does not need to be stable).
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
    * @tparam A   Type of data
    * @return     The data at specified [[Id]]
    */
  def get[A](id: Id[A]): F[A]

  /**
    * Modify data at an [[Id]]
    *
    * U operation - makes the original STM data at id, and modified data, available to subsequent transactions.
    *
    * @param id   The data's [[Id]]
    * @param f    Function to transform old value to new one, as an F[A]
    * @tparam A   Type of data
    * @return     The modified data
    */
  def modifyF[A](id: Id[A], f: A => F[A]): F[A]

  /**
    * Put a new value into the STM. This will create a new
    * Id, and this is used to create the data to add to the
    * STM (in case the data includes the Id).
    *
    * Always an S operation, since it puts a new value to the STM and creates a new Id.
    * Note that if `create` contains any U operations, then this is also a U operation AS WELL AS an S operation.
    *
    * @param create   Function to create data from Id, as an F[A]
    * @param idCodec  Used to encode/decode data
    *                 and deltas
    * @tparam A       The type of data
    * @return         The created data
    */
  def putF[A](create: Id[A] => F[A])(implicit idCodec: IdCodec[A]): F[A]

  /**
    * Put a new value into the STM. This will create a new
    * Id, and this is used to create the data to add to the
    * STM (in case the data includes the Id).
    *
    * Always an S operation, since it puts a new value to the STM and creats a new Id.
    * Never a U operation, since `create` does not use the STM and so cannot contain U operations.
    *
    * @param create   Function to create data from Id, as an A
    * @param idCodec  Used to encode/decode data
    *                 and deltas
    * @tparam A       The type of data
    * @return         The created data
    */
  def put[A](create: Id[A] => A)(implicit idCodec: IdCodec[A]): F[A] = putF(create.andThen(pure))

  /**
    * Modify data at an [[Id]]
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
    * This will create a new Id, and this is used to create the data to add to the
    * STM (in case the data includes the Id).
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
    * @param list The OTList
    * @param op   The operation to apply
    * @tparam A   The type of data in the list
    * @return     The new list contents
    */
  def otListOperation[A](list: OTList[A], op: Operation[A]): F[OTList[A]]

}



