
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object RateReview {

  @JSImport("@material-ui/icons/RateReview", JSImport.Default)
  @js.native
  object RateReviewJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](RateReviewJS)
  
  def apply() = jsFnComponent()

}
    