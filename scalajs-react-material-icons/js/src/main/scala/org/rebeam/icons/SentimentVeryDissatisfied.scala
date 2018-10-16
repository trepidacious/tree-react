
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object SentimentVeryDissatisfied {

  @JSImport("@material-ui/icons/SentimentVeryDissatisfied", JSImport.Default)
  @js.native
  object SentimentVeryDissatisfiedJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SentimentVeryDissatisfiedJS)
  
  def apply() = jsFnComponent()

}
    