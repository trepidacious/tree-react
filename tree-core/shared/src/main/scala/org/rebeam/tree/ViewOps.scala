package org.rebeam.tree

import cats.Monad
import org.rebeam.tree.ot.{CursorUpdate, OTList}

/**
  * Provides ops to get the data at an Id
  * @tparam F The Monad used for ops
  */
abstract class ViewOps[F[_]: Monad] {

  /**
    * Get data at an [[Id]].
    * This will cause the ViewOps to fail
    * if the data is not available. The data
    * will be retrieved if possible, and the
    * view will be re-displayed. If the id
    * is not retrievable, the view will stay
    * failed.
    * @param id   The data's [[Id]]
    * @tparam A   Type of data
    * @return     The data at specified [[Id]]
    */
  def get[A](id: Id[A]): F[A]

  /**
    * Get data at an [[Id]].
    * This will return F[None] if the data is not
    * available. The data will be retrieved
    * if possible, and the view will be
    * re-displayed. If the id is not
    * retrievable, the view will not be redisplayed.
    * @param id   The data's [[Id]]
    * @tparam A   Type of data
    * @return     The data at specified [[Id]], or
    *             None if not available.
    */
  def getOption[A](id: Id[A]): F[Option[A]]

  // For convenience, could use Monad directly
  def pure[A](a: A): F[A] = implicitly[Monad[F]].pure(a)

  /**
    * Get the most recent cursor update for an OTList.
    * This will cause ViewOps to fail if the OTList does not exist in the STM.
    * @param list The list
    * @tparam A   Type of data in list
    * @return     The CursorUpdate for the list
    */
  def getOTListCursorUpdate[A](list: OTList[A]): F[CursorUpdate[A]]

  /**
    * Get the most recent cursor update for an OTList.
    * This will cause ViewOps to fail if the OTList does not exist in the STM.
    * @param list The list
    * @tparam A   Type of data in list
    * @return     The CursorUpdate for the list, if the list is in the STM
    */
  def getOTListCursorUpdateOption[A](list: OTList[A]): F[Option[CursorUpdate[A]]]

}



