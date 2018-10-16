
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object SelectAll {

  @JSImport("@material-ui/icons/SelectAll", JSImport.Default)
  @js.native
  object SelectAllJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SelectAllJS)
  
  def apply() = jsFnComponent()

}
    