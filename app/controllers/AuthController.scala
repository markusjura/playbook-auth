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

@Api(value = "/auth", description = "Authentication operations")
object AuthController extends SecuredController {

  def options(path: String) =
    CrossOriginResource(parse.empty) { request => Future.successful(Ok) }

  /** 'user-0' to 'user-99' with password 'pass' are allowed **/
  val credentials: Map[String, String] =
    (for(i <- 0 to 9) yield (s"user-$i", "pass")).toMap

  @ApiOperation(
    value = "Authenticates the user.",
    notes = "Authenticates the user with a given password. Valid user ids are `user-1` to `user-10`. The password is `pass`",
    nickname = "auth",
    httpMethod = "POST")
  @ApiImplicitParams(Array(
    new ApiImplicitParam(name = "body", value = "JSON body must contain a user id and password.", required = false,
      dataType = "application/json", paramType = "body", defaultValue = authBodyDefaultValue)))
  @ApiResponses(Array(
    new ApiResponse(code = 200, message = "User id and password is valid. Returns a token. The token contains the encrypted user id."),
    new ApiResponse(code = 400, message = "User id or password not supplied."),
    new ApiResponse(code = 401, message = "Password is incorrect."),
    new ApiResponse(code = 401, message = "User id doesn't exist.")))
  def auth = Action.async(parse.json) { request =>
    Future {
      val uidAndPasswordFromReqOpt = for {
        uid <- (request.body \ "uid").asOpt[String]
        password <- (request.body \ "password").asOpt[String]
      } yield (uid, password)

      Logger.debug(s"Try to authenticate user ${uidAndPasswordFromReqOpt.map(_._1).getOrElse("None")}")

      uidAndPasswordFromReqOpt match {
        case None =>
          Logger.debug("Authentication error: User id or password not supplied.")
          BadRequest(Json.obj("error" -> "User id or password not supplied."))
        case Some((uid, password)) => {
          if (credentials.contains(uid)) {
            if (password == credentials(uid)) {
              val token = Crypto.signToken(uid)
              Logger.debug(s"Authentication successful. New token: $token")
              Ok(Json.obj("token" -> token))
            } else {
              Logger.debug("Authentication error: Password is incorrect.")
              Unauthorized(Json.obj("error" -> "Password is incorrect."))
            }
          } else {
            Logger.debug("Authentication error: User id doesn't exist.")
            Unauthorized(Json.obj("error" -> "User id doesn't exist."))
          }
        }
      }
    }
  }

  @ApiOperation(
    value = "Verifies the signed token in the body.",
    notes = "The signed token is retrieved from the body. The body Content-Type is `json`. If the token is valid the user id will be extracted and returned.",
    nickname = "verify",
    httpMethod = "POST")
  @ApiImplicitParams(Array(
    new ApiImplicitParam(name = "body", value = "JSON body must contain a valid signed token.", required = true, dataType = "application/json",
      paramType = "body", defaultValue = verifyBodyDefaultValue)))
  @ApiResponses(Array(
    new ApiResponse(code = 200, message = "Token is valid. Returns the user id."),
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
          case Some(uid) =>
            Logger.debug(s"Token is valid for user $uid")
            Ok(Json.obj("uid" -> uid))
        }
    }
  }
}
