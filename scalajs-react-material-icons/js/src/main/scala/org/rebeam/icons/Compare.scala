
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Compare {

  @JSImport("@material-ui/icons/Compare", JSImport.Default)
  @js.native
  object CompareJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](CompareJS)
  
  def apply() = jsFnComponent()

}
    