
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._

import play.api.templates.PlayMagic._
import models._
import controllers._
import play.api.i18n._
import play.api.mvc._
import play.api.data._
import views.html._

/**/
object index extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(url: String):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.15*/("""

"""),format.raw/*3.1*/("""<!DOCTYPE html>
<html>
<head>
  <title>Swagger UI</title>
  <link href='"""),_display_(/*7.16*/routes/*7.22*/.Assets.at("css/highlight.default.css")),format.raw/*7.61*/("""' media='screen' rel='stylesheet' type='text/css'/>
  <link href='"""),_display_(/*8.16*/routes/*8.22*/.Assets.at("css/screen.css")),format.raw/*8.50*/("""' media='screen' rel='stylesheet' type='text/css'/>
  <script type="text/javascript" src='"""),_display_(/*9.40*/routes/*9.46*/.Assets.at("lib/shred.bundle.js")),format.raw/*9.79*/("""'></script>
  <script src='"""),_display_(/*10.17*/routes/*10.23*/.Assets.at("lib/jquery-1.8.0.min.js")),format.raw/*10.60*/("""' type='text/javascript'></script>
  <script src='"""),_display_(/*11.17*/routes/*11.23*/.Assets.at("lib/jquery.slideto.min.js")),format.raw/*11.62*/("""' type='text/javascript'></script>
  <script src='"""),_display_(/*12.17*/routes/*12.23*/.Assets.at("lib/jquery.wiggle.min.js")),format.raw/*12.61*/("""' type='text/javascript'></script>
  <script src='"""),_display_(/*13.17*/routes/*13.23*/.Assets.at("lib/jquery.ba-bbq.min.js")),format.raw/*13.61*/("""' type='text/javascript'></script>
  <script src='"""),_display_(/*14.17*/routes/*14.23*/.Assets.at("lib/handlebars-1.0.0.js")),format.raw/*14.60*/("""' type='text/javascript'></script>
  <script src='"""),_display_(/*15.17*/routes/*15.23*/.Assets.at("lib/underscore-min.js")),format.raw/*15.58*/("""' type='text/javascript'></script>
  <script src='"""),_display_(/*16.17*/routes/*16.23*/.Assets.at("lib/backbone-min.js")),format.raw/*16.56*/("""' type='text/javascript'></script>
  <script src='"""),_display_(/*17.17*/routes/*17.23*/.Assets.at("lib/swagger.js")),format.raw/*17.51*/("""' type='text/javascript'></script>
  <script src='"""),_display_(/*18.17*/routes/*18.23*/.Assets.at("swagger-ui.js")),format.raw/*18.50*/("""' type='text/javascript'></script>
  <script src='"""),_display_(/*19.17*/routes/*19.23*/.Assets.at("lib/highlight.7.3.pack.js")),format.raw/*19.62*/("""' type='text/javascript'></script>
  <script type="text/javascript">
    $(function () """),format.raw/*21.19*/("""{"""),format.raw/*21.20*/("""
      """),format.raw/*22.7*/("""window.swaggerUi = new SwaggerUi("""),format.raw/*22.40*/("""{"""),format.raw/*22.41*/("""
      """),format.raw/*23.7*/("""url: """"),_display_(/*23.14*/url),format.raw/*23.17*/("""",
      dom_id: "swagger-ui-container",
      supportedSubmitMethods: ['get', 'post', 'put', 'delete'],
      onComplete: function(swaggerApi, swaggerUi)"""),format.raw/*26.50*/("""{"""),format.raw/*26.51*/("""
        """),format.raw/*27.9*/("""$('pre code').each(function(i, e) """),format.raw/*27.43*/("""{"""),format.raw/*27.44*/("""hljs.highlightBlock(e)"""),format.raw/*27.66*/("""}"""),format.raw/*27.67*/(""");
      """),format.raw/*28.7*/("""}"""),format.raw/*28.8*/(""",
      onFailure: function(data) """),format.raw/*29.33*/("""{"""),format.raw/*29.34*/("""
        """),format.raw/*30.9*/("""log("Unable to Load SwaggerUI");
      """),format.raw/*31.7*/("""}"""),format.raw/*31.8*/(""",
      docExpansion: "list"
    """),format.raw/*33.5*/("""}"""),format.raw/*33.6*/(""");

    $('#input_apiKey').change(function() """),format.raw/*35.42*/("""{"""),format.raw/*35.43*/("""
      """),format.raw/*36.7*/("""var key = $('#input_apiKey')[0].value;
      log("key: " + key);
      if(key && key.trim() != "") """),format.raw/*38.35*/("""{"""),format.raw/*38.36*/("""
        """),format.raw/*39.9*/("""log("added key " + key);
        window.authorizations.add("key", new ApiKeyAuthorization("api_key", key, "query"));
      """),format.raw/*41.7*/("""}"""),format.raw/*41.8*/("""
    """),format.raw/*42.5*/("""}"""),format.raw/*42.6*/(""")
    window.swaggerUi.load();
  """),format.raw/*44.3*/("""}"""),format.raw/*44.4*/(""");

  </script>
</head>

<body>
<div id='header'>
  <div class="swagger-ui-wrap">
    <a id="logo" href=""""),_display_(/*52.25*/url),format.raw/*52.28*/("""">eplay-auth</a>
  </div>
</div>

<div id="message-bar" class="swagger-ui-wrap">
  &nbsp;
</div>

<div id="swagger-ui-container" class="swagger-ui-wrap">

</div>

</body>

</html>
"""))}
  }

  def render(url:String): play.twirl.api.HtmlFormat.Appendable = apply(url)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (url) => apply(url)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Mon Jul 28 09:36:42 GMT 2014
                  SOURCE: /Users/mj/workspace/playbook-scala/authService/app/views/index.scala.html
                  HASH: d4d473778961a2b08513c07ebcc2535784abb10f
                  MATRIX: 505->1|606->14|636->18|739->95|753->101|812->140|906->208|920->214|968->242|1086->334|1100->340|1153->373|1209->402|1224->408|1282->445|1361->497|1376->503|1436->542|1515->594|1530->600|1589->638|1668->690|1683->696|1742->734|1821->786|1836->792|1894->829|1973->881|1988->887|2044->922|2123->974|2138->980|2192->1013|2271->1065|2286->1071|2335->1099|2414->1151|2429->1157|2477->1184|2556->1236|2571->1242|2631->1281|2748->1370|2777->1371|2812->1379|2873->1412|2902->1413|2937->1421|2971->1428|2995->1431|3180->1588|3209->1589|3246->1599|3308->1633|3337->1634|3387->1656|3416->1657|3453->1667|3481->1668|3544->1703|3573->1704|3610->1714|3677->1754|3705->1755|3767->1790|3795->1791|3870->1838|3899->1839|3934->1847|4063->1948|4092->1949|4129->1959|4281->2084|4309->2085|4342->2091|4370->2092|4432->2127|4460->2128|4601->2242|4625->2245
                  LINES: 19->1|22->1|24->3|28->7|28->7|28->7|29->8|29->8|29->8|30->9|30->9|30->9|31->10|31->10|31->10|32->11|32->11|32->11|33->12|33->12|33->12|34->13|34->13|34->13|35->14|35->14|35->14|36->15|36->15|36->15|37->16|37->16|37->16|38->17|38->17|38->17|39->18|39->18|39->18|40->19|40->19|40->19|42->21|42->21|43->22|43->22|43->22|44->23|44->23|44->23|47->26|47->26|48->27|48->27|48->27|48->27|48->27|49->28|49->28|50->29|50->29|51->30|52->31|52->31|54->33|54->33|56->35|56->35|57->36|59->38|59->38|60->39|62->41|62->41|63->42|63->42|65->44|65->44|73->52|73->52
                  -- GENERATED --
              */
          