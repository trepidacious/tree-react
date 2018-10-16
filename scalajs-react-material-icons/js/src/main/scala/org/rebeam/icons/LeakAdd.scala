
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object LeakAdd {

  @JSImport("@material-ui/icons/LeakAdd", JSImport.Default)
  @js.native
  object LeakAddJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](LeakAddJS)
  
  def apply() = jsFnComponent()

}
    