
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object People {

  @JSImport("@material-ui/icons/People", JSImport.Default)
  @js.native
  object PeopleJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PeopleJS)
  
  def apply() = jsFnComponent()

}
    