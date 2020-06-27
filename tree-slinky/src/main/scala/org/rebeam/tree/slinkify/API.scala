package org.rebeam.tree.slinkify

import cats.Monad
import cats.implicits._
import org.rebeam.Program
import org.rebeam.tree.API._
import org.rebeam.tree.Id
import org.rebeam.tree.DeltaCursor

object API {

    import Program._

    type ReactView[A] = Program[A, ReactViewOps]

    trait ReactViewBase extends ViewBase {
      /**
        * Produce a cursor at a given id, containing the current data at that Id, and
        * a DeltaCursor producing transactions editing the value at that Id.
        * @param id   The Id
        * @tparam A   The type of data
        */
      def cursorAt[A](id: Id[A]): ReactView[Cursor[A]] =
        get(id).map(a => Cursor(a, DeltaCursor.AtId(id)))
    }

    object ReactView extends ReactViewBase

}
