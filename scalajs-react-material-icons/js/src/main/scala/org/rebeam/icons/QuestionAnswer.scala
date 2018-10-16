
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object QuestionAnswer {

  @JSImport("@material-ui/icons/QuestionAnswer", JSImport.Default)
  @js.native
  object QuestionAnswerJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](QuestionAnswerJS)
  
  def apply() = jsFnComponent()

}
    