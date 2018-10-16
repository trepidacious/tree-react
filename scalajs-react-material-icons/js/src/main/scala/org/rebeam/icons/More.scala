
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object More {

  @JSImport("@material-ui/icons/More", JSImport.Default)
  @js.native
  object MoreJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](MoreJS)
  
  def apply() = jsFnComponent()

}
    