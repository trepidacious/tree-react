
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Dns {

  @JSImport("@material-ui/icons/Dns", JSImport.Default)
  @js.native
  object DnsJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](DnsJS)
  
  def apply() = jsFnComponent()

}
    