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
  val dialog: Dialog = js.native
}

@js.native
trait Remote extends js.Object {
  val app: App = js.native
  val dialog: Dialog = js.native
  def getCurrentWindow(): BrowserWindow = js.native
}

@js.native
trait App extends js.Object {
  def getVersion(): String = js.native
  def getName(): String = js.native
}

@js.native
trait Dialog extends js.Object {
  /**
    * Show an open dialog
    * //TODO add callback
    *
    * @param browserWindow The browserWindow argument allows the dialog to attach itself to a parent window, making it modal.
    * @param options       Options for dialog
    * @param callback      If provided, receives the selected files, and showOpenDialiog will return undefined
    *                      First parameter - filePaths String[] - An array of file paths chosen by the user
    *                      Second parameter - bookmarks String[] macOS mas - An array matching the filePaths array of base64
    *                      encoded strings which contains security scoped bookmark data. securityScopedBookmarks must be enabled
    *                      for this to be populated.
    */
  def showOpenDialog(
    browserWindow: js.UndefOr[BrowserWindow],
    options: DialogOptions,
    callback: js.UndefOr[js.Function2[js.Array[String], js.Array[String], Unit]]): js.UndefOr[js.Array[String]] = js.native
}

@js.native
trait FileFilter extends js.Object {
  var name: String
  var extensions: js.Array[String]
}

@js.native
trait DialogOptions extends js.Object {
  var title: js.UndefOr[String]
  var defaultPath: js.UndefOr[String]

  /**
    * Custom label for the confirmation button, when left empty the default label will be used.
    */
  var buttonLabel: js.UndefOr[String]

  var filters: js.UndefOr[js.Array[FileFilter]]

  /**
    * Contains which features the dialog should use. The following values are supported:
    *
    * openFile - Allow files to be selected.
    * openDirectory - Allow directories to be selected.
    * multiSelections - Allow multiple paths to be selected.
    * showHiddenFiles - Show hidden files in dialog.
    * createDirectory macOS - Allow creating new directories from dialog.
    * promptToCreate Windows - Prompt for creation if the file path entered in the dialog does not exist. This does not actually create the file at the path but allows non-existent paths to be returned that should be created by the application.
    * noResolveAliases macOS - Disable the automatic alias (symlink) path resolution. Selected aliases will now return the alias path instead of their target path.
    * treatPackageAsDirectory macOS - Treat packages, such as .app folders, as a directory instead of a file.
    */
  var properties: js.UndefOr[js.Array[String]]

  /**
    * macOS - Message to display above input boxes.
    */
  var message: js.UndefOr[String]

  /**
    * macOS - Create security scoped bookmarks when packaged for the Mac App Store.
    */
  var securityScopedBookmarks: js.UndefOr[Boolean]
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

