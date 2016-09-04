import sbt.Keys._

version := "1.0-SNAPSHOT"

crossScalaVersions := Seq("2.11.8", "2.10.6", "2.12.0-M5")

name := "inflector"

organization := "com.hypertino"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.0.0" % "test"
)

pomExtra := <url>https://github.com/hypertino/inflector</url>
  <licenses>
    <license>
      <name>BSD-style</name>
      <url>http://opensource.org/licenses/BSD-3-Clause</url>
      <distribution>repo</distribution>
    </license>
  </licenses>
  <scm>
    <url>git@github.com:hypertino/inflector.git</url>
    <connection>scm:git:git@github.com:hypertino/inflector.git</connection>
  </scm>
  <developers>
    <developer>
      <id>maqdev</id>
      <name>Magomed Abdurakhmanov</name>
      <url>https://github.com/maqdev</url>
    </developer>
    <developer>
      <id>hypertino</id>
      <name>Hypertino</name>
      <url>https://github.com/hypertino</url>
    </developer>
  </developers>

credentials ++= (for {
  username <- Option(System.getenv().get("sonatype_username"))
  password <- Option(System.getenv().get("sonatype_password"))
} yield Credentials("Sonatype Nexus Repository Manager", "oss.sonatype.org", username, password)).toSeq

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases" at nexus + "service/local/staging/deploy/maven2")
}

pgpSecretRing := file("ht-oss-private.asc")

pgpPublicRing := file("ht-oss-public.asc")

usePgpKeyHex("F8CDEF49B0EDEDCC")

pgpPassphrase := Option(System.getenv().get("oss_gpg_passphrase")).map(_.toCharArray)

publishArtifact := true

publishMavenStyle := true

publishArtifact in Test := false

pomIncludeRepository := { _ => false}
