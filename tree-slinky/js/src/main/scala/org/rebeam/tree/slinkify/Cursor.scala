package org.rebeam.tree.slinkify

import monocle.{Lens, Optional, Prism}
import org.rebeam.tree._

import Syntax._

/**
  * Combine a data model with a DeltaCursor to produce a Cursor for
  * use in React. This provides methods to navigate data using lenses,
  * prisms and optionals, as well as to produce callbacks that will
  * apply a delta or set a new value using a transaction.
  * @param a            The data model
  * @param deltaCursor  The cursor allowing editing of the data model
  * @tparam A           The type of data model
  */
case class Cursor[A](a: A, deltaCursor: DeltaCursor[A]) {

  def delta(delta: Delta[A])(implicit tx: ReactTransactor): Callback =
    tx.transact(deltaCursor.transact(delta))

  def set(a: A)(implicit tx: ReactTransactor): Callback =
    tx.transact(deltaCursor.set(a))

  def zoom[B](lens: Lens[A, B]): Cursor[B] =
    Cursor(lens.get(a), deltaCursor.zoom(lens))

  def refract[B](prism: Prism[A, B]): Option[Cursor[B]] =
    prism.getOption(a).map(b => Cursor(b, deltaCursor.refract(prism)))

  def zoomOptional[B](optional: Optional[A, B]): Option[Cursor[B]] =
    optional.getOption(a).map(b => Cursor(b, deltaCursor.zoomOptional(optional)))
}
