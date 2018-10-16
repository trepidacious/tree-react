
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object BlurCircular {

  @JSImport("@material-ui/icons/BlurCircular", JSImport.Default)
  @js.native
  object BlurCircularJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](BlurCircularJS)
  
  def apply() = jsFnComponent()

}
    