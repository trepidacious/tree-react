package org.rebeam.demo

import org.rebeam._
import japgolly.scalajs.react._
import sui._
import japgolly.scalajs.react.vdom.html_<^._
import org.rebeam.react.InputEventCallback

object TextFieldDemo {

  type Props = Unit

  case class State(inputValue: String)

  class Backend(scope: BackendScope[Props, State]) {

    private val onChange = InputEventCallback {
      s =>
        scope.modState(_.copy(inputValue = s)) >>
          Callback{println(s"Input '$s'")}
    }

    def render(props: Props, state: State) =
      Input(
        value = state.inputValue,
        onChange = onChange
      )()
  }

  //Just make the component constructor - props to be supplied later to make a component
  def ctor = ScalaComponent.builder[Props]("TextFieldDemo")
    .initialState(State(""))
    .backend(new Backend(_))
    .render(s => s.backend.render(s.props, s.state))
    .build

}
