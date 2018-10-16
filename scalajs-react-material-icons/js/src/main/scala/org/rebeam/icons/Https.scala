
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Https {

  @JSImport("@material-ui/icons/Https", JSImport.Default)
  @js.native
  object HttpsJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](HttpsJS)
  
  def apply() = jsFnComponent()

}
    