
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object YoutubeSearchedFor {

  @JSImport("@material-ui/icons/YoutubeSearchedFor", JSImport.Default)
  @js.native
  object YoutubeSearchedForJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](YoutubeSearchedForJS)
  
  def apply() = jsFnComponent()

}
    