
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Score {

  @JSImport("@material-ui/icons/Score", JSImport.Default)
  @js.native
  object ScoreJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ScoreJS)
  
  def apply() = jsFnComponent()

}
    