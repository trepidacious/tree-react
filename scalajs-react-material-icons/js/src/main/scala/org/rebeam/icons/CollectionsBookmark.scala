
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object CollectionsBookmark {

  @JSImport("@material-ui/icons/CollectionsBookmark", JSImport.Default)
  @js.native
  object CollectionsBookmarkJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](CollectionsBookmarkJS)
  
  def apply() = jsFnComponent()

}
    