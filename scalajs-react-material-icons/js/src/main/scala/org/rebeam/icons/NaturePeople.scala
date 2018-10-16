
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object NaturePeople {

  @JSImport("@material-ui/icons/NaturePeople", JSImport.Default)
  @js.native
  object NaturePeopleJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](NaturePeopleJS)
  
  def apply() = jsFnComponent()

}
    