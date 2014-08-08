// @SOURCE:/Users/mj/workspace/playbook-scala/authService/conf/routes
// @HASH:47466aa16fe722b6913ac2293f258d655b137998
// @DATE:Fri Aug 08 12:13:25 GMT 2014

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset

import Router.queryString


// @LINE:18
// @LINE:15
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:7
// @LINE:6
package controllers {

// @LINE:13
// @LINE:12
class ReverseApiHelpController {


// @LINE:12
def getResources(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "api")
}
                        

// @LINE:13
def getResource(): Call = {
   implicit val _rrc = new ReverseRouteContext(Map(("path", "/auth")))
   Call("GET", _prefix + { _defaultPrefix } + "api/auth")
}
                        

}
                          

// @LINE:11
class ReverseApiDocController {


// @LINE:11
def view(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix)
}
                        

}
                          

// @LINE:18
class ReverseAssets {


// @LINE:18
def at(file:String): Call = {
   implicit val _rrc = new ReverseRouteContext(Map(("path", "/public")))
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                        

}
                          

// @LINE:15
// @LINE:7
// @LINE:6
class ReverseAuthController {


// @LINE:7
def verify(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "verify")
}
                        

// @LINE:6
def auth(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "auth")
}
                        

// @LINE:15
def options(path:String): Call = {
   import ReverseRouteContext.empty
   Call("OPTIONS", _prefix + { _defaultPrefix } + implicitly[PathBindable[String]].unbind("path", path))
}
                        

}
                          
}
                  


// @LINE:18
// @LINE:15
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:7
// @LINE:6
package controllers.javascript {
import ReverseRouteContext.empty

// @LINE:13
// @LINE:12
class ReverseApiHelpController {


// @LINE:12
def getResources : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ApiHelpController.getResources",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api"})
      }
   """
)
                        

// @LINE:13
def getResource : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ApiHelpController.getResource",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/auth"})
      }
   """
)
                        

}
              

// @LINE:11
class ReverseApiDocController {


// @LINE:11
def view : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ApiDocController.view",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        

}
              

// @LINE:18
class ReverseAssets {


// @LINE:18
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        

}
              

// @LINE:15
// @LINE:7
// @LINE:6
class ReverseAuthController {


// @LINE:7
def verify : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.AuthController.verify",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "verify"})
      }
   """
)
                        

// @LINE:6
def auth : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.AuthController.auth",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "auth"})
      }
   """
)
                        

// @LINE:15
def options : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.AuthController.options",
   """
      function(path) {
      return _wA({method:"OPTIONS", url:"""" + _prefix + { _defaultPrefix } + """" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("path", path)})
      }
   """
)
                        

}
              
}
        


// @LINE:18
// @LINE:15
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:7
// @LINE:6
package controllers.ref {


// @LINE:13
// @LINE:12
class ReverseApiHelpController {


// @LINE:12
def getResources(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ApiHelpController.getResources(), HandlerDef(this.getClass.getClassLoader, "", "controllers.ApiHelpController", "getResources", Seq(), "GET", """""", _prefix + """api""")
)
                      

// @LINE:13
def getResource(path:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ApiHelpController.getResource(path), HandlerDef(this.getClass.getClassLoader, "", "controllers.ApiHelpController", "getResource", Seq(classOf[String]), "GET", """""", _prefix + """api/auth""")
)
                      

}
                          

// @LINE:11
class ReverseApiDocController {


// @LINE:11
def view(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ApiDocController.view(), HandlerDef(this.getClass.getClassLoader, "", "controllers.ApiDocController", "view", Seq(), "GET", """ API Documentation
 Swagger - Root Resources Listing""", _prefix + """""")
)
                      

}
                          

// @LINE:18
class ReverseAssets {


// @LINE:18
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      

}
                          

// @LINE:15
// @LINE:7
// @LINE:6
class ReverseAuthController {


// @LINE:7
def verify(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.AuthController.verify(), HandlerDef(this.getClass.getClassLoader, "", "controllers.AuthController", "verify", Seq(), "POST", """""", _prefix + """verify""")
)
                      

// @LINE:6
def auth(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.AuthController.auth(), HandlerDef(this.getClass.getClassLoader, "", "controllers.AuthController", "auth", Seq(), "POST", """""", _prefix + """auth""")
)
                      

// @LINE:15
def options(path:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.AuthController.options(path), HandlerDef(this.getClass.getClassLoader, "", "controllers.AuthController", "options", Seq(classOf[String]), "OPTIONS", """""", _prefix + """$path<.+>""")
)
                      

}
                          
}
        
    