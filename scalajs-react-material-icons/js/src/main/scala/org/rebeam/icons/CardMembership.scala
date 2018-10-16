
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object CardMembership {

  @JSImport("@material-ui/icons/CardMembership", JSImport.Default)
  @js.native
  object CardMembershipJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](CardMembershipJS)
  
  def apply() = jsFnComponent()

}
    