import backtype.storm.topology.{IRichSpout, TopologyBuilder}
import storm.kafka._
import _root_.bolt.ReverseStringBolt
import backtype.storm.{Config, LocalCluster, StormSubmitter}
import _root_.bolt.CouchBaseBolt
import config.KafkaConfiguration

/**
  * Created by Rewati Raman (rewati.raman@hart.com).
  */
object KafkaCouchTopology extends App with KafkaConfiguration{
  val builder: TopologyBuilder = new TopologyBuilder()
  val kafkaSpout: IRichSpout = new KafkaSpout(kafkaConfig)
  builder.setSpout("word", kafkaSpout, 1)
  builder.setBolt("reverse", new ReverseStringBolt, 2).shuffleGrouping("word")
  builder.setBolt("couchBase", new CouchBaseBolt, 3).shuffleGrouping("reverse")

  val config = new Config()
  config.setDebug(true)
  if (args != null && args.length > 0) {
    config.setNumWorkers(3)
    StormSubmitter.submitTopology(args(0), config, builder.createTopology())
  } else {
    val cluster: LocalCluster = new LocalCluster
    cluster.submitTopology("KafkaStormPoc1", config, builder.createTopology())
    Thread.sleep(200000)
    cluster.killTopology("KafkaStormPoc1")
    cluster.shutdown()
  }
}
