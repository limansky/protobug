import scalapb.compiler.Version.scalapbVersion

// ThisBuild / useCoursier := false

lazy val protobug = (project in file("."))
  .settings(
    organization := "me.limansky",
    name := "protobug",
    version := "0.1",
    libraryDependencies ++= Seq(
      "com.thesamet.scalapb"   %% "scalapb-runtime"      % scalapbVersion exclude("com.google.protobuf", "protobuf-java"),
      "com.google.protobuf"    %  "protobuf-java"        % "2.6.1" force()
    ),
    PB.protocVersion := "-v261",
    Compile / PB.targets := Seq(
      scalapb.gen(grpc = false) -> (Compile / sourceManaged).value
    )
  )
