
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Feedback {

  @JSImport("@material-ui/icons/Feedback", JSImport.Default)
  @js.native
  object FeedbackJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](FeedbackJS)
  
  def apply() = jsFnComponent()

}
    