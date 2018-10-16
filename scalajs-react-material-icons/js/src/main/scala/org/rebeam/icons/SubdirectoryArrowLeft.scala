
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object SubdirectoryArrowLeft {

  @JSImport("@material-ui/icons/SubdirectoryArrowLeft", JSImport.Default)
  @js.native
  object SubdirectoryArrowLeftJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SubdirectoryArrowLeftJS)
  
  def apply() = jsFnComponent()

}
    