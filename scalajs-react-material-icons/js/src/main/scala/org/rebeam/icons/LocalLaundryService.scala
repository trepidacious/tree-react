
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object LocalLaundryService {

  @JSImport("@material-ui/icons/LocalLaundryService", JSImport.Default)
  @js.native
  object LocalLaundryServiceJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](LocalLaundryServiceJS)
  
  def apply() = jsFnComponent()

}
    