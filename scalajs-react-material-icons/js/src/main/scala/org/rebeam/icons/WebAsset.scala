
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object WebAsset {

  @JSImport("@material-ui/icons/WebAsset", JSImport.Default)
  @js.native
  object WebAssetJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](WebAssetJS)
  
  def apply() = jsFnComponent()

}
    