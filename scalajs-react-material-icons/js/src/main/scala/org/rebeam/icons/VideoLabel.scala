
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object VideoLabel {

  @JSImport("@material-ui/icons/VideoLabel", JSImport.Default)
  @js.native
  object VideoLabelJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](VideoLabelJS)
  
  def apply() = jsFnComponent()

}
    