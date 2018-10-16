
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object PeopleOutline {

  @JSImport("@material-ui/icons/PeopleOutline", JSImport.Default)
  @js.native
  object PeopleOutlineJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PeopleOutlineJS)
  
  def apply() = jsFnComponent()

}
    