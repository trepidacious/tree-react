
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Subscriptions {

  @JSImport("@material-ui/icons/Subscriptions", JSImport.Default)
  @js.native
  object SubscriptionsJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SubscriptionsJS)
  
  def apply() = jsFnComponent()

}
    