
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Work {

  @JSImport("@material-ui/icons/Work", JSImport.Default)
  @js.native
  object WorkJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](WorkJS)
  
  def apply() = jsFnComponent()

}
    