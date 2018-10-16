
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Laptop {

  @JSImport("@material-ui/icons/Laptop", JSImport.Default)
  @js.native
  object LaptopJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](LaptopJS)
  
  def apply() = jsFnComponent()

}
    