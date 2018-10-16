
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Bookmarks {

  @JSImport("@material-ui/icons/Bookmarks", JSImport.Default)
  @js.native
  object BookmarksJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](BookmarksJS)
  
  def apply() = jsFnComponent()

}
    