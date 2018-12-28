package org.rebeam.tree.react

import cats.Monad
import cats.implicits._
import japgolly.scalajs.react.CtorType
import japgolly.scalajs.react.React.Context
import japgolly.scalajs.react.component.Scala.Component
import japgolly.scalajs.react.extra.Reusability
import japgolly.scalajs.react.vdom.html_<^._
import org.rebeam.tree._
import org.rebeam.tree.react.View.DataRendererViewOps

trait View[A] {
  def apply[F[_]: Monad](a: A)(implicit v: ViewOps[F]): F[VdomElement]
  def build(
    name: String,
    dataContext: Context[DataSource] = DataContext.default,
    onError: DataSourceViewOps.Error => VdomElement = View.defaultError
  )(implicit r: Reusability[A]): Component[A, Unit, Unit, CtorType.Props] =
    DataComponent[A](new DataRendererViewOps(this, onError), name, dataContext)
}

object View {
  private val defaultError: DataSourceViewOps.Error => VdomElement = error =>
    <.div(
      ^.`class`:="tree-error",
      <.span("\u2026"),
      <.span(
        ^.`class`:="tree-error__tooltip",
        s"Missing:\n${error.missingGuids.mkString("\n")}"
      )
    )

  private class DataRendererViewOps[A](
    v: View[A],
    onError: DataSourceViewOps.Error => VdomElement
  ) extends DataRenderer[A] {
    override def apply(a: A, data: DataSource): DataRenderer.Result = {
      import DataSourceViewOps._
      val stateData = StateData(data)
      val result = v.apply[DataSourceViewOps.S](a).run(stateData)
      result match {
        case Left(error) => DataRenderer.Result(onError(error), error.viewedGuids ++ error.missingGuids)
        case Right((s, vdom)) => DataRenderer.Result(vdom, s.viewedGuids ++ s.missingGuids)
      }
    }
  }

}
