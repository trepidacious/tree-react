
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Pageview {

  @JSImport("@material-ui/icons/Pageview", JSImport.Default)
  @js.native
  object PageviewJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PageviewJS)
  
  def apply() = jsFnComponent()

}
    