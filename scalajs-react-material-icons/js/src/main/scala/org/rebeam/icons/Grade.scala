
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Grade {

  @JSImport("@material-ui/icons/Grade", JSImport.Default)
  @js.native
  object GradeJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](GradeJS)
  
  def apply() = jsFnComponent()

}
    