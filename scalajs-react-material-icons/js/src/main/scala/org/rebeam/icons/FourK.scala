
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object FourK {

  @JSImport("@material-ui/icons/FourK", JSImport.Default)
  @js.native
  object FourKJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](FourKJS)
  
  def apply() = jsFnComponent()

}
    