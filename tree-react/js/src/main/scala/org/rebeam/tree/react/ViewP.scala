package org.rebeam.tree.react

import japgolly.scalajs.react._
import japgolly.scalajs.react.component.Scala.Component
import japgolly.scalajs.react.vdom.VdomNode
import org.rebeam.tree.DeltaCursor

/**
  * A "pure" View that does not access data context. This provides three things relative to just using ScalaComponent.builder
  * 1. Assumes immutable data and supplies suitable Reusability
  * 2. Uses similar syntax to View
  * 3. Allows Idea to quickly get the correct type annotation (this is just a bonus, not a factor in
  *    deciding to have this trait available!)
  * @tparam A The data type viewed
  */
trait ViewP[A] {
  def apply(a: A): VdomNode
  def build(name: String)(implicit ir: ImmutableReusability[A]): Component[A, Unit, Unit, CtorType.Props] =
    ScalaComponent.builder[A](name).render_P(this.apply).build
}

trait ViewPC[A] {
  def apply(a: DeltaCursor[A])(implicit tx: ReactTransactor): VdomNode
  def build(name: String, tx: ReactTransactor)(implicit ir: ImmutableReusability[A]): Component[DeltaCursor[A], Unit, Unit, CtorType.Props] =
    ScalaComponent.builder[DeltaCursor[A]](name).render_P(a => this.apply(a)(tx)).build
}

