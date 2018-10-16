
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object TouchApp {

  @JSImport("@material-ui/icons/TouchApp", JSImport.Default)
  @js.native
  object TouchAppJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](TouchAppJS)
  
  def apply() = jsFnComponent()

}
    