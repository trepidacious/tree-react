
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Bookmark {

  @JSImport("@material-ui/icons/Bookmark", JSImport.Default)
  @js.native
  object BookmarkJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](BookmarkJS)
  
  def apply() = jsFnComponent()

}
    