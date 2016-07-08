name := "StromPilot"

version := "1.0"

scalaVersion := "2.11.8"

val stormVersion = "0.10.0"
val couchbaseVersion = "1.1-dp"

resolvers += "Couchbase Maven Repository" at "http://files.couchbase.com/maven2"

libraryDependencies ++= Seq(
  "org.apache.storm" % "storm-core" % stormVersion
    exclude("org.apache.zookeeper", "zookeeper")
    exclude("org.slf4j", "log4j-over-slf4j"),
  "org.apache.storm" % "storm-kafka" % stormVersion
    exclude("org.apache.zookeeper", "zookeeper"),
  "ch.qos.logback" % "logback-classic" % "1.1.2",
  "org.scalatest" %% "scalatest" % "2.2.4" % "test",
  "org.apache.kafka" % "kafka_2.11" % "0.8.2.2"
    exclude("org.slf4j", "slf4j-log4j12")
    exclude("javax.jms", "jms")
    exclude("com.sun.jdmk", "jmxtools")
    exclude("com.sun.jmx", "jmxri")
    exclude("com.101tec", "zkclient"),
  "ch.qos.logback" % "logback-classic" % "1.1.2",
  "com.101tec" % "zkclient" % "0.7"
    exclude("org.apache.zookeeper", "zookeeper")
    exclude("org.slf4j", "slf4j-log4j12"),
  "couchbase" % "couchbase-client" % couchbaseVersion
)
    