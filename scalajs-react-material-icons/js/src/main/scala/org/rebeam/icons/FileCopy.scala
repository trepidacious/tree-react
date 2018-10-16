
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object FileCopy {

  @JSImport("@material-ui/icons/FileCopy", JSImport.Default)
  @js.native
  object FileCopyJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](FileCopyJS)
  
  def apply() = jsFnComponent()

}
    