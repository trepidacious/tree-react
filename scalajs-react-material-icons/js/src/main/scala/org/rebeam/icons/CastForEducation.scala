
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object CastForEducation {

  @JSImport("@material-ui/icons/CastForEducation", JSImport.Default)
  @js.native
  object CastForEducationJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](CastForEducationJS)
  
  def apply() = jsFnComponent()

}
    