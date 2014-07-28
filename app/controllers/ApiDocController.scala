package controllers

import play.api.mvc._
import play.api.Logger

object ApiDocController extends Controller {

  def view = Action { request =>
    Ok(views.html.index(s"http://${request.host}/api"))
  }
}
