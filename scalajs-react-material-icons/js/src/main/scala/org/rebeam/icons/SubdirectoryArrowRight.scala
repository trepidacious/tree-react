
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object SubdirectoryArrowRight {

  @JSImport("@material-ui/icons/SubdirectoryArrowRight", JSImport.Default)
  @js.native
  object SubdirectoryArrowRightJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SubdirectoryArrowRightJS)
  
  def apply() = jsFnComponent()

}
    