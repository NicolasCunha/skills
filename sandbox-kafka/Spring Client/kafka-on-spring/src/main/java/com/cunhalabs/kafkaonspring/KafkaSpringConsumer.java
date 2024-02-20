package com.cunhalabs.kafkaonspring;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaSpringConsumer {

    @KafkaListener(topics = "spring-topic", groupId = "spring-group")
    public void listenToSpringTopic(final ConsumerRecord<String, String> message) {
        System.out.println("Received Message from Kafka: " + message.toString());
    }

}
