
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object AirlineSeatIndividualSuite {

  @JSImport("@material-ui/icons/AirlineSeatIndividualSuite", JSImport.Default)
  @js.native
  object AirlineSeatIndividualSuiteJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](AirlineSeatIndividualSuiteJS)
  
  def apply() = jsFnComponent()

}
    