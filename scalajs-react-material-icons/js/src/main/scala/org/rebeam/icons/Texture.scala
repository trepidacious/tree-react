
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Texture {

  @JSImport("@material-ui/icons/Texture", JSImport.Default)
  @js.native
  object TextureJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](TextureJS)
  
  def apply() = jsFnComponent()

}
    