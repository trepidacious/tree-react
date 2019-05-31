package org.rebeam.tree

import cats.Monad
import org.rebeam.tree.codec.IdCodec
import org.rebeam.tree.ot.{OTList, Operation}

abstract class STMOps[F[_]: Monad] extends TransactionOps {

  /**
    * Get data at an [[Id]]
    * @param id   The data's [[Id]]
    * @tparam A   Type of data
    * @return     The data at specified [[Id]]
    */
  def get[A](id: Id[A]): F[A]

  /**
    * Modify data at an [[Id]]
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
    * @param create   Function to create data from Id, as an A
    * @param idCodec  Used to encode/decode data
    *                 and deltas
    * @tparam A       The type of data
    * @return         The created data
    */
  def put[A](create: Id[A] => A)(implicit idCodec: IdCodec[A]): F[A] = putF(create.andThen(pure))

  /**
    * Modify data at an [[Id]]
    * @param id   The data's [[Id]]
    * @param f    Function to transform old value to new one, as an A
    * @tparam A   Type of data
    * @return     The modified data
    */
  def modify[A](id: Id[A], f: A => A): F[A] = modifyF(id, f.andThen(pure))

  /**
    * Create a new Guid for general-purpose use (e.g. for Logoot)
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
  def createOTListF[A](create: F[List[A]])(implicit idCodec: IdCodec[A]): F[OTList[A]]

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
  def createOTList[A](create: List[A])(implicit idCodec: IdCodec[A]): F[OTList[A]] = createOTListF(pure(create))

  /**
    * Apply an OT operation to an OTlist.
    * @param list The OTList
    * @param op   The operation to apply
    * @tparam A   The type of data in the list
    * @return     The new list contents
    */
  def otListOperation[A](list: OTList[A], op: Operation[A]): F[OTList[A]]

}



