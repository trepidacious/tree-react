package org.rebeam.electron.react

import CssSettings._
import scala.language.postfixOps

object Styles extends StyleSheet.Inline {
  import dsl._

  // object appRegion extends TypedAttrBase {
  //   override val attr = Attr.real("c")
  //   def drag = av(L.drag)
  //   def separate = av(L.noDrag)
  // }

  val titlebar = style(
    backgroundColor(c"#2e3b84"),
    // appRegion(drag),
    // ^.style := js.Dynamic.literal(
    //   "WebkitAppRegion" -> "drag"
    // ),
    height(22 px),
    width(100 %%)
  )
}
