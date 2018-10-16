
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object InsertComment {

  @JSImport("@material-ui/icons/InsertComment", JSImport.Default)
  @js.native
  object InsertCommentJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](InsertCommentJS)
  
  def apply() = jsFnComponent()

}
    