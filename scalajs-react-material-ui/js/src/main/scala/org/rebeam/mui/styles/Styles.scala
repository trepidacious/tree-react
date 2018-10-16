
package org.rebeam.mui.styles

import scalajs.js
import scalajs.js.annotation.JSImport

object Styles {

  @JSImport("@material-ui/core/styles", JSImport.Namespace)
  @js.native
  private object StylesJS extends js.Object {
    var createMuiTheme: js.Function1[js.Object, js.Object] = js.native
  }

  def createMuiTheme(theme: js.Object): js.Object = StylesJS.createMuiTheme(theme)

}
        