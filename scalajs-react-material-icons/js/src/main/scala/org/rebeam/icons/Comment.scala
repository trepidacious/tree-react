
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Comment {

  @JSImport("@material-ui/icons/Comment", JSImport.Default)
  @js.native
  object CommentJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](CommentJS)
  
  def apply() = jsFnComponent()

}
    