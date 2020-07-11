package org.rebeam.tree.slinkify

import cats.Monad
import cats.implicits._
import org.rebeam.tree.Ref
import org.rebeam.tree.API.Read
import org.rebeam.tree.slinkify.API.ReactView
import ReactView._

object Implicits {

  implicit class SlinkifyRefList[A](l: List[Ref[A]]) {
    
    /**
      * Produce a list of Cursors from a list of refs, using ReactViewOps.
      * Curosrs are produced at the referenced Id
      */
    def cursors: ReactView[List[Cursor[A]]] =
      l.traverse(ref => cursorAt(ref.id))
  }

}
