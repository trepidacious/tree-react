
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object SyncProblem {

  @JSImport("@material-ui/icons/SyncProblem", JSImport.Default)
  @js.native
  object SyncProblemJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SyncProblemJS)
  
  def apply() = jsFnComponent()

}
    