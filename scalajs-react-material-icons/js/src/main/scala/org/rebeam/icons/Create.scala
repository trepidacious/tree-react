
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Create {

  @JSImport("@material-ui/icons/Create", JSImport.Default)
  @js.native
  object CreateJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](CreateJS)
  
  def apply() = jsFnComponent()

}
    