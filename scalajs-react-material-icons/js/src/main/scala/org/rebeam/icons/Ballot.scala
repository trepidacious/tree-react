
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Ballot {

  @JSImport("@material-ui/icons/Ballot", JSImport.Default)
  @js.native
  object BallotJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](BallotJS)
  
  def apply() = jsFnComponent()

}
    