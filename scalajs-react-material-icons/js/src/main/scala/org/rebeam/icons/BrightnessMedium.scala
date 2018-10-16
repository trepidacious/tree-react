
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object BrightnessMedium {

  @JSImport("@material-ui/icons/BrightnessMedium", JSImport.Default)
  @js.native
  object BrightnessMediumJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](BrightnessMediumJS)
  
  def apply() = jsFnComponent()

}
    