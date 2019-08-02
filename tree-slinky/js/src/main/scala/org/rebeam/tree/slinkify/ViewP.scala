package org.rebeam.tree.slinkify

import org.rebeam.tree.slinkify.ReactData.ReactDataContexts
import slinky.core.FunctionalComponent
import slinky.core.facade.{React, ReactElement}
import slinky.core.facade.Hooks._

/**
  * A "pure" View that does not access data context. This provides three things relative to just using ScalaComponent.builder
  * 1. Assumes immutable data and supplies suitable Reusability
  * 2. Uses similar syntax to View
  * 3. Allows Idea to quickly get the correct type annotation (this is just a bonus, not a factor in
  *    deciding to have this trait available!)
  * @tparam A The data type viewed
  */
trait ViewP[A] {
  def apply(a: A): ReactElement

  def build()(implicit ir: Reusability[A]): FunctionalComponent[A] = {
    val c = FunctionalComponent[A]{
      props => ViewP.this.apply(props)
    }
    React.memo(c, (a, b) => ir.test(a, b))
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

  def apply(a: Cursor[A])(implicit tx: ReactTransactor): ReactElement

  def build(contexts: ReactDataContexts = ReactData.defaultContexts)
           (implicit ir: Reusability[A]): FunctionalComponent[Cursor[A]] = {
    implicit val r: Reusability[Cursor[A]] = ir.cursorReusability[A]

    val c = FunctionalComponent[Cursor[A]] {
      props =>
        val tx = useContext(contexts.transactor)
        ViewPC.this.apply(props)(tx)
    }

    React.memo(c, (a, b) => r.test(a, b))
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
  def apply(a: Cursor[A], b: Cursor[B])(implicit tx: ReactTransactor): ReactElement

  def build(name: String, contexts: ReactDataContexts = ReactData.defaultContexts)
           (implicit irA: Reusability[A], irB: Reusability[B]): FunctionalComponent[(Cursor[A], Cursor[B])] = {
    implicit val rA: Reusability[Cursor[A]] = irA.cursorReusability[A]
    implicit val rB: Reusability[Cursor[B]] = irB.cursorReusability[B]

    val c = FunctionalComponent[(Cursor[A], Cursor[B])] {
      props =>
        val tx = useContext(contexts.transactor)
        ViewPC2.this.apply(props._1, props._2)(tx)
    }

    React.memo(c, (a, b) => rA.test(a._1, b._1) && rB.test(a._2, b._2))
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
  def apply(a: A)(implicit tx: ReactTransactor): ReactElement

  def build(name: String, contexts: ReactDataContexts = ReactData.defaultContexts)
           (implicit ir: Reusability[A]): FunctionalComponent[A] = {

    val c = FunctionalComponent[A] {
      props =>
        val tx = useContext(contexts.transactor)
        ViewPT.this.apply(props)(tx)
    }

    // SAM implementation of BasicFunctionalComponent
    React.memo(c, (a, b) => ir.test(a, b))
  }
}