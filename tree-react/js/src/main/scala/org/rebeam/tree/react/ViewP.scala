package org.rebeam.tree.react

import japgolly.scalajs.react._
import japgolly.scalajs.react.component.Scala.Component
import japgolly.scalajs.react.extra.Reusability
import japgolly.scalajs.react.vdom.VdomNode
import org.rebeam.tree.react.ReactData.ReactDataContexts

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
  def build(name: String)(implicit ir: ImmutableReusability[A]): Component[A, Unit, Unit, CtorType.Props] = {
    implicit val r: Reusability[A] = ir.reusability[A]
    ScalaComponent.builder[A](name)
      .render_P(this.apply)
      .configure(Reusability.shouldComponentUpdate)
      .build
  }
}

/**
  * A "pure" View that does not access data context, except via a Cursor, which
  * also requires a ReactTransactor.
  *
  * This provides three things relative to just using ScalaComponent.builder
  * 1. Assumes immutable data in the Cursor and supplies suitable Reusability
  * 2. Uses similar syntax to View
  * 3. Allows Idea to quickly get the correct type annotation (this is just a bonus, not a factor in
  *    deciding to have this trait available!)
  * @tparam A The data type viewed via a Cursor
  **/
trait ViewPC[A] {
  def apply(a: Cursor[A])(implicit tx: ReactTransactor): VdomNode
  def build(name: String, contexts: ReactDataContexts = ReactData.defaultContexts)(implicit ir: ImmutableReusability[A]): Component[Cursor[A], Unit, Unit, CtorType.Props] = {
    implicit val r: Reusability[Cursor[A]] = ir.cursorReusability[A]
    ScalaComponent.builder[Cursor[A]](name)
      .render_P(
        a => contexts.transactor.consume(
          tx => this.apply(a)(tx)
        )
      )
      .configure(Reusability.shouldComponentUpdate)
      .build
  }
}

