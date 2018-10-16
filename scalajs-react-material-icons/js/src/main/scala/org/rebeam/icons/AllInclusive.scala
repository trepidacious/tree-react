
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object AllInclusive {

  @JSImport("@material-ui/icons/AllInclusive", JSImport.Default)
  @js.native
  object AllInclusiveJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](AllInclusiveJS)
  
  def apply() = jsFnComponent()

}
    