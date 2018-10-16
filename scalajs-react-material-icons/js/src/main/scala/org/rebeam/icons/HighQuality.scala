
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object HighQuality {

  @JSImport("@material-ui/icons/HighQuality", JSImport.Default)
  @js.native
  object HighQualityJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](HighQualityJS)
  
  def apply() = jsFnComponent()

}
    