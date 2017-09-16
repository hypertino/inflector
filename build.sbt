scalaVersion := "2.12.3"

crossScalaVersions := Seq("2.12.3", "2.11.11", "2.10.6")

lazy val library = crossProject.settings(publishSettings:_*).settings(
  name := "inflector",
  version := "1.0.6",
  organization := "com.hypertino",
  libraryDependencies += "org.scalatest" %%% "scalatest" % "3.0.1" % "test",
  publishArtifact := true,
  publishArtifact in Test := false
).jsSettings(
  // JS-specific settings here
).jvmSettings(
  // JVM-specific settings here
)

lazy val js = library.js

lazy val jvm = library.jvm

lazy val publishSettings = Seq(
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
    </developers>,
  pgpSecretRing := file("./travis/ht-oss-private.asc"),
  pgpPublicRing := file("./travis/ht-oss-public.asc"),
  usePgpKeyHex("F8CDEF49B0EDEDCC"),
  pgpPassphrase := Option(System.getenv().get("oss_gpg_passphrase")).map(_.toCharArray),
  publishMavenStyle := true,
  pomIncludeRepository := { _ => false},
  publishTo := {
    val nexus = "https://oss.sonatype.org/"
    if (isSnapshot.value)
      Some("snapshots" at nexus + "content/repositories/snapshots")
    else
      Some("releases" at nexus + "service/local/staging/deploy/maven2")
  }
)

credentials ++= (for {
  username <- Option(System.getenv().get("sonatype_username"))
  password <- Option(System.getenv().get("sonatype_password"))
} yield Credentials("Sonatype Nexus Repository Manager", "oss.sonatype.org", username, password)).toSeq


publishArtifact in Test := false

publishArtifact := false

publish := ()

publishLocal := ()
