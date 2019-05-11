package org.rebeam.tree

import cats.Monad
import org.rebeam.tree.ot.CursorUpdate

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
    * Get [[List]] data at an [[Id]].
    * This expects the list to have operational transformation
    * support, and so will also return a [[CursorUpdate]] allowing
    * views to update cursors into the list.
    * This will cause the ViewOps to fail
    * if the data and ClientState is not available.
    * The data will be retrieved if possible, and the
    * view will be re-displayed. If the id
    * is not retrievable, the view will stay
    * failed.
    * @param id   The data's [[Id]]
    * @tparam A   Type of data
    * @return     The data and [[CursorUpdate]] at specified [[Id]]
    */
  def getList[A](id: Id[List[A]]): F[(List[A], CursorUpdate[A])]

  /**
    * Get [[List]] data at an [[Id]].
    * This expects the list to have operational transformation
    * support, and so will also return a [[CursorUpdate]] allowing
    * views to update cursors into the list.
    * This will return F[None] if the data is not
    * available. The data will be retrieved
    * if possible, and the view will be
    * re-displayed. If the id is not
    * retrievable, the view will not be redisplayed.
    * @param id   The data's [[Id]]
    * @tparam A   Type of data
    * @return     The data and [[CursorUpdate]] at specified [[Id]]
    */
  def getListOption[A](id: Id[List[A]]): F[Option[(List[A], CursorUpdate[A])]]
}



