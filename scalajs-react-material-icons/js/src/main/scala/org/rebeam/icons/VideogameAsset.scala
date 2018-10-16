
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object VideogameAsset {

  @JSImport("@material-ui/icons/VideogameAsset", JSImport.Default)
  @js.native
  object VideogameAssetJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](VideogameAssetJS)
  
  def apply() = jsFnComponent()

}
    