import org.apache.commons.csv.CSVFormat
import java.io.FileReader

import io.circe.{Encoder, Json}
import io.circe.syntax._
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}
import org.apache.kafka.common.serialization.StringSerializer
import java.util.Properties
import loader.Bestsellers

object producer{

  val connectionProperties = new Properties()

  connectionProperties.put("bootstrap.servers", "localhost:9092")

  val kafkaProducer = new KafkaProducer(connectionProperties, new StringSerializer, new StringSerializer)

  def kafka_producer(book: Seq[Bestsellers], topicName: String): Unit = {

    book.foreach {
      obj => val message = obj.asJson.toString

      kafkaProducer.send(new ProducerRecord(topicName, message, message))

    }
    kafkaProducer.close()
  }


}
