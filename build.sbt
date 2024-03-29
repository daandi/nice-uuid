name := "nice-uuid"
organization := "biz.neumann"
version := "1.5"
scalaVersion := "2.13.7"
crossScalaVersions := Seq("2.12.5", "2.13.7")

// Change this to another test framework if you prefer
libraryDependencies ++= Seq(
  "org.scala-lang" % "scala-reflect" % "2.12.15",
  "org.scalatest" %% "scalatest" % "3.2.10" % "test"
)

sonatypeProfileName := "biz.neumann"
publishMavenStyle := true
Test / publishArtifact := false
pomIncludeRepository := { _ => false }
 Global / pomExtra := (
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