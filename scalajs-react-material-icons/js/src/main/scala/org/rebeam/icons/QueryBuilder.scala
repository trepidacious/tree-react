
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object QueryBuilder {

  @JSImport("@material-ui/icons/QueryBuilder", JSImport.Default)
  @js.native
  object QueryBuilderJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](QueryBuilderJS)
  
  def apply() = jsFnComponent()

}
    