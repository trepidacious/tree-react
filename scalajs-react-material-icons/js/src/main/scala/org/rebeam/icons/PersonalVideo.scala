
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object PersonalVideo {

  @JSImport("@material-ui/icons/PersonalVideo", JSImport.Default)
  @js.native
  object PersonalVideoJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PersonalVideoJS)
  
  def apply() = jsFnComponent()

}
    