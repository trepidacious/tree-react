package org.rebeam.tree.slinkify

import cats.Monad
import cats.implicits._
import org.rebeam.tree.{DeltaCursor, Id, ViewOps}

/**
  * ViewOps (allowing getting the value at an Id) providing an additional op to make a cursor at a given Id
  * @tparam F The Monad used for ops
  */
abstract class ReactViewOps[F[_]: Monad] extends ViewOps[F] {

  /**
    * Produce a cursor at a given id, containing the current data at that Id, and
    * a DeltaCursor producing transactions editing the value at that Id.
    * @param id   The Id
    * @tparam A   The type of data
    */
  def cursorAt[A](id: Id[A]): F[Cursor[A]] =
    get(id).map(a => Cursor(a, DeltaCursor.AtId(id)))

}
