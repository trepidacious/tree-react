package org.rebeam.tree.react

import japgolly.scalajs.react.React.Context
import japgolly.scalajs.react._
import japgolly.scalajs.react.extra.Reusability
import org.rebeam.tree._
import org.rebeam.tree.MapStateSTM._
import japgolly.scalajs.react.vdom.html_<^._

object LocalDataRoot {

  private val firstGuid = Guid.raw(0, 0, 0)

  class Backend[A](bs: BackendScope[A, StateData], r: A => VdomElement, dataContext: Context[DataSource]) {
    def render(p: A, s: StateData): VdomElement = {
      dataContext.provide(s)(r(p))
    }
  }

  def component[A: Reusability](
    r: A => VdomElement,
    dataContext: Context[DataSource] = DataContext.default
  ) =
    ScalaComponent.builder[A]("LocalDataRoot")
      .initialState(
        StateData(
          firstGuid,
          Map.empty,
          PRandom(0),
          TransactionContext(Moment(0))
        )
      )
      .backend(scope => new Backend[A](scope, r, dataContext))
      .render(s => s.backend.render(s.props, s.state))
      .shouldComponentUpdatePure(
        s => (s.nextState ne s.currentState) ||
          !implicitly[Reusability[A]].test(s.currentProps, s.nextProps)
      )
      .build

}
