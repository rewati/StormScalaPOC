package bolt

import backtype.storm.tuple.{Tuple, Values}

/**
  * Created by Rewati Raman (rewati.raman@gmail.com).
  */
class ReverseStringBolt extends BaseBolt{

  override def execute(tuple: Tuple) {
    val str=new Values(tuple.getString(0).reverse)
    collector.emit(str)
    collector.ack(tuple)
  }

}
