package bolt

import backtype.storm.tuple.Tuple
import config.CoucheBaseOperation

/**
  * Created by Rewati Raman (rewati.raman@gmail.com).
  */
class CouchBaseBolt extends BaseBolt  {

  override def execute(tuple: Tuple): Unit = {
    val requestJson ="""{"string": """"+tuple.getString(0)+""" "} """.stripMargin
    CoucheBaseOperation.saveMessage(requestJson)
  }

}
