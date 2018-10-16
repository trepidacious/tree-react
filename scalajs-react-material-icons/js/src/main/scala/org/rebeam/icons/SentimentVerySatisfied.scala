
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object SentimentVerySatisfied {

  @JSImport("@material-ui/icons/SentimentVerySatisfied", JSImport.Default)
  @js.native
  object SentimentVerySatisfiedJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SentimentVerySatisfiedJS)
  
  def apply() = jsFnComponent()

}
    