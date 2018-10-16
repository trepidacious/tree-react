
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object AddComment {

  @JSImport("@material-ui/icons/AddComment", JSImport.Default)
  @js.native
  object AddCommentJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](AddCommentJS)
  
  def apply() = jsFnComponent()

}
    