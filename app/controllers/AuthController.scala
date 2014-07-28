package controllers

import play.api.mvc._
import play.api._
import play.api.libs.Crypto
import play.api.libs.json.Json
import scala.concurrent.Future
import scala.concurrent.duration._
import play.api.libs.concurrent.Execution.Implicits._
import com.wordnik.swagger.annotations._
import ApiDocumentation._
import utils.AsyncHelper

@Api(value = "/auth", description = "Authentication operations")
object AuthController extends SecuredController {

  def options(path: String) =
    CrossOriginResource(parse.empty) { request => Future.successful(Ok) }

  /** 'user-0' to 'user-99' with password 'pass' are allowed **/
  val credentials: Map[String, String] =
    (for(i <- 0 to 99) yield (s"user-$i", "pass")).toMap

  @ApiOperation(
    value = "Authenticates the user.",
    notes = "Authenticates the user with a given password. Valid usernames are `user-1` to `user-10`. The password is `pass`",
    nickname = "auth",
    httpMethod = "POST")
  @ApiImplicitParams(Array(
    new ApiImplicitParam(name = "body", value = "JSON body must contain a username and password.", required = false,
      dataType = "application/json", paramType = "body", defaultValue = authBodyDefaultValue)))
  @ApiResponses(Array(
    new ApiResponse(code = 200, message = "Username and password is valid. Returns a token. The token contains the encrypted username."),
    new ApiResponse(code = 400, message = "Username or password not supplied."),
    new ApiResponse(code = 401, message = "Password is incorrect."),
    new ApiResponse(code = 401, message = "Username doesn't exist.")))
  def auth = Action.async(parse.json) { request =>
    Future {
      val usernameAndPasswordFromReqOpt = for {
        username <- (request.body \ "username").asOpt[String]
        password <- (request.body \ "password").asOpt[String]
      } yield (username, password)

      Logger.debug(s"Try to authenticate user ${usernameAndPasswordFromReqOpt.map(_._1).getOrElse("None")}")

      usernameAndPasswordFromReqOpt match {
        case None =>
          Logger.debug("Authentication error: Username or password not supplied.")
          BadRequest(Json.obj("error" -> "Username or password not supplied."))
        case Some((username, password)) => {
          if (credentials.contains(username)) {
            if (password == credentials(username)) {
              val token = Crypto.signToken(username)
              Logger.debug(s"Authentication successful. New token: $token")
              Ok(Json.obj("token" -> token))
            } else {
              Logger.debug("Authentication error: Password is incorrect.")
              Unauthorized(Json.obj("error" -> "Password is incorrect."))
            }
          } else {
            Logger.debug("Authentication error: Username doesn't exist.")
            Unauthorized(Json.obj("error" -> "Username doesn't exist."))
          }
        }
      }
    }
  }

  @ApiOperation(
    value = "Verifies the signed token in the body.",
    notes = "The signed token is retrieved from the body. The body Content-Type is `json`. If the token is valid the username will be extracted and returned.",
    nickname = "verify",
    httpMethod = "POST")
  @ApiImplicitParams(Array(
    new ApiImplicitParam(name = "body", value = "JSON body must contain a valid signed token.", required = true, dataType = "application/json",
      paramType = "body", defaultValue = verifyBodyDefaultValue)))
  @ApiResponses(Array(
    new ApiResponse(code = 200, message = "Token is valid. Returns the username."),
    new ApiResponse(code = 400, message = "Token not supplied."),
    new ApiResponse(code = 401, message = "Token is not valid.")))
  def verify = Action(parse.json) { request =>
    val tokenOpt: Option[String] = (request.body \ "token").asOpt[String]
    Logger.debug(s"Verify token ${tokenOpt.getOrElse("None")}")
    tokenOpt match {
      case None =>
        Logger.debug(s"Token not supplied.")
        BadRequest(Json.obj("error" -> "Token not supplied."))
      case Some(token) =>
        val tokenOpt: Option[String] = Crypto.extractSignedToken(token)
        tokenOpt match {
          case None =>
            Logger.debug(s"Token is not valid.")
            Unauthorized(Json.obj("error" -> "Token is not valid."))
          case Some(username) =>
            Logger.debug(s"Token is valid for user $username")
            Ok(Json.obj("username" -> username))
        }
    }
  }
}
