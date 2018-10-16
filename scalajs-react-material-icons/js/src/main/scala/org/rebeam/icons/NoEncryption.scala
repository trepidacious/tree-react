
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object NoEncryption {

  @JSImport("@material-ui/icons/NoEncryption", JSImport.Default)
  @js.native
  object NoEncryptionJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](NoEncryptionJS)
  
  def apply() = jsFnComponent()

}
    