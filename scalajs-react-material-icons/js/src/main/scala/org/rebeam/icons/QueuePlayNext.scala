
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object QueuePlayNext {

  @JSImport("@material-ui/icons/QueuePlayNext", JSImport.Default)
  @js.native
  object QueuePlayNextJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](QueuePlayNextJS)
  
  def apply() = jsFnComponent()

}
    