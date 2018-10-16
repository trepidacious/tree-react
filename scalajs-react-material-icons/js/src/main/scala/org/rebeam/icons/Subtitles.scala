
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Subtitles {

  @JSImport("@material-ui/icons/Subtitles", JSImport.Default)
  @js.native
  object SubtitlesJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SubtitlesJS)
  
  def apply() = jsFnComponent()

}
    