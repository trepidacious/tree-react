
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object StrikethroughS {

  @JSImport("@material-ui/icons/StrikethroughS", JSImport.Default)
  @js.native
  object StrikethroughSJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](StrikethroughSJS)
  
  def apply() = jsFnComponent()

}
    