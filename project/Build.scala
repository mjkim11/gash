import sbt._
import Keys._
import play.Project._
import com.github.play2war.plugin._

object ApplicationBuild extends Build {

  val appName         = "gash"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    // Add your project dependencies here,
    javaCore,
    javaJdbc,
    javaEbean,
	"postgresql" % "postgresql" % "9.1-901-1.jdbc4",
	"org.jsoup" % "jsoup" % "1.7.2"
  )

// val main = play.Project(appName, appVersion, appDependencies).settings(
   // Add your own project settings here      
// )
  val main = PlayProject(appName, appVersion, appDependencies, mainLang = JAVA).settings(
  // ... Your own settings here
    Play2WarKeys.servletVersion := "2.5"
  ).settings(Play2WarPlugin.play2WarSettings: _*)

}
