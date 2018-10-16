
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Filter2 {

  @JSImport("@material-ui/icons/Filter2", JSImport.Default)
  @js.native
  object Filter2JS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](Filter2JS)
  
  def apply() = jsFnComponent()

}
    