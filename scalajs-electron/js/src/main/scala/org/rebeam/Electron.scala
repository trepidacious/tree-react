package org.rebeam

import scalajs.js
import scalajs.js.annotation.JSImport

/**
  * See https://electronjs.org/docs/api
  */
@JSImport("electron", JSImport.Default)
@js.native
object Electron extends js.Object {
  val remote: Remote = js.native
}

@js.native
trait Remote extends js.Object {
  val app: App = js.native
}

@js.native
trait App extends js.Object {
  def getVersion(): String = js.native
  def getName(): String = js.native
}
