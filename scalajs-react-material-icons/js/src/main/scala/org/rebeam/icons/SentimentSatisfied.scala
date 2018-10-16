
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object SentimentSatisfied {

  @JSImport("@material-ui/icons/SentimentSatisfied", JSImport.Default)
  @js.native
  object SentimentSatisfiedJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SentimentSatisfiedJS)
  
  def apply() = jsFnComponent()

}
    