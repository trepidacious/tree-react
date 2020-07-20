package org.rebeam.tree.slinkify

import org.rebeam.tree.Identified
import org.rebeam.tree.Identifiable

trait Keyed[A] {
  def keyOf(a: A): String
}

object Keyed {
  implicit def keyedIdentified[A <: Identified[A]]: Keyed[A] = _.id.toString
  implicit def keyedIdentifiable[A](implicit id: Identifiable[A]): Keyed[A] = id.id(_).toString
}