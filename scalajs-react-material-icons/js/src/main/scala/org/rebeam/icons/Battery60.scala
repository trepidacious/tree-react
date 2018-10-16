
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Battery60 {

  @JSImport("@material-ui/icons/Battery60", JSImport.Default)
  @js.native
  object Battery60JS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](Battery60JS)
  
  def apply() = jsFnComponent()

}
    