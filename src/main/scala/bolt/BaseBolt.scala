package bolt


import java.util.{Map => JMap}

import backtype.storm.task.{OutputCollector, TopologyContext}
import backtype.storm.topology.OutputFieldsDeclarer
import backtype.storm.topology.base.BaseRichBolt
import backtype.storm.tuple.Fields

/**
  * Created by Rewati Raman (rewati.raman@hart.com).
  */
trait BaseBolt extends BaseRichBolt {

  var collector: OutputCollector = _

  override def prepare(config: JMap[_, _], context: TopologyContext, collector1: OutputCollector) {
    collector = collector1
  }

  override def declareOutputFields(declarer: OutputFieldsDeclarer) {
    declarer.declare(new Fields("word"))
  }
}
