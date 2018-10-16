
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object SentimentSatisfiedAlt {

  @JSImport("@material-ui/icons/SentimentSatisfiedAlt", JSImport.Default)
  @js.native
  object SentimentSatisfiedAltJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SentimentSatisfiedAltJS)
  
  def apply() = jsFnComponent()

}
    