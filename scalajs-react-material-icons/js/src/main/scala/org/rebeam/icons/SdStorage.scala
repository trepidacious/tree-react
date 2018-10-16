
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object SdStorage {

  @JSImport("@material-ui/icons/SdStorage", JSImport.Default)
  @js.native
  object SdStorageJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SdStorageJS)
  
  def apply() = jsFnComponent()

}
    