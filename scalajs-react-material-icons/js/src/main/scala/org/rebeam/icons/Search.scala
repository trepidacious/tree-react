
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Search {

  @JSImport("@material-ui/icons/Search", JSImport.Default)
  @js.native
  object SearchJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SearchJS)
  
  def apply() = jsFnComponent()

}
    