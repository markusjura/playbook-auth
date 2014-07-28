// @SOURCE:/Users/mj/workspace/eplay-scala/authService/conf/routes
// @HASH:47466aa16fe722b6913ac2293f258d655b137998
// @DATE:Thu Jul 10 13:59:04 GMT 2014


import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset

import Router.queryString

object Routes extends Router.Routes {

import ReverseRouteContext.empty

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:6
private[this] lazy val controllers_AuthController_auth0_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth"))))
private[this] lazy val controllers_AuthController_auth0_invoker = createInvoker(
controllers.AuthController.auth,
HandlerDef(this.getClass.getClassLoader, "", "controllers.AuthController", "auth", Nil,"POST", """""", Routes.prefix + """auth"""))
        

// @LINE:7
private[this] lazy val controllers_AuthController_verify1_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("verify"))))
private[this] lazy val controllers_AuthController_verify1_invoker = createInvoker(
controllers.AuthController.verify,
HandlerDef(this.getClass.getClassLoader, "", "controllers.AuthController", "verify", Nil,"POST", """""", Routes.prefix + """verify"""))
        

// @LINE:11
private[this] lazy val controllers_ApiDocController_view2_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
private[this] lazy val controllers_ApiDocController_view2_invoker = createInvoker(
controllers.ApiDocController.view,
HandlerDef(this.getClass.getClassLoader, "", "controllers.ApiDocController", "view", Nil,"GET", """ API Documentation
 Swagger - Root Resources Listing""", Routes.prefix + """"""))
        

// @LINE:12
private[this] lazy val controllers_ApiHelpController_getResources3_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api"))))
private[this] lazy val controllers_ApiHelpController_getResources3_invoker = createInvoker(
controllers.ApiHelpController.getResources,
HandlerDef(this.getClass.getClassLoader, "", "controllers.ApiHelpController", "getResources", Nil,"GET", """""", Routes.prefix + """api"""))
        

// @LINE:13
private[this] lazy val controllers_ApiHelpController_getResource4_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/auth"))))
private[this] lazy val controllers_ApiHelpController_getResource4_invoker = createInvoker(
controllers.ApiHelpController.getResource(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.ApiHelpController", "getResource", Seq(classOf[String]),"GET", """""", Routes.prefix + """api/auth"""))
        

// @LINE:15
private[this] lazy val controllers_AuthController_options5_route = Route("OPTIONS", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),DynamicPart("path", """.+""",false))))
private[this] lazy val controllers_AuthController_options5_invoker = createInvoker(
controllers.AuthController.options(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.AuthController", "options", Seq(classOf[String]),"OPTIONS", """""", Routes.prefix + """$path<.+>"""))
        

// @LINE:18
private[this] lazy val controllers_Assets_at6_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
private[this] lazy val controllers_Assets_at6_invoker = createInvoker(
controllers.Assets.at(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
        
def documentation = List(("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth""","""controllers.AuthController.auth"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """verify""","""controllers.AuthController.verify"""),("""GET""", prefix,"""controllers.ApiDocController.view"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api""","""controllers.ApiHelpController.getResources"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/auth""","""controllers.ApiHelpController.getResource(path:String = "/auth")"""),("""OPTIONS""", prefix + (if(prefix.endsWith("/")) "" else "/") + """$path<.+>""","""controllers.AuthController.options(path:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]]
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_AuthController_auth0_route(params) => {
   call { 
        controllers_AuthController_auth0_invoker.call(controllers.AuthController.auth)
   }
}
        

// @LINE:7
case controllers_AuthController_verify1_route(params) => {
   call { 
        controllers_AuthController_verify1_invoker.call(controllers.AuthController.verify)
   }
}
        

// @LINE:11
case controllers_ApiDocController_view2_route(params) => {
   call { 
        controllers_ApiDocController_view2_invoker.call(controllers.ApiDocController.view)
   }
}
        

// @LINE:12
case controllers_ApiHelpController_getResources3_route(params) => {
   call { 
        controllers_ApiHelpController_getResources3_invoker.call(controllers.ApiHelpController.getResources)
   }
}
        

// @LINE:13
case controllers_ApiHelpController_getResource4_route(params) => {
   call(Param[String]("path", Right("/auth"))) { (path) =>
        controllers_ApiHelpController_getResource4_invoker.call(controllers.ApiHelpController.getResource(path))
   }
}
        

// @LINE:15
case controllers_AuthController_options5_route(params) => {
   call(params.fromPath[String]("path", None)) { (path) =>
        controllers_AuthController_options5_invoker.call(controllers.AuthController.options(path))
   }
}
        

// @LINE:18
case controllers_Assets_at6_route(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at6_invoker.call(controllers.Assets.at(path, file))
   }
}
        
}

}
     