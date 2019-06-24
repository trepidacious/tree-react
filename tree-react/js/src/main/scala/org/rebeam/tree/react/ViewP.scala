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

/**
  * A "pure" View that does not access data context, except via a pair of Cursors, which
  * also require a ReactTransactor.
  *
  * This provides three things relative to just using ScalaComponent.builder
  * 1. Assumes immutable data in the Cursors and supplies suitable Reusability
  * 2. Uses similar syntax to View
  * 3. Allows Idea to quickly get the correct type annotation (this is just a bonus, not a factor in
  *    deciding to have this trait available!)
  * @tparam A The data type viewed via first Cursor
  * @tparam B The data type viewed via second Cursor
  **/
trait ViewPC2[A, B] {
  def apply(a: Cursor[A], b: Cursor[B])(implicit tx: ReactTransactor): VdomNode
  def build(name: String, contexts: ReactDataContexts = ReactData.defaultContexts)(implicit irA: ImmutableReusability[A], irB: ImmutableReusability[B]): Component[(Cursor[A], Cursor[B]), Unit, Unit, CtorType.Props] = {
    implicit val rA: Reusability[Cursor[A]] = irA.cursorReusability[A]
    implicit val rB: Reusability[Cursor[B]] = irB.cursorReusability[B]

    ScalaComponent.builder[(Cursor[A], Cursor[B])](name)
      .render_P(
        p => contexts.transactor.consume(
          tx => this.apply(p._1, p._2)(tx)
        )
      )
      .configure(Reusability.shouldComponentUpdate)
      .build
  }
}

/**
  * A "pure" View that does not access data context, but requires a ReactTransactor.
  *
  * This provides three things relative to just using ScalaComponent.builder
  * 1. Assumes immutable data in the Cursor and supplies suitable Reusability
  * 2. Uses similar syntax to View
  * 3. Allows Idea to quickly get the correct type annotation (this is just a bonus, not a factor in
  *    deciding to have this trait available!)
  * @tparam A The data type viewed
  **/
trait ViewPT[A] {
  def apply(a: A)(implicit tx: ReactTransactor): VdomNode

  def build(name: String, contexts: ReactDataContexts = ReactData.defaultContexts)(implicit ir: ImmutableReusability[A]): Component[A, Unit, Unit, CtorType.Props] = {
    implicit val r: Reusability[A] = ir.reusability[A]
    ScalaComponent.builder[A](name)
      .render_P(
        a => contexts.transactor.consume(
          tx => this.apply(a)(tx)
        )
      )
      .configure(Reusability.shouldComponentUpdate)
      .build
  }
}