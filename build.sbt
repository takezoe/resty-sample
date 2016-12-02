//lazy val Organization = "organization"
lazy val Name = "resty-sample"
lazy val Version = "0.0.2"
lazy val ScalaVersion = "2.12.0"
lazy val JettyVersion = "9.3.9.v20160517"

lazy val project = Project(Name, file("."))
  .settings(
    name := "resty-sample",
    scalaVersion := "2.12.0",
    libraryDependencies ++= Seq(
      "com.github.takezoe"  %% "resty"             % "0.0.2",
      "org.eclipse.jetty"   %  "jetty-webapp"      % JettyVersion % "container",
      "org.eclipse.jetty"   %  "jetty-plus"        % JettyVersion % "container",
      "org.eclipse.jetty"   %  "jetty-annotations" % JettyVersion % "container",
      "javax.servlet"       %  "javax.servlet-api" % "3.0.1" % "provided"
    ),
    scalacOptions := Seq("-deprecation"),
    javaOptions in Jetty ++= Seq(
      "-Xdebug",
      "-Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=8000"
    )
  )
  .enablePlugins(JettyPlugin)

