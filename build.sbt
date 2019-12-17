import sbtcrossproject.CrossPlugin.autoImport.{crossProject, CrossType}

lazy val scala213 = "2.13.1"
lazy val scala212 = "2.12.10"
lazy val scala211 = "2.11.12"
lazy val scala210 = "2.10.7"
lazy val supportedScalaVersions = List(scala213, scala212, scala211, scala210)

ThisBuild / scalaVersion := scala213

ThisBuild / organization := "com.hypertino"

lazy val library = crossProject(JSPlatform, JVMPlatform)
  .crossType(CrossType.Full) // [Pure, Full, Dummy], default: CrossType.Full
  .settings(
    crossScalaVersions := supportedScalaVersions,
    name := "inflector",
    version := "1.0-SNAPSHOT",
    libraryDependencies += "org.scalatest" %%% "scalatest" % "3.1.0" % "test",
    publishArtifact := true,
    publishArtifact in Test := false
).settings(publishSettings:_*)
.jsSettings(
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
  pgpSecretRing := file("./travis/script/ht-oss-private.asc"),
  pgpPublicRing := file("./travis/script/ht-oss-public.asc"),
  usePgpKeyHex("F8CDEF49B0EDEDCC"),
  useGpg := false,
  pgpPassphrase := Option(System.getenv().get("oss_gpg_passphrase")).map(_.toCharArray),
  publishMavenStyle := true,
  pomIncludeRepository := { _ => false},
  publishTo := {
    val nexus = "https://oss.sonatype.org/"
    if (isSnapshot.value)
      Some("snapshots" at nexus + "content/repositories/snapshots")
    else
      Some("releases" at nexus + "service/local/staging/deploy/maven2")
  },
  credentials ++= (for {
    username <- Option(System.getenv().get("sonatype_username"))
    password <- Option(System.getenv().get("sonatype_password"))
  } yield Credentials("Sonatype Nexus Repository Manager", "oss.sonatype.org", username, password)).toSeq  
)

lazy val `inflector-root` = project
  .in(file("."))
  .settings(publishSettings:_*)
  .aggregate(js, jvm)
  .settings(
    crossScalaVersions := Nil,
    publish / skip := true
  )
