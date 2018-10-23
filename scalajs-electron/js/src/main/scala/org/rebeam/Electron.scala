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
  def getCurrentWindow(): BrowserWindow = js.native
}

@js.native
trait App extends js.Object {
  def getVersion(): String = js.native
  def getName(): String = js.native
}

/**
  * A browser window - facade currently only has a subset of functionality, see
  * https://electronjs.org/docs/api/browser-window
  */
@js.native
trait BrowserWindow extends js.Object {

  /**
    * Try to close the window. This has the same effect as a user manually
    * clicking the close button of the window. The web page may cancel the
    * close though. See the close event.
    */
  def close(): Unit = js.native

  /**
    * Maximizes the window. This will also show (but not focus) the window
    * if it isn't being displayed already.
    */
  def maximize(): Unit = js.native

  /**
    * Unmaximizes the window.
    */
  def unmaximize(): Unit = js.native

  /**
    * Returns Boolean - Whether the window is maximized.
    */
  def isMaximized(): Boolean = js.native

  /**
    * Returns Boolean - Whether the window is maximizable.
    */
  def isMaximizable(): Boolean = js.native

  /**
    * Minimizes the window. On some platforms the minimized window will be
    * shown in the Dock.
    */
  def minimize(): Unit = js.native

  /**
    * Returns Boolean - Whether the window is minimized.
    */
  def isMinimized(): Boolean = js.native

  /**
    * Sets whether the window should be in fullscreen mode.
    * @param fullScreen True for fullscreen
    */
  def setFullScreen(fullScreen: Boolean): Unit = js.native

  /**
    * Returns Boolean - Whether the window is in fullscreen mode.
    */
  def isFullScreen(): Boolean = js.native

  type Listener = scalajs.js.Function0[Unit]

  /**
    * Add a listener
    * Use only for events not in the facade already
    * @param eventName  The event name
    * @param listener   The listener to call when event occurs
    */
  def addListener(eventName: String, listener: Listener): Unit = js.native

  /**
    * Remove a listener
    * Use only for events not in the facade already
    * @param eventName  The event name
    * @param listener   The listener to remove
    */
  def removeListener(eventName: String, listener: Listener): Unit = js.native

//  private def onF(eventName: String, f: Function0[Unit]): Listener = {
//    val listener: Listener = () => f.apply()
//    addListener(eventName, listener)
//    listener
//  }
//
//  def onMaximize(f: Function0[Unit]): Listener = onF("maximize", f)
//  def onUnmaximize(f: Function0[Unit]): Listener = onF("unmaximize", f)

}

