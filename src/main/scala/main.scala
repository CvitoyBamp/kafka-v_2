import loader.result
import producer.kafka_producer
import consumer.kafka_consumer

object main extends App{

  val topicName = "books"

  kafka_producer(result, topicName)

  kafka_consumer(topicName)

}
