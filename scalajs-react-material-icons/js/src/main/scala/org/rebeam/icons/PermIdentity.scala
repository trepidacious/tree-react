
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object PermIdentity {

  @JSImport("@material-ui/icons/PermIdentity", JSImport.Default)
  @js.native
  object PermIdentityJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PermIdentityJS)
  
  def apply() = jsFnComponent()

}
    