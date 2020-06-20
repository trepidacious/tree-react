package org.rebeam.tree.slinkify

import cats.Monad
import cats.implicits._
import org.rebeam.tree.Ref

object Implicits {

  implicit class RefList[A](l: List[Ref[A]]) {
    
    /**
      * Produce a list of Cursors from a list of refs, using ReactViewOps.
      * Curosrs are produced at the referenced Id
      */
    def cursors[F[_]: Monad](implicit v: ReactViewOps[F]): F[List[Cursor[A]]] =
      l.traverse(ref => v.cursorAt(ref.id))
  }

}
