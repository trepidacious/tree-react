
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Poll {

  @JSImport("@material-ui/icons/Poll", JSImport.Default)
  @js.native
  object PollJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PollJS)
  
  def apply() = jsFnComponent()

}
    