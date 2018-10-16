
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Fingerprint {

  @JSImport("@material-ui/icons/Fingerprint", JSImport.Default)
  @js.native
  object FingerprintJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](FingerprintJS)
  
  def apply() = jsFnComponent()

}
    