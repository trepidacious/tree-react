
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object EnhancedEncryption {

  @JSImport("@material-ui/icons/EnhancedEncryption", JSImport.Default)
  @js.native
  object EnhancedEncryptionJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](EnhancedEncryptionJS)
  
  def apply() = jsFnComponent()

}
    