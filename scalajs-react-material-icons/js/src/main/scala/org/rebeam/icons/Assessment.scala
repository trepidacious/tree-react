
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Assessment {

  @JSImport("@material-ui/icons/Assessment", JSImport.Default)
  @js.native
  object AssessmentJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](AssessmentJS)
  
  def apply() = jsFnComponent()

}
    