
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Person {

  @JSImport("@material-ui/icons/Person", JSImport.Default)
  @js.native
  object PersonJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PersonJS)
  
  def apply() = jsFnComponent()

}
    