
package org.rebeam.google.drive

sealed trait Scope {
  val url: String
}
object Scope {
  final case object Drive extends Scope {
    val url: String = "https://www.googleapis.com/auth/drive"
  }

  final case object DriveAppData extends Scope {
    val url: String = "https://www.googleapis.com/auth/drive.appdata"
  }

  final case object DriveFile extends Scope {
    val url: String = "https://www.googleapis.com/auth/drive.file"
  }

  final case object DriveMetadata extends Scope {
    val url: String = " https://www.googleapis.com/auth/drive.metadata"
  }

  final case object DriveMetaDataReadOnly extends Scope {
    val url: String = "https://www.googleapis.com/auth/drive.metadata.readonly"
  }

  final case object DrivePhotosReadOnly extends Scope {
    val url: String = "https://www.googleapis.com/auth/drive.photos.readonly"
  }

  final case object DriveReadOnly extends Scope {
    val url: String = "https://www.googleapis.com/auth/drive.readonly"
  }

}
