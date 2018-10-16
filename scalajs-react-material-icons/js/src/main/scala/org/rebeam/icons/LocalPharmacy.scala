
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object LocalPharmacy {

  @JSImport("@material-ui/icons/LocalPharmacy", JSImport.Default)
  @js.native
  object LocalPharmacyJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](LocalPharmacyJS)
  
  def apply() = jsFnComponent()

}
    