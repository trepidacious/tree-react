
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object School {

  @JSImport("@material-ui/icons/School", JSImport.Default)
  @js.native
  object SchoolJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SchoolJS)
  
  def apply() = jsFnComponent()

}
    