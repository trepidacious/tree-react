package org.rebeam.tree

import cats.Monad
import org.rebeam.tree.codec.IdCodec
//import org.rebeam.tree.ot.{OTList, Operation}

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
  * 1. Produce an error when executing on the client, and reject the transaction. This then becomes
  *    a task for the user of tree to fix - all transactions must be adjusted to be stable. All
  *    transactions can then be run concurrently/optimistically.
  *
  * 2. Execute the transaction, but then enter a synchronous mode - the client will not display the result
  *    of the transaction (since it may change), and will not accept new transactions, until a response
  *    is received from the server including the unstable transaction. At this point the server result
  *    is known, and can be used as the authoritative result for further transactions. The client can display
  *    this state with some kind of spinner.
  *
  * It may also be reasonable to adapt approach 2, so that the result of the unstable transaction is not
  * displayed, but further transactions are accepted. This should work, since the unstable transaction
  * essentially becomes equivalent to a remote transaction - its results are not visible until it is executed
  * by the server. This reduces the impact of the synchronous execution - the user will only be delayed if
  * they need to work with the data produced by the unstable transaction.
  *
  * The algorithm for classifying transactions as stable or unstable is as follows:
  * 1. Each operation is classified as N (for non-deterministic - operation itself may produce different results
  *    on the server to the client), or D (for deterministic - operation produces results dependent only on
  *    data outside the STM).
  * 2.
  *
  *
  *
  * @tparam F The monad used to express operations
  */
abstract class STMOps[F[_]: Monad] extends TransactionOps {

  /**
    * Get data at an [[Id]]
    *
    * N operation.
    *
    * @param id   The data's [[Id]]
    * @tparam A   Type of data
    * @return     The data at specified [[Id]]
    */
  def get[A](id: Id[A]): F[A]

  /**
    * Modify data at an [[Id]]
    *
    * N operation.
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
    * D operation. Note that if create is an N operation, then this
    * is also an N operation AS WELL AS a D operation.
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
    * D operation.
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
    * N operation.
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
    * D operation.
    *
    * @return   The new Guid
    */
  def createGuid: F[Guid]

//  /**
//    * Put a new List value into the STM, with operational transformation
//    * support.
//    * This will create a new Id, and this is used to create the data to add to the
//    * STM (in case the data includes the Id).
//    *
//    * @param create   Function to create data as an `F[List[A]]`
//    * @param idCodec  Used to encode/decode data
//    *                 and deltas
//    * @tparam A       The type of data in the List
//    * @return         The created List
//    */
//  def createOTListF[A](create: F[List[A]])(implicit idCodec: IdCodec[A]): F[OTList[A]]
//
//  /**
//    * Put a new List value into the STM, with operational transformation
//    * support.
//    * This will create a new Id, and this is used to create the data to add to the
//    * STM (in case the data includes the Id).
//    *
//    * @param create   Function to create data from Id, as a `List[A]`
//    * @param idCodec  Used to encode/decode data
//    *                 and deltas
//    * @tparam A       The type of data in the List
//    * @return         The created List
//    */
//  def createOTList[A](create: List[A])(implicit idCodec: IdCodec[A]): F[OTList[A]] = createOTListF(pure(create))
//
//  /**
//    * Apply an OT operation to an OTlist.
//    * @param list The OTList
//    * @param op   The operation to apply
//    * @tparam A   The type of data in the list
//    * @return     The new list contents
//    */
//  def otListOperation[A](list: OTList[A], op: Operation[A]): F[OTList[A]]

}



