
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object FeaturedPlayList {

  @JSImport("@material-ui/icons/FeaturedPlayList", JSImport.Default)
  @js.native
  object FeaturedPlayListJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](FeaturedPlayListJS)
  
  def apply() = jsFnComponent()

}
    