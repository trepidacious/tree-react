
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object LocalOffer {

  @JSImport("@material-ui/icons/LocalOffer", JSImport.Default)
  @js.native
  object LocalOfferJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](LocalOfferJS)
  
  def apply() = jsFnComponent()

}
    