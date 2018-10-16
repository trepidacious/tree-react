
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object MoodBad {

  @JSImport("@material-ui/icons/MoodBad", JSImport.Default)
  @js.native
  object MoodBadJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](MoodBadJS)
  
  def apply() = jsFnComponent()

}
    