
package org.rebeam.google.drive

import scala.scalajs.js.|
import scalajs.js
import scalajs.js.annotation.JSImport

@JSImport("googleapis", JSImport.Default)
@js.native
object Google extends js.Object {
  def drive(options: DriveOpts): Drive = js.native
}

@js.native
trait DriveOpts extends js.Object {
  var version: String = js.native
  var auth: OAuth2Client = js.native
}

@js.native
trait Drive extends js.Object {
  var files: Files = js.native
}

@js.native
trait Files extends js.Object {
  var list: Files = js.native
}


@JSImport("googleapis", "google.auth.OAuth2")
@js.native
class OAuth2Client(clientId: String, clientSecret: String, redirectUris: String, opts: js.UndefOr[AuthClientOpts]) extends js.Object {
  def setCredentials(credentials: Credentials): Unit = js.native
  def generateAuthUrl(opts: js.UndefOr[GenerateAuthUrlOpts]): String = js.native
  //callback is (err: AxiosError | null, token?: Credentials | null, res?: AxiosResponse | null): void;
  def getToken(code: String, callback: js.Function2[AxiosError, js.UndefOr[Credentials], Unit]): Unit = js.native
}

@js.native
trait Error extends js.Object {
  var stack: js.UndefOr[String] = js.native
}

@js.native
trait AxiosError extends Error {
//config: AxiosRequestConfig;
  var code: js.UndefOr[String]
//request?: any;
//response?: AxiosResponse;
}

@js.native
trait Credentials extends js.Object {
  var refresh_token: js.UndefOr[String] = js.native
  var expiry_date: js.UndefOr[Long] = js.native
  var access_token: js.UndefOr[String] = js.native
  var token_type: js.UndefOr[String] = js.native
  var id_token: js.UndefOr[String] = js.native
}

@js.native
trait GetTokenOptions extends js.Object {
  var code: String = js.native
  var codeVerifier: js.UndefOr[String] = js.native
  /**
    * The client ID for your application. The value passed into the constructor
    * will be used if not provided. Must match any client_id option passed to
    * a corresponding call to generateAuthUrl.
    */
  var client_id: js.UndefOr[String] = js.native
  /**
    * Determines where the API server redirects the user after the user
    * completes the authorization flow. The value passed into the constructor
    * will be used if not provided. Must match any redirect_uri option passed to
    * a corresponding call to generateAuthUrl.
    */
  var redirect_uri: js.UndefOr[String] = js.native
}

@js.native
trait AuthClientOpts extends js.Object {
  var authBaseUrl: js.UndefOr[String] = js.native
  var tokenUrl: js.UndefOr[String] = js.native
}

@js.native
trait GenerateAuthUrlOpts extends js.Object {
  /**
    * Recommended. Indicates whether your application can refresh access tokens
    * when the user is not present at the browser. Valid parameter values are
    * 'online', which is the default value, and 'offline'. Set the value to
    * 'offline' if your application needs to refresh access tokens when the user
    * is not present at the browser. This value instructs the Google
    * authorization server to return a refresh token and an access token the
    * first time that your application exchanges an authorization code for
    * tokens.
    */
  var access_type: js.UndefOr[String] = js.native
  /**
    * The 'response_type' will always be set to 'CODE'.
    */
  var response_type: js.UndefOr[String] = js.native
  /**
    * The client ID for your application. The value passed into the constructor
    * will be used if not provided. You can find this value in the API Console.
    */
  var client_id: js.UndefOr[String] = js.native
  /**
    * Determines where the API server redirects the user after the user
    * completes the authorization flow. The value must exactly match one of the
    * 'redirect_uri' values listed for your project in the API Console. Note that
    * the http or https scheme, case, and trailing slash ('/') must all match.
    * The value passed into the constructor will be used if not provided.
    */
  var redirect_uri: js.UndefOr[String] = js.native
  /**
    * Required. A space-delimited list of scopes that identify the resources that
    * your application could access on the user's behalf. These values inform the
    * consent screen that Google displays to the user. Scopes enable your
    * application to only request access to the resources that it needs while
    * also enabling users to control the amount of access that they grant to your
    * application. Thus, there is an inverse relationship between the number of
    * scopes requested and the likelihood of obtaining user consent. The
    * OAuth 2.0 API Scopes document provides a full list of scopes that you might
    * use to access Google APIs. We recommend that your application request
    * access to authorization scopes in context whenever possible. By requesting
    * access to user data in context, via incremental authorization, you help
    * users to more easily understand why your application needs the access it is
    * requesting.
    */
  var scope: js.Array[String] | String = js.native
  /**
    * Recommended. Specifies any string value that your application uses to
    * maintain state between your authorization request and the authorization
    * server's response. The server returns the exact value that you send as a
    * name=value pair in the hash (#) fragment of the 'redirect_uri' after the
    * user consents to or denies your application's access request. You can use
    * this parameter for several purposes, such as directing the user to the
    * correct resource in your application, sending nonces, and mitigating
    * cross-site request forgery. Since your redirect_uri can be guessed, using a
    * state value can increase your assurance that an incoming connection is the
    * result of an authentication request. If you generate a random string or
    * encode the hash of a cookie or another value that captures the client's
    * state, you can validate the response to additionally ensure that the
    * request and response originated in the same browser, providing protection
    * against attacks such as cross-site request forgery. See the OpenID Connect
    * documentation for an example of how to create and confirm a state token.
    */
  var state: js.UndefOr[String] = js.native
  /**
    * Optional. Enables applications to use incremental authorization to request
    * access to additional scopes in context. If you set this parameter's value
    * to true and the authorization request is granted, then the new access token
    * will also cover any scopes to which the user previously granted the
    * application access. See the incremental authorization section for examples.
    */
  var include_granted_scopes: js.UndefOr[Boolean] = js.native
  /**
    * Optional. If your application knows which user is trying to authenticate,
    * it can use this parameter to provide a hint to the Google Authentication
    * Server. The server uses the hint to simplify the login flow either by
    * prefilling the email field in the sign-in form or by selecting the
    * appropriate multi-login session. Set the parameter value to an email
    * address or sub identifier, which is equivalent to the user's Google ID.
    */
  var login_hint: js.UndefOr[String] = js.native
  /**
    * Optional. A space-delimited, case-sensitive list of prompts to present the
    * user. If you don't specify this parameter, the user will be prompted only
    * the first time your app requests access.  Possible values are:
    *
    * 'none' - Donot display any authentication or consent screens. Must not be
    *        specified with other values.
    * 'consent' - 	Prompt the user for consent.
    * 'select_account' - Prompt the user to select an account.
    */
  var prompt: js.UndefOr[String] = js.native
  /**
    * Recommended. Specifies what method was used to encode a 'code_verifier'
    * that will be used during authorization code exchange. This parameter must
    * be used with the 'code_challenge' parameter. The value of the
    * 'code_challenge_method' defaults to "plain" if not present in the request
    * that includes a 'code_challenge'. The only supported values for this
    * parameter are "S256" or "plain".
    */
  var code_challenge_method: js.UndefOr[CodeChallengeMethod] = js.native

  /**
    * Recommended. Specifies an encoded 'code_verifier' that will be used as a
    * server-side challenge during authorization code exchange. This parameter
    * must be used with the 'code_challenge' parameter described above.
    */
  var code_challenge: js.UndefOr[String] = js.native
}

/**
  * See [[http://www.w3.org/TR/WebCryptoAPI/#cryptokey-interface ¶ 13. CryptoKey Interface]] of w3c spec
  */
@js.native
trait CodeChallengeMethod extends js.Any

object CodeChallengeMethod {
  val plain = "plain".asInstanceOf[CodeChallengeMethod]
  val s256 = "S256".asInstanceOf[CodeChallengeMethod]
}

object DriveClient {

}