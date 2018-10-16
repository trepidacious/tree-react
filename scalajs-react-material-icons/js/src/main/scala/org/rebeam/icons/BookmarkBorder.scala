
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object BookmarkBorder {

  @JSImport("@material-ui/icons/BookmarkBorder", JSImport.Default)
  @js.native
  object BookmarkBorderJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](BookmarkBorderJS)
  
  def apply() = jsFnComponent()

}
    