
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object EditAttributes {

  @JSImport("@material-ui/icons/EditAttributes", JSImport.Default)
  @js.native
  object EditAttributesJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](EditAttributesJS)
  
  def apply() = jsFnComponent()

}
    