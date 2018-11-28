//package org.rebeam.google.drive
//
//import scala.scalajs.js
//import js.annotation._
//import js.|
//
//package importedjs {
//
//package gapi {
//
//package client {
//
//package drive {
//
//  @js.native
//  trait About extends js.Object {
//    var appInstalled: Boolean = js.native
//    var canCreateTeamDrives: Boolean = js.native
//    var exportFormats: Record[String, js.Array[String]] = js.native
//    var folderColorPalette: js.Array[String] = js.native
//    var importFormats: Record[String, js.Array[String]] = js.native
//    var kind: String = js.native
//    var maxImportSizes: Record[String, String] = js.native
//    var maxUploadSize: String = js.native
//    var storageQuota: About.StorageQuota = js.native
//    var teamDriveThemes: js.Array[js.Any] = js.native
//    var user: User = js.native
//  }
//
//  object About {
//
//    @js.native
//    trait StorageQuota extends js.Object {
//      var limit: String = js.native
//      var usage: String = js.native
//      var usageInDrive: String = js.native
//      var usageInDriveTrash: String = js.native
//    }
//  }
//
//  @js.native
//  trait Change extends js.Object {
//    var file: File = js.native
//    var fileId: String = js.native
//    var kind: String = js.native
//    var removed: Boolean = js.native
//    var teamDrive: TeamDrive = js.native
//    var teamDriveId: String = js.native
//    var time: String = js.native
//    var `type`: String = js.native
//  }
//
//  @js.native
//  trait ChangeList extends js.Object {
//    var changes: js.Array[Change] = js.native
//    var kind: String = js.native
//    var newStartPageToken: String = js.native
//    var nextPageToken: String = js.native
//  }
//
//  @js.native
//  trait Channel extends js.Object {
//    var address: String = js.native
//    var expiration: String = js.native
//    var id: String = js.native
//    var kind: String = js.native
//    var params: Record[String, String] = js.native
//    var payload: Boolean = js.native
//    var resourceId: String = js.native
//    var resourceUri: String = js.native
//    var token: String = js.native
//    var `type`: String = js.native
//  }
//
//  @js.native
//  trait Comment extends js.Object {
//    var anchor: String = js.native
//    var author: User = js.native
//    var content: String = js.native
//    var createdTime: String = js.native
//    var deleted: Boolean = js.native
//    var htmlContent: String = js.native
//    var id: String = js.native
//    var kind: String = js.native
//    var modifiedTime: String = js.native
//    var quotedFileContent: Comment.QuotedFileContent = js.native
//    var replies: js.Array[Reply] = js.native
//    var resolved: Boolean = js.native
//  }
//
//  object Comment {
//
//    @js.native
//    trait QuotedFileContent extends js.Object {
//      var mimeType: String = js.native
//      var value: String = js.native
//    }
//  }
//
//  @js.native
//  trait CommentList extends js.Object {
//    var comments: js.Array[Comment] = js.native
//    var kind: String = js.native
//    var nextPageToken: String = js.native
//  }
//
//  @js.native
//  trait File extends js.Object {
//    var appProperties: Record[String, String] = js.native
//    var capabilities: File.Capabilities = js.native
//    var contentHints: File.ContentHints = js.native
//    var createdTime: String = js.native
//    var description: String = js.native
//    var explicitlyTrashed: Boolean = js.native
//    var fileExtension: String = js.native
//    var folderColorRgb: String = js.native
//    var fullFileExtension: String = js.native
//    var hasAugmentedPermissions: Boolean = js.native
//    var hasThumbnail: Boolean = js.native
//    var headRevisionId: String = js.native
//    var iconLink: String = js.native
//    var id: String = js.native
//    var imageMediaMetadata: File.ImageMediaMetadata = js.native
//    var isAppAuthorized: Boolean = js.native
//    var kind: String = js.native
//    var lastModifyingUser: User = js.native
//    var md5Checksum: String = js.native
//    var mimeType: String = js.native
//    var modifiedByMe: Boolean = js.native
//    var modifiedByMeTime: String = js.native
//    var modifiedTime: String = js.native
//    var name: String = js.native
//    var originalFilename: String = js.native
//    var ownedByMe: Boolean = js.native
//    var owners: js.Array[User] = js.native
//    var parents: js.Array[String] = js.native
//    var permissionIds: js.Array[String] = js.native
//    var permissions: js.Array[Permission] = js.native
//    var properties: Record[String, String] = js.native
//    var quotaBytesUsed: String = js.native
//    var shared: Boolean = js.native
//    var sharedWithMeTime: String = js.native
//    var sharingUser: User = js.native
//    var size: String = js.native
//    var spaces: js.Array[String] = js.native
//    var starred: Boolean = js.native
//    var teamDriveId: String = js.native
//    var thumbnailLink: String = js.native
//    var thumbnailVersion: String = js.native
//    var trashed: Boolean = js.native
//    var trashedTime: String = js.native
//    var trashingUser: User = js.native
//    var version: String = js.native
//    var videoMediaMetadata: File.VideoMediaMetadata = js.native
//    var viewedByMe: Boolean = js.native
//    var viewedByMeTime: String = js.native
//    var viewersCanCopyContent: Boolean = js.native
//    var webContentLink: String = js.native
//    var webViewLink: String = js.native
//    var writersCanShare: Boolean = js.native
//  }
//
//  object File {
//
//    @js.native
//    trait Capabilities extends js.Object {
//      var canAddChildren: Boolean = js.native
//      var canChangeViewersCanCopyContent: Boolean = js.native
//      var canComment: Boolean = js.native
//      var canCopy: Boolean = js.native
//      var canDelete: Boolean = js.native
//      var canDownload: Boolean = js.native
//      var canEdit: Boolean = js.native
//      var canListChildren: Boolean = js.native
//      var canMoveItemIntoTeamDrive: Boolean = js.native
//      var canMoveTeamDriveItem: Boolean = js.native
//      var canReadRevisions: Boolean = js.native
//      var canReadTeamDrive: Boolean = js.native
//      var canRemoveChildren: Boolean = js.native
//      var canRename: Boolean = js.native
//      var canShare: Boolean = js.native
//      var canTrash: Boolean = js.native
//      var canUntrash: Boolean = js.native
//    }
//
//    @js.native
//    trait ContentHints extends js.Object {
//      var indexableText: String = js.native
//      var thumbnail: ContentHints.Thumbnail = js.native
//    }
//
//    object ContentHints {
//
//      @js.native
//      trait Thumbnail extends js.Object {
//        var image: String = js.native
//        var mimeType: String = js.native
//      }
//    }
//
//    @js.native
//    trait ImageMediaMetadata extends js.Object {
//      var aperture: Double = js.native
//      var cameraMake: String = js.native
//      var cameraModel: String = js.native
//      var colorSpace: String = js.native
//      var exposureBias: Double = js.native
//      var exposureMode: String = js.native
//      var exposureTime: Double = js.native
//      var flashUsed: Boolean = js.native
//      var focalLength: Double = js.native
//      var height: Double = js.native
//      var isoSpeed: Double = js.native
//      var lens: String = js.native
//      var location: ImageMediaMetadata.Location = js.native
//      var maxApertureValue: Double = js.native
//      var meteringMode: String = js.native
//      var rotation: Double = js.native
//      var sensor: String = js.native
//      var subjectDistance: Double = js.native
//      var time: String = js.native
//      var whiteBalance: String = js.native
//      var width: Double = js.native
//    }
//
//    object ImageMediaMetadata {
//
//      @js.native
//      trait Location extends js.Object {
//        var altitude: Double = js.native
//        var latitude: Double = js.native
//        var longitude: Double = js.native
//      }
//    }
//
//    @js.native
//    trait VideoMediaMetadata extends js.Object {
//      var durationMillis: String = js.native
//      var height: Double = js.native
//      var width: Double = js.native
//    }
//  }
//
//  @js.native
//  trait FileList extends js.Object {
//    var files: js.Array[File] = js.native
//    var incompleteSearch: Boolean = js.native
//    var kind: String = js.native
//    var nextPageToken: String = js.native
//  }
//
//  @js.native
//  trait GeneratedIds extends js.Object {
//    var ids: js.Array[String] = js.native
//    var kind: String = js.native
//    var space: String = js.native
//  }
//
//  @js.native
//  trait Permission extends js.Object {
//    var allowFileDiscovery: Boolean = js.native
//    var deleted: Boolean = js.native
//    var displayName: String = js.native
//    var domain: String = js.native
//    var emailAddress: String = js.native
//    var expirationTime: String = js.native
//    var id: String = js.native
//    var kind: String = js.native
//    var photoLink: String = js.native
//    var role: String = js.native
//    var teamDrivePermissionDetails: js.Array[js.Any] = js.native
//    var `type`: String = js.native
//  }
//
//  @js.native
//  trait PermissionList extends js.Object {
//    var kind: String = js.native
//    var nextPageToken: String = js.native
//    var permissions: js.Array[Permission] = js.native
//  }
//
//  @js.native
//  trait Reply extends js.Object {
//    var action: String = js.native
//    var author: User = js.native
//    var content: String = js.native
//    var createdTime: String = js.native
//    var deleted: Boolean = js.native
//    var htmlContent: String = js.native
//    var id: String = js.native
//    var kind: String = js.native
//    var modifiedTime: String = js.native
//  }
//
//  @js.native
//  trait ReplyList extends js.Object {
//    var kind: String = js.native
//    var nextPageToken: String = js.native
//    var replies: js.Array[Reply] = js.native
//  }
//
//  @js.native
//  trait Revision extends js.Object {
//    var id: String = js.native
//    var keepForever: Boolean = js.native
//    var kind: String = js.native
//    var lastModifyingUser: User = js.native
//    var md5Checksum: String = js.native
//    var mimeType: String = js.native
//    var modifiedTime: String = js.native
//    var originalFilename: String = js.native
//    var publishAuto: Boolean = js.native
//    var published: Boolean = js.native
//    var publishedOutsideDomain: Boolean = js.native
//    var size: String = js.native
//  }
//
//  @js.native
//  trait RevisionList extends js.Object {
//    var kind: String = js.native
//    var nextPageToken: String = js.native
//    var revisions: js.Array[Revision] = js.native
//  }
//
//  @js.native
//  trait StartPageToken extends js.Object {
//    var kind: String = js.native
//    var startPageToken: String = js.native
//  }
//
//  @js.native
//  trait TeamDrive extends js.Object {
//    var backgroundImageFile: TeamDrive.BackgroundImageFile = js.native
//    var backgroundImageLink: String = js.native
//    var capabilities: TeamDrive.Capabilities = js.native
//    var colorRgb: String = js.native
//    var createdTime: String = js.native
//    var id: String = js.native
//    var kind: String = js.native
//    var name: String = js.native
//    var themeId: String = js.native
//  }
//
//  object TeamDrive {
//
//    @js.native
//    trait BackgroundImageFile extends js.Object {
//      var id: String = js.native
//      var width: Double = js.native
//      var xCoordinate: Double = js.native
//      var yCoordinate: Double = js.native
//    }
//
//    @js.native
//    trait Capabilities extends js.Object {
//      var canAddChildren: Boolean = js.native
//      var canChangeTeamDriveBackground: Boolean = js.native
//      var canComment: Boolean = js.native
//      var canCopy: Boolean = js.native
//      var canDeleteTeamDrive: Boolean = js.native
//      var canDownload: Boolean = js.native
//      var canEdit: Boolean = js.native
//      var canListChildren: Boolean = js.native
//      var canManageMembers: Boolean = js.native
//      var canReadRevisions: Boolean = js.native
//      var canRemoveChildren: Boolean = js.native
//      var canRename: Boolean = js.native
//      var canRenameTeamDrive: Boolean = js.native
//      var canShare: Boolean = js.native
//    }
//  }
//
//  @js.native
//  trait TeamDriveList extends js.Object {
//    var kind: String = js.native
//    var nextPageToken: String = js.native
//    var teamDrives: js.Array[TeamDrive] = js.native
//  }
//
//  @js.native
//  trait User extends js.Object {
//    var displayName: String = js.native
//    var emailAddress: String = js.native
//    var kind: String = js.native
//    var me: Boolean = js.native
//    var permissionId: String = js.native
//    var photoLink: String = js.native
//  }
//
//  @js.native
//  trait AboutResource extends js.Object {
//    def get(request: js.Any): Request[About] = js.native
//  }
//
//  @js.native
//  trait ChangesResource extends js.Object {
//    def getStartPageToken(request: js.Any): Request[StartPageToken] = js.native
//    def list(request: js.Any): Request[ChangeList] = js.native
//    def watch(request: js.Any): Request[Channel] = js.native
//  }
//
//  @js.native
//  trait ChannelsResource extends js.Object {
//    def stop(request: js.Any): Request[Unit] = js.native
//  }
//
//  @js.native
//  trait CommentsResource extends js.Object {
//    def create(request: js.Any): Request[Comment] = js.native
//    def delete(request: js.Any): Request[Unit] = js.native
//    def get(request: js.Any): Request[Comment] = js.native
//    def list(request: js.Any): Request[CommentList] = js.native
//    def update(request: js.Any): Request[Comment] = js.native
//  }
//
//  @js.native
//  trait FilesResource extends js.Object {
//    def copy(request: js.Any): Request[File] = js.native
//    def create(request: js.Any): Request[File] = js.native
//    def delete(request: js.Any): Request[Unit] = js.native
//    def emptyTrash(request: js.Any): Request[Unit] = js.native
//    def export(request: js.Any): Request[Unit] = js.native
//    def generateIds(request: js.Any): Request[GeneratedIds] = js.native
//    def get(request: js.Any): Request[File] = js.native
//    def list(request: js.Any): Request[FileList] = js.native
//    def update(request: js.Any): Request[File] = js.native
//    def watch(request: js.Any): Request[Channel] = js.native
//  }
//
//  @js.native
//  trait PermissionsResource extends js.Object {
//    def create(request: js.Any): Request[Permission] = js.native
//    def delete(request: js.Any): Request[Unit] = js.native
//    def get(request: js.Any): Request[Permission] = js.native
//    def list(request: js.Any): Request[PermissionList] = js.native
//    def update(request: js.Any): Request[Permission] = js.native
//  }
//
//  @js.native
//  trait RepliesResource extends js.Object {
//    def create(request: js.Any): Request[Reply] = js.native
//    def delete(request: js.Any): Request[Unit] = js.native
//    def get(request: js.Any): Request[Reply] = js.native
//    def list(request: js.Any): Request[ReplyList] = js.native
//    def update(request: js.Any): Request[Reply] = js.native
//  }
//
//  @js.native
//  trait RevisionsResource extends js.Object {
//    def delete(request: js.Any): Request[Unit] = js.native
//    def get(request: js.Any): Request[Revision] = js.native
//    def list(request: js.Any): Request[RevisionList] = js.native
//    def update(request: js.Any): Request[Revision] = js.native
//  }
//
//  @js.native
//  trait TeamdrivesResource extends js.Object {
//    def create(request: js.Any): Request[TeamDrive] = js.native
//    def delete(request: js.Any): Request[Unit] = js.native
//    def get(request: js.Any): Request[TeamDrive] = js.native
//    def list(request: js.Any): Request[TeamDriveList] = js.native
//    def update(request: js.Any): Request[TeamDrive] = js.native
//  }
//
//  @js.native
//  @JSGlobal("gapi.client.drive")
//  object Drive extends js.Object {
//    val about: AboutResource = js.native
//    val changes: ChangesResource = js.native
//    val channels: ChannelsResource = js.native
//    val comments: CommentsResource = js.native
//    val files: FilesResource = js.native
//    val permissions: PermissionsResource = js.native
//    val replies: RepliesResource = js.native
//    val revisions: RevisionsResource = js.native
//    val teamdrives: TeamdrivesResource = js.native
//  }
//
//}
