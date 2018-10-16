
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Wallpaper {

  @JSImport("@material-ui/icons/Wallpaper", JSImport.Default)
  @js.native
  object WallpaperJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](WallpaperJS)
  
  def apply() = jsFnComponent()

}
    