
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Extension {

  @JSImport("@material-ui/icons/Extension", JSImport.Default)
  @js.native
  object ExtensionJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ExtensionJS)
  
  def apply() = jsFnComponent()

}
    