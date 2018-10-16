
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Mood {

  @JSImport("@material-ui/icons/Mood", JSImport.Default)
  @js.native
  object MoodJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](MoodJS)
  
  def apply() = jsFnComponent()

}
    