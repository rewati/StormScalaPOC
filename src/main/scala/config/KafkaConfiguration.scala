package config

import java.util

import backtype.storm.spout.SchemeAsMultiScheme
import storm.kafka.{BrokerHosts, SpoutConfig, StringScheme, ZkHosts}

/**
  * Created by Rewati Raman (rewati.raman@hart.com).
  */
trait KafkaConfiguration {
  protected val hosts: BrokerHosts  = new ZkHosts("localhost:2181","/brokers")
  val kafkaConfig = new SpoutConfig(hosts, "scalastrom", "/scalastrom", "scalastrom")
  kafkaConfig.zkServers = new util.ArrayList[String]()
  kafkaConfig.zkServers.add("localhost")
  kafkaConfig.zkPort = 2181
  kafkaConfig.zkRoot = "/scalastrom"
  kafkaConfig.scheme =new SchemeAsMultiScheme(new StringScheme)
}
