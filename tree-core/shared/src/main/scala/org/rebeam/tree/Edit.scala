package org.rebeam.tree

import cats.Monad
import cats.implicits._
import org.rebeam.tree.codec.IdCodec
import org.rebeam.tree.ot.OTList
import org.rebeam.tree.ot.Operation

/**
  * An Edit can produce a value using EditOps, in any Monad F. This represents
  * an atomic operation performed using the EditOps, getting/setting data, etc.
  * and then returning a result.
  */
trait Edit[A] {
  def apply[F[_]: Monad](implicit editOps: EditOps[F]): F[A]
}

object Edit {

  lazy implicit val monadInstance: Monad[Edit] = new Monad[Edit] {
    override def pure[A](x: A): Edit[A] = Edit.pure(x)
    override def flatMap[A, B](fa: Edit[A])(f: A => Edit[B]): Edit[B] = new Edit[B] {
      def apply[F[_]: Monad](implicit editOps: EditOps[F]): F[B] = fa[F].flatMap(a => f(a)[F])
    }
    override def tailRecM[A, B](a: A)(f: A => Edit[Either[A,B]]): Edit[B] = {
      new Edit[B] {
        override def apply[F[_] : Monad](implicit editOps: EditOps[F]): F[B] = {
          implicitly[Monad[F]].tailRecM(a)(a => f(a).apply[F])
        }
      }
    }
  }

  def pure[A](a: A) = new Edit[A] {
    def apply[F[_]: Monad](implicit editOps: EditOps[F]): F[A] = editOps.pure(a)
  }

  /**
    * Get data at an [[Id]].
    * 
    * This will cause the ReadOps to fail
    * if the data is not available.
    * 
    * If possible, systems that cache only part of the STM
    * will retry the operation when missing data has been 
    * retrieved.
    * 
    * U operation when part of an Edit - makes STM data at id available to subsequent transactions.
    * 
    * @param id   The data's [[Id]]
    * @tparam A   Type of data
    * @return     The data at specified [[Id]]
    */
  def get[A](id: Id[A]): Edit[A] = new Edit[A] {
    def apply[F[_]: Monad](implicit editOps: EditOps[F]): F[A] = editOps.get(id)
  }

  /**
    * Create a pseudo-random Int
    *
    * This is an S operation - see EditOps docs for details
    */
  def randomInt: Edit[Int] = new Edit[Int] {
    def apply[F[_]: Monad](implicit editOps: EditOps[F]): F[Int] = editOps.randomInt
  }

  /**
    * Create a pseudo-random Int x, where 0 <= x < bound
    *
    * This is an S operation - see EditOps docs for details
    */
  def randomIntUntil(bound: Int): Edit[Int] = new Edit[Int] {
    def apply[F[_]: Monad](implicit editOps: EditOps[F]): F[Int] = editOps.randomIntUntil(bound)
  }

  /**
    * Create a pseudo-random Long
    *
    * This is an S operation - see EditOps docs for details
    */
  def randomLong: Edit[Long]  = new Edit[Long] {
    def apply[F[_]: Monad](implicit editOps: EditOps[F]): F[Long] = editOps.randomLong
  }

  /**
    * Create a pseudo-random Boolean
    *
    * This is an S operation - see EditOps docs for details
    */
  def randomBoolean: Edit[Boolean] = new Edit[Boolean] {
    def apply[F[_]: Monad](implicit editOps: EditOps[F]): F[Boolean] = editOps.randomBoolean
  }

  /**
    * Create a pseudo-random Float
    *
    * This is an S operation - see EditOps docs for details
    */
  def randomFloat: Edit[Float] = new Edit[Float] {
    def apply[F[_]: Monad](implicit editOps: EditOps[F]): F[Float] = editOps.randomFloat
  }

  /**
    * Create a pseudo-random Double
    *
    * This is an S operation - see EditOps docs for details
    */
  def randomDouble: Edit[Double] = new Edit[Double] {
    def apply[F[_]: Monad](implicit editOps: EditOps[F]): F[Double] = editOps.randomDouble
  }

  /**
    * Get the TransactionContext for this transaction
    *
    * This is neither a U nor an S operation - see EditOps docs for details of what is meant by this terminology.
    * FIXME this should maybe be U - it provides the Moment, which could then be used to drive differences in
    * execution. However transactionId is fine - split these up?
    */
  def context: Edit[TransactionContext] = new Edit[TransactionContext] {
    def apply[F[_]: Monad](implicit editOps: EditOps[F]): F[TransactionContext] = editOps.context
  }

  /**
    * Modify data at an [[Id]]
    *
    * U operation - makes the original STM data at id, and modified data, available to subsequent transactions.
    * If f is unstable, this operation will also render transactions unstable.
    *
    * @param id   The data's [[Id]]
    * @param f    Function to transform old value to new one, as an Edit[A]
    * @tparam A   Type of data
    * @return     The modified data
    */
  def modifyF[A](id: Id[A], f: A => Edit[A]): Edit[A] = new Edit[A] {
    def apply[F[_]: Monad](implicit editOps: EditOps[F]): F[A] = editOps.modifyF(id, a => f(a).apply[F])
  }

  /**
   * Modify data at an [[Id]]
   *
   * This version does not return the modified result - this means that the operation is not U. However note that
   * if the f function renders the transaction unstable in itself, the transaction will still be unstable.
   *
   * @param id   The data's [[Id]]
   * @param f    Function to transform old value to new one, as an Edit[A]
   * @tparam A   Type of data
   * @return     Unit - if you require the result of the modification, use [[modifyF]] instead.
   */
  def modifyFUnit[A](id: Id[A], f: A => Edit[A]): Edit[Unit] = new Edit[Unit] {
    def apply[F[_]: Monad](implicit editOps: EditOps[F]): F[Unit] = editOps.modifyFUnit(id, (a: A) => f(a).apply[F])
  }

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
  def modify[A](id: Id[A], f: A => A): Edit[A] = new Edit[A] {
    def apply[F[_]: Monad](implicit editOps: EditOps[F]): F[A] = editOps.modify(id, f)
  }

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
  def modifyUnit[A](id: Id[A], f: A => A): Edit[Unit] = new Edit[Unit] {
    def apply[F[_]: Monad](implicit editOps: EditOps[F]): F[Unit] = editOps.modifyUnit(id, f)
  }

  /**
    * Create a new Guid for general-purpose use (e.g. for Logoot)
    *
    * S operation, since it creates a new Guid.
    *
    * @return   The new Guid
    */
  def createGuid: Edit[Guid] = new Edit[Guid] {
    def apply[F[_]: Monad](implicit editOps: EditOps[F]): F[Guid] = editOps.createGuid
  }

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
   * @param create   Function to create data from Id, as an Edit[A]
   * @param idCodec  Used to encode/decode data
   *                 and deltas
   * @tparam A       The type of data
   * @return         The created data, and its Id
   */
  def putFWithId[A](create: Id[A] => Edit[A])(implicit idCodec: IdCodec[A]): Edit[(A, Id[A])] = new Edit[(A, Id[A])] {
    def apply[F[_]: Monad](implicit editOps: EditOps[F]): F[(A, Id[A])] = editOps.putFWithId(id => create(id).apply[F])
  }

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
    * @param create   Function to create data from Id, as an Edit[A]
    * @param idCodec  Used to encode/decode data
    *                 and deltas
    * @tparam A       The type of data
    * @return         The created data
    */
  def putF[A](create: Id[A] => Edit[A])(implicit idCodec: IdCodec[A]): Edit[A] = new Edit[A] {
    def apply[F[_]: Monad](implicit editOps: EditOps[F]): F[A] = editOps.putF(id => create(id).apply[F])
  }

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
   * @param create   Function to create data from Id, as an Edit[A]
   * @param idCodec  Used to encode/decode data
   *                 and deltas
   * @tparam A       The type of data
   * @return         The created data
   */
  def putFJustId[A](create: Id[A] => Edit[A])(implicit idCodec: IdCodec[A]): Edit[Id[A]] = new Edit[Id[A]] {
    def apply[F[_]: Monad](implicit editOps: EditOps[F]): F[Id[A]] = editOps.putFJustId(id => create(id).apply[F])
  }

  // /**
  //  * Put a new value into the STM. This will create a new
  //  * Id, and this is used to create the data to add to the
  //  * STM (in case the data includes the Id).
  //  *
  //  * Always an S operation, since it puts a new value to the STM and creates a new Id.
  //  * Never a U operation, since `create` does not use the STM and so cannot contain U operations (and for
  //  * this reason the returned data contains no STM data that might change - only data created by the create
  //  * function).
  //  *
  //  * @param create   Function to create data from Id, as an A
  //  * @param idCodec  Used to encode/decode data
  //  *                 and deltas
  //  * @tparam A       The type of data
  //  * @return         The created data, and its Id
  //  */
  def putWithId[A](create: Id[A] => A)(implicit idCodec: IdCodec[A]): Edit[(A, Id[A])] = new Edit[(A, Id[A])] {
    def apply[F[_]: Monad](implicit editOps: EditOps[F]): F[(A, Id[A])] = editOps.putWithId(create)
  }

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
  def put[A](create: Id[A] => A)(implicit idCodec: IdCodec[A]): Edit[A] = new Edit[A] {
    def apply[F[_]: Monad](implicit editOps: EditOps[F]): F[A] = editOps.put(create)
  }

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
    * @param create   Function to create data as an `Edit[List[A]]`
    * @param idCodec  Used to encode/decode data
    *                 and deltas
    * @tparam A       The type of data in the List
    * @return         The created List
    */
  def createOTListF[A](create: Edit[List[A]])(implicit idCodec: IdCodec[OTList[A]]): Edit[OTList[A]] = new Edit[OTList[A]] {
    def apply[F[_]: Monad](implicit editOps: EditOps[F]): F[OTList[A]] = editOps.createOTListF(create.apply[F])
  }

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
  def createOTList[A](create: List[A])(implicit idCodec: IdCodec[OTList[A]]): Edit[OTList[A]] = new Edit[OTList[A]] {
    def apply[F[_]: Monad](implicit editOps: EditOps[F]): F[OTList[A]] = editOps.createOTList(create)
  }

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
   * @param create   Function to create data as an `Edit[List[A]]`
   * @param idCodec  Used to encode/decode data
   *                 and deltas
   * @return         The created List
   */
  def createOTStringF(create: Edit[String])(implicit idCodec: IdCodec[OTList[Char]]): Edit[OTList[Char]] = new Edit[OTList[Char]] {
    def apply[F[_]: Monad](implicit editOps: EditOps[F]): F[OTList[Char]] = editOps.createOTStringF(create.apply[F])
  }

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
  def createOTString(create: String)(implicit idCodec: IdCodec[OTList[Char]]): Edit[OTList[Char]] = new Edit[OTList[Char]] {
    def apply[F[_]: Monad](implicit editOps: EditOps[F]): F[OTList[Char]] = editOps.createOTString(create)
  }

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
  def otListOperation[A](list: OTList[A], op: Operation[A]): Edit[OTList[A]] = new Edit[OTList[A]] {
    def apply[F[_]: Monad](implicit editOps: EditOps[F]): F[OTList[A]] = editOps.otListOperation(list, op)
  }

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
  def otListOperationUnit[A](list: OTList[A], op: Operation[A]): Edit[Unit] = new Edit[Unit] {
    def apply[F[_]: Monad](implicit editOps: EditOps[F]): F[Unit] = editOps.otListOperationUnit(list, op)
  }
}