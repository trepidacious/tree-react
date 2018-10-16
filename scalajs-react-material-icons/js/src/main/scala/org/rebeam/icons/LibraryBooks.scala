
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object LibraryBooks {

  @JSImport("@material-ui/icons/LibraryBooks", JSImport.Default)
  @js.native
  object LibraryBooksJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](LibraryBooksJS)
  
  def apply() = jsFnComponent()

}
    