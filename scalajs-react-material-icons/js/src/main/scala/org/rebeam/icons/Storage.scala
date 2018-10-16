
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Storage {

  @JSImport("@material-ui/icons/Storage", JSImport.Default)
  @js.native
  object StorageJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](StorageJS)
  
  def apply() = jsFnComponent()

}
    