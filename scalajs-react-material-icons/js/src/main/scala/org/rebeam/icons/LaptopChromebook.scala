
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object LaptopChromebook {

  @JSImport("@material-ui/icons/LaptopChromebook", JSImport.Default)
  @js.native
  object LaptopChromebookJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](LaptopChromebookJS)
  
  def apply() = jsFnComponent()

}
    