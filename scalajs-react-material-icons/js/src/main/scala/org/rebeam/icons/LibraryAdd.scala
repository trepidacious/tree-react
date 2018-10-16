
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object LibraryAdd {

  @JSImport("@material-ui/icons/LibraryAdd", JSImport.Default)
  @js.native
  object LibraryAddJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](LibraryAddJS)
  
  def apply() = jsFnComponent()

}
    