
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object List {

  @JSImport("@material-ui/icons/List", JSImport.Default)
  @js.native
  object ListJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ListJS)
  
  def apply() = jsFnComponent()

}
    