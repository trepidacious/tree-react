
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Subject {

  @JSImport("@material-ui/icons/Subject", JSImport.Default)
  @js.native
  object SubjectJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SubjectJS)
  
  def apply() = jsFnComponent()

}
    