
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Book {

  @JSImport("@material-ui/icons/Book", JSImport.Default)
  @js.native
  object BookJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](BookJS)
  
  def apply() = jsFnComponent()

}
    