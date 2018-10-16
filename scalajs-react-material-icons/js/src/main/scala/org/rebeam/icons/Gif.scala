
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Gif {

  @JSImport("@material-ui/icons/Gif", JSImport.Default)
  @js.native
  object GifJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](GifJS)
  
  def apply() = jsFnComponent()

}
    