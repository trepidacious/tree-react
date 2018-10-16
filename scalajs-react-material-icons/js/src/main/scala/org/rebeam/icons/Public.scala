
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Public {

  @JSImport("@material-ui/icons/Public", JSImport.Default)
  @js.native
  object PublicJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PublicJS)
  
  def apply() = jsFnComponent()

}
    