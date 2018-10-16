
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object ViewAgenda {

  @JSImport("@material-ui/icons/ViewAgenda", JSImport.Default)
  @js.native
  object ViewAgendaJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ViewAgendaJS)
  
  def apply() = jsFnComponent()

}
    