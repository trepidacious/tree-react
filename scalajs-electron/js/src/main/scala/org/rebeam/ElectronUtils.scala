package org.rebeam

import io.scalajs.nodejs.os._

import scala.util.Try

object ElectronUtils {

  val platformOSX = "darwin"

  private def toIntOption(s: String): Option[Int] = Try(s.toInt).toOption

  lazy val isOSXWithHiddenTitleBarSupport: Boolean = {
    //OS.release() for OSX is Darwin version - Darwin 13.0.0 is OSX 10.9.0 (Mavericks), which is the first version
    //supporting hidden title bar.
    OS.platform() == platformOSX &&
      OS.release().split('.').headOption.flatMap(toIntOption).exists(_ >= 13)
  }

}