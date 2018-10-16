
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Domain {

  @JSImport("@material-ui/icons/Domain", JSImport.Default)
  @js.native
  object DomainJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](DomainJS)
  
  def apply() = jsFnComponent()

}
    