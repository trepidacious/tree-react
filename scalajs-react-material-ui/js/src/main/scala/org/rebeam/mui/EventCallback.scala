package org.rebeam.mui

import japgolly.scalajs.react._

object EventCallback {
  def apply(f: => Unit): ReactEvent => Callback = {
    (e: ReactEvent) => Callback{f}
  }
}