
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object OndemandVideo {

  @JSImport("@material-ui/icons/OndemandVideo", JSImport.Default)
  @js.native
  object OndemandVideoJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](OndemandVideoJS)
  
  def apply() = jsFnComponent()

}
    