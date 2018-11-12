package org.rebeam

import io.scalajs.nodejs.os._

import scala.scalajs.js
import scala.util.Try
import js.JSConverters._

object ElectronUtils {

  val platformOSX = "darwin"

  private def toIntOption(s: String): Option[Int] = Try(s.toInt).toOption

  lazy val isOSXWithHiddenTitleBarSupport: Boolean = {
    //OS.release() for OSX is Darwin version - Darwin 13.0.0 is OSX 10.9.0 (Mavericks), which is the first version
    //supporting hidden title bar.
    OS.platform() == platformOSX &&
      OS.release().split('.').headOption.flatMap(toIntOption).exists(_ >= 13)
  }

  sealed trait DialogProperty {
    val s: String
  }

  /**
    * Allow files to be selected.
    */
  case object OpenFile extends DialogProperty {
    val s: String = "openFile"
  }

  /**
    * Allow directories to be selected.
    */
  case object OpenDirectory extends DialogProperty {
    val s: String = "openDirectory"
  }

  /**
    * Allow multiple paths to be selected.
    */
  case object MultiSelections extends DialogProperty {
    val s: String = "multiSelections"
  }

  /**
    * Show hidden files in dialog.
    */
  case object ShowHiddenFiles extends DialogProperty {
    val s: String = "showHiddenFiles"
  }

  /**
    * macOS - Allow creating new directories from dialog.
    */
  case object CreateDirectory extends DialogProperty {
    val s: String = "createDirectory"
  }

  /**
    * Windows - Prompt for creation if the file path entered in the dialog does not exist.
    * This does not actually create the file at the path but allows non-existent paths to be returned
    * that should be created by the application.
    */
  case object PromptToCreate extends DialogProperty {
    val s: String = "promptToCreate"
  }

  /**
    * macOS - Disable the automatic alias (symlink) path resolution.
    * Selected aliases will now return the alias path instead of their target path.
    */
  case object NoResolveAliases extends DialogProperty {
    val s: String = "noResolveAliases"
  }

  /**
    * macOS - Treat packages, such as .app folders, as a directory instead of a file.
    */
  case object TreatPackageAsDirectory extends DialogProperty {
    val s: String = "treatPackageAsDirectory"
  }

  case class DialogFileFilter(name: String, extensions: List[String])

  private def options(
                      title: js.UndefOr[String],
                      defaultPath: js.UndefOr[String],
                      buttonLabel: js.UndefOr[String],
                      filters: List[DialogFileFilter],
                      properties: Set[DialogProperty],
                      message: js.UndefOr[String],
                      securityScopedBookmarks: js.UndefOr[Boolean]
                    ): DialogOptions = {
    val p = (new js.Object).asInstanceOf[DialogOptions]

    if (title.isDefined) {p.title = title}
    if (defaultPath.isDefined) {p.defaultPath = defaultPath}
    if (buttonLabel.isDefined) {p.buttonLabel = buttonLabel}

    if (properties.nonEmpty) {
      p.properties = properties.map(_.s).toJSArray
    }

    if (message.isDefined) {p.message = message}
    if (securityScopedBookmarks.isDefined) {p.securityScopedBookmarks = securityScopedBookmarks}

    if (filters.nonEmpty) {
      p.filters = filters.map(
        f => {
          val g = (new js.Object).asInstanceOf[FileFilter]
          g.name = f.name
          g.extensions = f.extensions.toJSArray
          g
        }
      ).toJSArray
    }

    p
  }

  def showOpenDialog(
    title: js.UndefOr[String] = js.undefined,
    defaultPath: js.UndefOr[String] = js.undefined,
    buttonLabel: js.UndefOr[String] = js.undefined,
    filters: List[DialogFileFilter] = Nil,
    properties: Set[DialogProperty] = Set.empty,
    message: js.UndefOr[String] = js.undefined,
    securityScopedBookmarks: js.UndefOr[Boolean] = js.undefined
  ): List[String] = {
    val p = options(title, defaultPath, buttonLabel, filters, properties, message, securityScopedBookmarks)
    Electron.remote.dialog.showOpenDialog(Electron.remote.getCurrentWindow(), p, js.undefined).toList.flatMap(_.toList)
  }

  def showOpenDialogAsync(
                      title: js.UndefOr[String] = js.undefined,
                      defaultPath: js.UndefOr[String] = js.undefined,
                      buttonLabel: js.UndefOr[String] = js.undefined,
                      filters: List[DialogFileFilter] = Nil,
                      properties: Set[DialogProperty] = Set.empty,
                      message: js.UndefOr[String] = js.undefined,
                      securityScopedBookmarks: js.UndefOr[Boolean] = js.undefined,
                      callback: List[String] => Unit
                    ): Unit = {
    val p = options(title, defaultPath, buttonLabel, filters, properties, message, securityScopedBookmarks)
    Electron.remote.dialog.showOpenDialog(
      Electron.remote.getCurrentWindow(),
      p,
      js.defined((filenames: js.UndefOr[js.Array[String]], _: js.UndefOr[js.Array[String]]) =>
        callback(filenames.toList.flatMap(_.toList)))
    ).toList.flatMap(_.toList)

    ()
  }

}