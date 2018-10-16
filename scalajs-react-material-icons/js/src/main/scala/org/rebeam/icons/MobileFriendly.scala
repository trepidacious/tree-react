
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object MobileFriendly {

  @JSImport("@material-ui/icons/MobileFriendly", JSImport.Default)
  @js.native
  object MobileFriendlyJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](MobileFriendlyJS)
  
  def apply() = jsFnComponent()

}
    