package org.rebeam.tree.slinkify

import org.rebeam.tree.slinkify.ReactData.ReactDataContexts
import org.rebeam.tree.slinkify.Syntax.BasicFunctionalComponent
import slinky.core.StatelessComponent
import slinky.core.annotations.react
import slinky.core.facade.ReactElement
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
  def build(implicit ir: Reusability[A]): BasicFunctionalComponent[A] = {

    @react class C extends StatelessComponent {
      type Props = A
      override def shouldComponentUpdate(nextProps: A, nextState: Unit): Boolean =
        ir.test(props, nextProps)
      def render: ReactElement = ViewP.this.apply(props)
    }

    // SAM implementation of BasicFunctionalComponent
    a: A => C(a)
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
           (implicit ir: Reusability[A]): BasicFunctionalComponent[Cursor[A]] = {
    implicit val r: Reusability[Cursor[A]] = ir.cursorReusability[A]

    @react class C extends StatelessComponent {
      type Props = Cursor[A]
      override def shouldComponentUpdate(nextProps: Cursor[A], nextState: Unit): Boolean =
        r.test(props, nextProps)
      def render: ReactElement = {
        val tx = useContext(contexts.transactor)
        ViewPC.this.apply(props)(tx)
      }
    }

    // SAM implementation of BasicFunctionalComponent
    a: Cursor[A] => C(a)
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
           (implicit irA: Reusability[A], irB: Reusability[B]): BasicFunctionalComponent[(Cursor[A], Cursor[B])] = {
    implicit val rA: Reusability[Cursor[A]] = irA.cursorReusability[A]
    implicit val rB: Reusability[Cursor[B]] = irB.cursorReusability[B]

    @react class C extends StatelessComponent {
      type Props = (Cursor[A], Cursor[B])
      override def shouldComponentUpdate(nextProps: (Cursor[A], Cursor[B]), nextState: Unit): Boolean =
        rA.test(props._1, nextProps._1) && rB.test(props._2, nextProps._2)
      def render: ReactElement = {
        val tx = useContext(contexts.transactor)
        ViewPC2.this.apply(props._1, props._2)(tx)
      }
    }

    // SAM implementation of BasicFunctionalComponent
    a: (Cursor[A], Cursor[B]) => C(a)
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
           (implicit ir: Reusability[A]): BasicFunctionalComponent[A] = {

    @react class C extends StatelessComponent {
      type Props = A
      override def shouldComponentUpdate(nextProps:A, nextState: Unit): Boolean =
        ir.test(props, nextProps)

      def render: ReactElement = {
        val tx = useContext(contexts.transactor)
        ViewPT.this.apply(props)(tx)
      }
    }

    // SAM implementation of BasicFunctionalComponent
    a: A => C(a)
  }
}