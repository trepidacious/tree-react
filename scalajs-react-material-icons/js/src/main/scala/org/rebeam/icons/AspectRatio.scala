
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object AspectRatio {

  @JSImport("@material-ui/icons/AspectRatio", JSImport.Default)
  @js.native
  object AspectRatioJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](AspectRatioJS)
  
  def apply() = jsFnComponent()

}
    