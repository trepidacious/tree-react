package org.rebeam.mui.event

import japgolly.scalajs.react.{Callback, ReactEvent}

object EventCallback {
  def apply(f: => Unit): ReactEvent => Callback = {
    (e: ReactEvent) => Callback{f}
  }
}
