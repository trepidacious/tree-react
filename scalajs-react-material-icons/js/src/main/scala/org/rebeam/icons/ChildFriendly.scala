
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object ChildFriendly {

  @JSImport("@material-ui/icons/ChildFriendly", JSImport.Default)
  @js.native
  object ChildFriendlyJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ChildFriendlyJS)
  
  def apply() = jsFnComponent()

}
    