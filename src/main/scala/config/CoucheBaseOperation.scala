package config

import java.net.URI
import java.util
import java.util.UUID

import com.couchbase.client.CouchbaseClient

/**
  * Created by Rewati Raman (rewati.raman@gmail.com).
  */
object CoucheBaseOperation {

  val uris = new util.ArrayList[URI]()
  uris.add(URI.create("http://127.0.0.1:8091/pools"))
  protected var client: CouchbaseClient = null
  try {
    client = new CouchbaseClient(uris, "stormScala", "")
  }
  val couchClient = client
  def saveMessage(msg: String): Unit = {
    couchClient.set(UUID.randomUUID().toString,500, msg)
  }
}
