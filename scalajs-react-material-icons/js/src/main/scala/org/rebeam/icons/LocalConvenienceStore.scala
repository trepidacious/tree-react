
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object LocalConvenienceStore {

  @JSImport("@material-ui/icons/LocalConvenienceStore", JSImport.Default)
  @js.native
  object LocalConvenienceStoreJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](LocalConvenienceStoreJS)
  
  def apply() = jsFnComponent()

}
    