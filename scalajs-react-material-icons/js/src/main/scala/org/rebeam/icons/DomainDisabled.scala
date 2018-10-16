
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object DomainDisabled {

  @JSImport("@material-ui/icons/DomainDisabled", JSImport.Default)
  @js.native
  object DomainDisabledJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](DomainDisabledJS)
  
  def apply() = jsFnComponent()

}
    