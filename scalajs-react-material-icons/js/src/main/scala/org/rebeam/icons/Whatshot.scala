
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Whatshot {

  @JSImport("@material-ui/icons/Whatshot", JSImport.Default)
  @js.native
  object WhatshotJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](WhatshotJS)
  
  def apply() = jsFnComponent()

}
    