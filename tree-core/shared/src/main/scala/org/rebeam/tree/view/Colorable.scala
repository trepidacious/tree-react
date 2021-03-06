package org.rebeam.tree.view

/**
  * Typeclass for things having a color
  * @tparam A The type of thing
  */
trait Colorable[A] {
  def colorOf(a:A): Color
}

trait Colored {
  def color: Color
}

object Colorable {
  implicit val colorableColor: Colorable[Color] = c => c
  implicit def coloredColor[A <: Colored]: Colorable[A] = c => c.color
}
