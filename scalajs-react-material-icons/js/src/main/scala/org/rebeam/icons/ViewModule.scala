
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object ViewModule {

  @JSImport("@material-ui/icons/ViewModule", JSImport.Default)
  @js.native
  object ViewModuleJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ViewModuleJS)
  
  def apply() = jsFnComponent()

}
    