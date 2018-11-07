package org.rebeam.electron.react

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import org.rebeam.IPCRenderer
import org.rebeam.mui.Snackbar

import scalajs.js

object NotificationSnackbar {

  case class Props(channel: String)

  case class State(notificationListener: Option[IPCRenderer.Listener], notificationOpen: Boolean, notification: String)

  class Backend(scope: BackendScope[Props, State]) {
    def registerNotifications: Callback = {
      val direct = scope.withEffectsImpure
      for {
        p <- scope.props
        _ <- scope.modState(
          _.copy(
            notificationListener = Some(IPCRenderer.on(
              p.channel,
              (event: IPCRenderer.Event, msg: String) => {
                direct.modState(_.copy(notification = msg, notificationOpen = true))
                ()
              }
            ))
          )
        )
      } yield ()
    }

    def unregisterNotifications: Callback = for {
      state <- scope.state
      _ <- Callback {
        state.notificationListener.foreach {
          l => IPCRenderer.removeListener("notifications", l)
        }
      }
      _ <- scope.modState(_.copy(notificationListener = None))
    } yield ()

    def start: Callback = registerNotifications

    def end: Callback = unregisterNotifications

    def render(props: Props, state: State) =
      Snackbar(
        anchorOrigin = js.Dynamic.literal(
          "vertical" -> "bottom",
          "horizontal" -> "left"
        ),
        open = state.notificationOpen,
        autoHideDuration = 3000.0,
        onClose = scope.modState(_.copy(notificationOpen = false)),
        message = <.span(state.notification): VdomNode
      )()
  }

  //Just make the component constructor - props to be supplied later to make a component
  private val ctor = ScalaComponent.builder[Props]("TopView")
    .initialState(State(None, notificationOpen = false, ""))
    .backend(new Backend(_))
    .render(s => s.backend.render(s.props, s.state))
    .componentDidMount(_.backend.start)
    .componentWillUnmount(_.backend.end)
    .build

  def apply(channel: String) = ctor(Props(channel))

}
