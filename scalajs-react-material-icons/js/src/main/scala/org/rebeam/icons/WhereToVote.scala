
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object WhereToVote {

  @JSImport("@material-ui/icons/WhereToVote", JSImport.Default)
  @js.native
  object WhereToVoteJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](WhereToVoteJS)
  
  def apply() = jsFnComponent()

}
    