lazy val Name = "resty-sample"
lazy val Version = "0.0.12"
lazy val ScalaVersion = "2.12.4"
lazy val JettyVersion = "9.3.9.v20160517"

lazy val project = Project(Name, file("."))
  .settings(
    name := Name,
    version := Version,
    scalaVersion := ScalaVersion,
    libraryDependencies ++= Seq(
      "com.github.takezoe"  %% "resty"             % Version,
      "org.eclipse.jetty"   %  "jetty-webapp"      % JettyVersion % "container",
      "org.eclipse.jetty"   %  "jetty-plus"        % JettyVersion % "container",
      "org.eclipse.jetty"   %  "jetty-annotations" % JettyVersion % "container",
      "javax.servlet"       %  "javax.servlet-api" % "3.1.0" % "provided"
    ),
    scalacOptions := Seq("-deprecation"),
    javaOptions in Jetty ++= Seq(
      "-Xdebug",
      "-Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=8000"
    ),
    artifactName := { (_, module: ModuleID, artifact: Artifact) =>
      artifact.name + "." + artifact.extension
    }
  )
  .enablePlugins(JettyPlugin)

