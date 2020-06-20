package demo

// import org.scalajs.dom.{console, Event}
import slinky.core._
import slinky.core.annotations.react
// import slinky.core.facade.{Hooks, ReactElement}
import slinky.web.html._
import typings.reactBootstrap.components.Button
// import typings.antd.antdStrings
// import typings.antd.components.{List => _, _}
// import typings.antd.iconMod.ThemeType
// import typings.antd.notificationMod.{ArgsProps, default => Notification}
// import typings.antd.tableInterfaceMod.ColumnProps

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

@JSImport("bootstrap/dist/css/bootstrap.min.css", JSImport.Default)
@js.native
object CSS extends js.Any

@react object App {
  type Props = Unit

  private val css = CSS

  val component = FunctionalComponent[Props] { _ =>

    def renderTag = h2("Tag")

    val renderButton = Button(js.Dynamic.literal(active = true).asInstanceOf[Button.Props])("Hi")

    div(className := "App")(
      renderTag,
      renderButton
    )
  }
}
