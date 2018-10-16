
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object ModeComment {

  @JSImport("@material-ui/icons/ModeComment", JSImport.Default)
  @js.native
  object ModeCommentJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ModeCommentJS)
  
  def apply() = jsFnComponent()

}
    