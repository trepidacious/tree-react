
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object SentimentDissatisfied {

  @JSImport("@material-ui/icons/SentimentDissatisfied", JSImport.Default)
  @js.native
  object SentimentDissatisfiedJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SentimentDissatisfiedJS)
  
  def apply() = jsFnComponent()

}
    