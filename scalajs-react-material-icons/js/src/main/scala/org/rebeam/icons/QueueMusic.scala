
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object QueueMusic {

  @JSImport("@material-ui/icons/QueueMusic", JSImport.Default)
  @js.native
  object QueueMusicJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](QueueMusicJS)
  
  def apply() = jsFnComponent()

}
    