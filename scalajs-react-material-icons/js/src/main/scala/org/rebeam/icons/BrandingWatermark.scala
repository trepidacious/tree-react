
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object BrandingWatermark {

  @JSImport("@material-ui/icons/BrandingWatermark", JSImport.Default)
  @js.native
  object BrandingWatermarkJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](BrandingWatermarkJS)
  
  def apply() = jsFnComponent()

}
    