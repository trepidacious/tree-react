package org.rebeam.google.drive

import io.circe.generic.extras.Configuration
import io.circe.generic.extras.semiauto._
import io.circe.{Decoder, Encoder}

object OAuth2 {

  implicit val customConfig: Configuration = Configuration.default.withSnakeCaseMemberNames.withDefaults

//  case class CredentialStore(installed: Credentials)
//
//  //TODO is it possible to use @JsonCodec with a configuration?
//  object CredentialStore {
//    implicit val encoder: Encoder[CredentialStore] = deriveEncoder
//    implicit val decoder: Decoder[CredentialStore] = deriveDecoder
//  }
//
//  case class Credentials (
//    clientId: String,
//    projectId: String,
//    authUri: String,
//    tokenUri: String,
//    authProviderX509CertUrl: String,
//    clientSecret: String,
//    redirectUris: List[String]
//  )
//
//  object Credentials {
//    implicit val encoder: Encoder[Credentials] = deriveEncoder
//    implicit val decoder: Decoder[Credentials] = deriveDecoder
//  }

  /**
    * Scala equivalent of OAuth2Client's Credentials
    * @param accessToken
    * @param refreshToken
    * @param scope
    * @param tokenType
    * @param expiryDate
    */
  case class Credentials (
    accessToken: String,
    refreshToken: String,
    scope: String,
    tokenType: String,
    expiryDate: Long
  )

  object Credentials {
    implicit val encoder: Encoder[Credentials] = deriveEncoder
    implicit val decoder: Decoder[Credentials] = deriveDecoder
  }

}