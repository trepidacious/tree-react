
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object FormatItalic {

  @JSImport("@material-ui/icons/FormatItalic", JSImport.Default)
  @js.native
  object FormatItalicJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](FormatItalicJS)
  
  def apply() = jsFnComponent()

}
    