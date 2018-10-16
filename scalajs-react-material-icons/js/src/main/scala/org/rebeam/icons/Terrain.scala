
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Terrain {

  @JSImport("@material-ui/icons/Terrain", JSImport.Default)
  @js.native
  object TerrainJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](TerrainJS)
  
  def apply() = jsFnComponent()

}
    