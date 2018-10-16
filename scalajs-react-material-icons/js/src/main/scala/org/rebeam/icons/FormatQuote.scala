
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object FormatQuote {

  @JSImport("@material-ui/icons/FormatQuote", JSImport.Default)
  @js.native
  object FormatQuoteJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](FormatQuoteJS)
  
  def apply() = jsFnComponent()

}
    