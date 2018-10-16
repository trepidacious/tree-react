
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object VerifiedUser {

  @JSImport("@material-ui/icons/VerifiedUser", JSImport.Default)
  @js.native
  object VerifiedUserJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](VerifiedUserJS)
  
  def apply() = jsFnComponent()

}
    