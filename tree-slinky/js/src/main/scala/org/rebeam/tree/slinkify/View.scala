package org.rebeam.tree.slinkify

import cats.Monad
import cats.data.StateT
import cats.implicits._
import org.rebeam.tree._
import slinky.core.FunctionalComponent
import slinky.core.facade.ReactElement
import slinky.web.html._
//import org.rebeam.tree.ot.{CursorUpdate, OTList}
import ReactData.ReactDataContexts

object View {

  /**
    * Ops provides an implementation of ReactViewOps for ViewFunctions to use to
    * render. This is based on a DataSource
    */
  object Ops {

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
//      def getOTListCursorUpdate[A](list: OTList[A]): S[Option[CursorUpdate[A]]] =
//        StateT[ErrorOr, StateData, Option[CursorUpdate[A]]](sd => {
//          Right((sd, sd.dataSource.getOTListCursorUpdate(list)))
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
trait ViewC[A] extends ViewFunction[Cursor[A]] {
  def build(
             name: String,
             contexts: ReactDataContexts = ReactData.defaultContexts,
             onError: DataError => ReactElement = View.defaultError
           )(implicit ir: Reusability[A]): FunctionalComponent[Cursor[A]] = {

    val renderer = new DataRenderer[Cursor[A]] {
      override def apply(a: Cursor[A], data: ReactData, tx: ReactTransactor): DataRenderer.Result =
      View.Ops.render(ViewC.this, onError, a, data)(tx)
    }
    DataComponent[Cursor[A]](renderer, contexts)(ir.cursorReusability)
  }
}
