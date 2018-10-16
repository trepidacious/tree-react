
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Forum {

  @JSImport("@material-ui/icons/Forum", JSImport.Default)
  @js.native
  object ForumJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ForumJS)
  
  def apply() = jsFnComponent()

}
    