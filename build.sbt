name := "playbook-auth"

version := "0.1.0"

scalaVersion := "2.10.4"

resolvers += Resolver.url("Markus Jura fork swagger-play2", url("http://markusjura.github.com/swagger-play2"))(Resolver.ivyStylePatterns)

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "2.2.0" % "test",
  "swagger-play2" %% "swagger-play2" % "1.3.5"
)

lazy val root = (project in file(".")).enablePlugins(PlayScala)