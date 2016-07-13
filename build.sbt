name := """nice-uuid"""

organization := "biz.neumann"

version := "1.3"

scalaVersion := "2.11.8"

// Change this to another test framework if you prefer
libraryDependencies ++= Seq(
  "org.scala-lang" % "scala-reflect" % "2.11.7",
  "org.scalatest" %% "scalatest" % "2.2.4" % "test"
)

sonatypeProfileName := "biz.neumann"

publishMavenStyle := true

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

pomExtra in Global := (
  <url>https://github.com/daandi/nice-uuid</url>
  <licenses>
    <license>
      <name>BSD-style</name>
      <url>http://www.opensource.org/licenses/bsd-license.php</url>
      <distribution>repo</distribution>
    </license>
  </licenses>
  <scm>
    <developerConnection>git@github.com:daandi/nice-uuid.git</developerConnection>
    <connection>scm:git:git@github.com:daandi/nice-uuid.git</connection>
    <url>https://github.com/daandi/nice-uuid</url>
  </scm>
  <developers>
    <developer>
      <id>daandi</id>
      <name>Andreas Neumann</name>
      <url>http://www.neumann.biz</url>
    </developer>
  </developers>
)