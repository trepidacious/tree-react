package org.rebeam.mui.styles

import scalajs.js

case class Style(o: js.Object)

object Style {
  def apply(fields: (String, String)*): Style = Style(js.Dictionary(fields: _*).asInstanceOf[js.Object])
}
