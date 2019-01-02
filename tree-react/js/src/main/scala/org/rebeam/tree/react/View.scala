package org.rebeam.tree.react

import cats.Monad
import cats.data.StateT
import cats.implicits._
import japgolly.scalajs.react._
import japgolly.scalajs.react.component.Scala.Component
import japgolly.scalajs.react.extra.Reusability
import japgolly.scalajs.react.vdom.html_<^._
import org.rebeam.tree._
import org.rebeam.tree.react.ReactData.DataContext

trait ViewFunction[A] {
  def apply[F[_]: Monad](a: A)(implicit v: ReactViewOps[F], tx: ReactTransactor): F[VdomElement]
}

object View {

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

    }

    def render[A](
      v: ViewFunction[A],
      onError: DataError => VdomElement,
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

  val defaultError: DataError => VdomElement = error =>
    <.div(
      ^.`class` := "tree-error",
      <.span("\u2026"),
      <.span(
        ^.`class` := "tree-error__tooltip",
        s"Missing:\n${error.missingGuids.mkString("\n")}"
      )
    )
}

trait View[A] extends ViewFunction[A] {
  def build(
             name: String,
             dataContext: DataContext = ReactData.defaultContext,
             onError: DataError => VdomElement = View.defaultError
           )(implicit ir: ImmutableReusability[A]): Component[A, Unit, Unit, CtorType.Props] = {
    val renderer = new DataRenderer[A] {
      override def apply(a: A, data: ReactData, tx: ReactTransactor): DataRenderer.Result =
        View.Ops.render(View.this, onError, a, data)(tx)
    }
    DataComponent[A](renderer, name, dataContext)(ir.reusability)
  }
}

trait ViewC[A] extends ViewFunction[Cursor[A]] {
  def build(
             name: String,
             dataContext: DataContext = ReactData.defaultContext,
             onError: DataError => VdomElement = View.defaultError
           )(implicit ir: ImmutableReusability[A]): Component[Cursor[A], Unit, Unit, CtorType.Props] = {

    val renderer = new DataRenderer[Cursor[A]] {
      override def apply(a: Cursor[A], data: ReactData, tx: ReactTransactor): DataRenderer.Result =
      View.Ops.render(ViewC.this, onError, a, data)(tx)
    }

    //Compare the model value using ir.reusability, and the DeltaCursor by equality (since DeltaCursors may be
    //be recreated without changing contents, during a render)
    val reusability = Reusability[Cursor[A]](
      (dA1, dA2) => ir.reusability.test(dA1.a, dA2.a) && (dA1.deltaCursor == dA2.deltaCursor)
    )

    DataComponent[Cursor[A]](renderer, name, dataContext)(reusability)
  }
}
