
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Collections {

  @JSImport("@material-ui/icons/Collections", JSImport.Default)
  @js.native
  object CollectionsJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](CollectionsJS)
  
  def apply() = jsFnComponent()

}
    