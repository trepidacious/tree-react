package org.rebeam.tree.slinkify

import cats.Monad
import cats.data.StateT
import cats.implicits._
import org.rebeam.tree._
import slinky.core.FunctionalComponent
import slinky.core.facade.ReactElement
import slinky.web.html._
import org.rebeam.tree.ot.{CursorUpdate, OTList}
import ReactData.ReactDataContexts
import org.rebeam.tree.slinkify.API.ReactView
import slinky.core.FunctionalComponentName
import slinky.core.facade.Hooks._
import slinky.core.facade.{React, ReactElement}

object View {

  /**
    * Ops provides an implementation of ReactViewOps for ViewFunctions to use to
    * render. This is based on a DataSource
    */
  object Ops {

    /**
      * The data for a StateT monad that will run ReactViewOps
      * @param dataSource     The source of data
      * @param viewedGuids    The set of Guids from Refs used to view (get) data
      * @param missingGuids   The set of Guids from Refs used to attempt to view data, where the data
      *                       is currently missing (e.g. not locally cached).
      */
    case class StateData(
      dataSource: DataSource,
      viewedGuids: Set[Guid] = Set.empty,
      missingGuids: Set[Guid] = Set.empty
    ) {
      def viewed(guid: Guid): StateData = copy(viewedGuids = viewedGuids + guid)
      def missed(guid: Guid): StateData = copy(missingGuids = missingGuids + guid)
    }

    def initialStateData(dataSource: DataSource): StateData = StateData(dataSource, Set.empty, Set.empty)

    type ErrorOr[A] = Either[DataError, A]
    type S[A] = StateT[ErrorOr, StateData, A]

    // TODO can we extend DataSourceViewOps somehow to share code?
    implicit val reactViewOpsInstance: ReactViewOps[S] = new ReactViewOps[S] {
      def get[A](id: Id[A]): S[A] =
        StateT[ErrorOr, StateData, A](sd => {
          //Get data as an option, map this to an Option[(StateData, A)] by adding a new state
          //updated to record viewing the id, then convert to an ErrorOr with appropriate
          //Error on missing data. This is the S => F[S, A] required by StateT.
          sd.dataSource.get(id)
            .map((sd.viewed(id.guid), _))
            .toRight(DataError(
              id.guid,
              sd.viewedGuids + id.guid,
              sd.missingGuids + id.guid
            ))
        })

      def getOption[A](id: Id[A]): S[Option[A]] =
        StateT[ErrorOr, StateData, Option[A]](sd => {
          sd.dataSource.get(id).fold[ErrorOr[(StateData, Option[A])]](
            Right((sd.missed(id.guid).viewed(id.guid), None))
          )(
            a => Right((sd.viewed(id.guid), Some(a)))
          )
        })

      def getOTListCursorUpdate[A](list: OTList[A]): S[CursorUpdate[A]] =
        StateT[ErrorOr, StateData, CursorUpdate[A]](sd => {
          //Get update as an option, map this to an Option[(StateData, CursorUpdate[A])] by adding a new state
          //updated to record viewing the id, then convert to an ErrorOr with appropriate
          //Error on missing data. This is the S => F[S, CursorUpdate[A]] required by StateT.
          sd.dataSource.getOTListCursorUpdate(list)
            .map((sd.viewed(list.id.guid), _))
            .toRight(DataError(
              list.id.guid,
              sd.viewedGuids + list.id.guid,
              sd.missingGuids + list.id.guid
            ))
        })

      def getOTListCursorUpdateOption[A](list: OTList[A]): S[Option[CursorUpdate[A]]] =
        StateT[ErrorOr, StateData, Option[CursorUpdate[A]]](sd => {
          sd.dataSource.getOTListCursorUpdate(list).fold[ErrorOr[(StateData, Option[CursorUpdate[A]])]](
            Right((sd.missed(list.id.guid).viewed(list.id.guid), None))
          )(
            a => Right((sd.viewed(list.id.guid), Some(a)))
          )
        })

//      def getOTListCursorUpdate[A](list: OTList[A]): S[Option[CursorUpdate[A]]] =
//        StateT[ErrorOr, StateData, Option[CursorUpdate[A]]](sd => {
//          Right((sd.viewed(list.id.guid), sd.dataSource.getOTListCursorUpdate(list)))
//        })
    }

    def render[A](
      v: ViewFunction[A],
      onError: DataError => ReactElement,
      a: A,
      data: ReactData
    )(
      implicit tx: ReactTransactor
    ): DataRenderer.Result = {
      val stateData = StateData(data)
      val result = v.apply[S](a).run(stateData)
      result match {
        case Left(error) => DataRenderer.Result(onError(error), error.viewedGuids ++ error.missingGuids)
        case Right((s, vdom)) => DataRenderer.Result(vdom, s.viewedGuids ++ s.missingGuids)
      }
    }

  }

  val defaultError: DataError => ReactElement = error =>
    div(
      className := "tree-error",
      span("\u2026"),
      span(
        className := "tree-error__tooltip",
        s"Missing:\n${error.missingGuids.mkString("\n")}"
      )
    )

  def custom[A](
            contexts: ReactDataContexts = ReactData.defaultContexts,
            onError: DataError => ReactElement = View.defaultError
          )(fn: ReactTransactor => A => ReactView[ReactElement])
          (implicit name: FunctionalComponentName, ir: Reusability[A]): FunctionalComponent[A] = {
    new View[A] {
      def apply[F[_]: Monad](a: A)(implicit v: ReactViewOps[F], tx: ReactTransactor): F[ReactElement] = 
        fn(tx)(a)[F]
    }.build(name.name)
  }

  def apply[A](fn: ReactTransactor => A => ReactView[ReactElement])
    (implicit name: FunctionalComponentName, ir: Reusability[A]): FunctionalComponent[A] = custom()(fn)
}

/**
  * A ViewFunction can render an A to a VdomElement within some monad F, using
  * ReactViewOps (to get values from Ids and create Cursors) and a ReactTransactor (to
  * convert Transactions to Callbacks for React)
  * @tparam A The type of data viewed
  */
trait ViewFunction[A] {
  def apply[F[_]: Monad](a: A)(implicit v: ReactViewOps[F], tx: ReactTransactor): F[ReactElement]
}

/**
  * A ViewFunction with a build method producing a React Component (based on apply).
  * Always views an immutable data type A, which has ImmutableReusability, and which
  * is used to produce a suitable Reusability for the Component.
  *
  * Extend this trait and implement apply to create a View, then call
  * build on this View to produce a Component.
  * @tparam A The type of data viewed
  */
trait View[A] extends ViewFunction[A] {
  def build(
             name: String,
             contexts: ReactDataContexts = ReactData.defaultContexts,
             onError: DataError => ReactElement = View.defaultError
           )(implicit ir: Reusability[A]): FunctionalComponent[A] = {
    val renderer = new DataRenderer[A] {
      override def apply(a: A, data: ReactData, tx: ReactTransactor): DataRenderer.Result =
        View.Ops.render(View.this, onError, a, data)(tx)
    }
    DataComponent[A](renderer, contexts)(ir)
  }
}

/**
  * A ViewFunction with a build method producing a React Component (based on apply).
  * Always views a Cursor containing an immutable data type A, which has ImmutableReusability,
  * and which is used to produce a suitable Reusability for the Component.
  *
  * Extend this trait and implement apply to create a View, then call
  * build on this View to produce a Component.
  * @tparam A The type of data in the viewed Cursor
  */
trait ViewCursor[A] extends ViewFunction[Cursor[A]] {
  def build(
             name: String,
             contexts: ReactDataContexts = ReactData.defaultContexts,
             onError: DataError => ReactElement = View.defaultError
           )(implicit ir: Reusability[A]): FunctionalComponent[Cursor[A]] = {

    val renderer = new DataRenderer[Cursor[A]] {
      override def apply(a: Cursor[A], data: ReactData, tx: ReactTransactor): DataRenderer.Result =
      View.Ops.render(ViewCursor.this, onError, a, data)(tx)
    }
    DataComponent[Cursor[A]](renderer, contexts)(ir.cursorReusability)
  }
}

object ViewCursor {
    def custom[A](
            contexts: ReactDataContexts = ReactData.defaultContexts,
            onError: DataError => ReactElement = View.defaultError
          )(fn: ReactTransactor => Cursor[A] => ReactView[ReactElement])
          (implicit name: FunctionalComponentName, ir: Reusability[A]): FunctionalComponent[Cursor[A]] = {
    new ViewCursor[A] {
      def apply[F[_]: Monad](a: Cursor[A])(implicit v: ReactViewOps[F], tx: ReactTransactor): F[ReactElement] = 
        fn(tx)(a)[F]
    }.build(name.name)
  }

  def apply[A](fn: ReactTransactor => Cursor[A] => ReactView[ReactElement])
    (implicit name: FunctionalComponentName, ir: Reusability[A]): FunctionalComponent[Cursor[A]] = custom()(fn)
}


/**
  * A "pure" View that does not access data context. This provides three things relative to just using ScalaComponent.builder
  * 1. Assumes immutable data and supplies suitable Reusability
  * 2. Uses similar syntax to View
  * 3. Allows Idea to quickly get the correct type annotation (this is just a bonus, not a factor in
  *    deciding to have this trait available!)
  * @tparam A The data type viewed
  */
trait ViewPure[A] {
  def apply(a: A): ReactElement

  def build()(implicit ir: Reusability[A]): FunctionalComponent[A] = {
    val c = FunctionalComponent[A]{
      props => ViewPure.this.apply(props)
    }
    React.memo(c, (a, b) => ir.test(a, b))
  }
}

object ViewPure {
  def apply[A](fn: A => ReactElement)(implicit ir: Reusability[A]): FunctionalComponent[A] = {
    val c = FunctionalComponent[A](fn)
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
trait ViewPureCursor[A] {

  def apply(a: Cursor[A])(implicit tx: ReactTransactor): ReactElement

  def build(contexts: ReactDataContexts = ReactData.defaultContexts)
           (implicit ir: Reusability[A]): FunctionalComponent[Cursor[A]] = {
    implicit val r: Reusability[Cursor[A]] = ir.cursorReusability[A]

    val c = FunctionalComponent[Cursor[A]] {
      props => {
        val tx = useContext(contexts.transactor)
        ViewPureCursor.this.apply(props)(tx)
      }
    }

    React.memo(c, (a, b) => r.test(a, b))
  }
}

object ViewPureCursor {
  def apply[A](fn: ReactTransactor => Cursor[A] => ReactElement)(implicit ir: Reusability[A]): FunctionalComponent[Cursor[A]] = 
    custom()(fn)

  def custom[A](contexts: ReactDataContexts = ReactData.defaultContexts)
    (fn: ReactTransactor => Cursor[A] => ReactElement)
    (implicit ir: Reusability[A]): FunctionalComponent[Cursor[A]] = {

    implicit val r: Reusability[Cursor[A]] = ir.cursorReusability[A]

    val c = FunctionalComponent[Cursor[A]] {
      props => {
        val tx = useContext(contexts.transactor)
        fn(tx)(props)
      }
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
trait ViewPureCursorPair[A, B] {
  def apply(a: Cursor[A], b: Cursor[B])(implicit tx: ReactTransactor): ReactElement

  def build(name: String, contexts: ReactDataContexts = ReactData.defaultContexts)
           (implicit irA: Reusability[A], irB: Reusability[B]): FunctionalComponent[(Cursor[A], Cursor[B])] = {
    implicit val rA: Reusability[Cursor[A]] = irA.cursorReusability[A]
    implicit val rB: Reusability[Cursor[B]] = irB.cursorReusability[B]

    val c = FunctionalComponent[(Cursor[A], Cursor[B])] {
      props => {
        val tx = useContext(contexts.transactor)
        ViewPureCursorPair.this.apply(props._1, props._2)(tx)
      }
    }

    React.memo(c, (a, b) => rA.test(a._1, b._1) && rB.test(a._2, b._2))
  }
}

object ViewPureCursorPair {
  def apply[A, B](fn: ReactTransactor => (Cursor[A], Cursor[B]) => ReactElement)
    (implicit irA: Reusability[A], irB: Reusability[B]): FunctionalComponent[(Cursor[A], Cursor[B])] = 
    custom()(fn)

  def custom[A, B](contexts: ReactDataContexts = ReactData.defaultContexts)
    (fn: ReactTransactor => (Cursor[A], Cursor[B]) => ReactElement)
    (implicit irA: Reusability[A], irB: Reusability[B]): FunctionalComponent[(Cursor[A], Cursor[B])] = {

    implicit val rA: Reusability[Cursor[A]] = irA.cursorReusability[A]
    implicit val rB: Reusability[Cursor[B]] = irB.cursorReusability[B]

    val c = FunctionalComponent[(Cursor[A], Cursor[B])] {
      props => {
        val tx = useContext(contexts.transactor)
        fn(tx)(props._1, props._2)
      }
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
trait ViewPureTransactor[A] {
  def apply(a: A)(implicit tx: ReactTransactor): ReactElement

  def build(contexts: ReactDataContexts = ReactData.defaultContexts)
           (implicit ir: Reusability[A]): FunctionalComponent[A] = {

    val c = FunctionalComponent[A] {
      props => {
        val tx = useContext(contexts.transactor)
        ViewPureTransactor.this.apply(props)(tx)
      }
    }

    // SAM implementation of BasicFunctionalComponent
    React.memo(c, (a, b) => ir.test(a, b))
  }
}

object ViewPureTransactor {
  def custom[A](contexts: ReactDataContexts = ReactData.defaultContexts)
    (fn: ReactTransactor => A => ReactElement)
    (implicit ir: Reusability[A]) : FunctionalComponent[A] = {
    val c = FunctionalComponent[A] {
      props => {
        val tx = useContext(contexts.transactor)
        fn(tx)(props)
      }
    }

    // SAM implementation of BasicFunctionalComponent
    React.memo(c, (a, b) => ir.test(a, b))
  }

  def apply[A](fn: ReactTransactor => A => ReactElement)
    (implicit ir: Reusability[A]) : FunctionalComponent[A] = custom()(fn)

}