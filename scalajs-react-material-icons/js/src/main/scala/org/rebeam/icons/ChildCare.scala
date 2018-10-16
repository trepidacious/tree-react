
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object ChildCare {

  @JSImport("@material-ui/icons/ChildCare", JSImport.Default)
  @js.native
  object ChildCareJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ChildCareJS)
  
  def apply() = jsFnComponent()

}
    