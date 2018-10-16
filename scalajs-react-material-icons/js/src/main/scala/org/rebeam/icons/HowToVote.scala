
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object HowToVote {

  @JSImport("@material-ui/icons/HowToVote", JSImport.Default)
  @js.native
  object HowToVoteJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](HowToVoteJS)
  
  def apply() = jsFnComponent()

}
    