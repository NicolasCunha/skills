package org.cunhalabs;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class Main {

    private static final String KAFKA_SERVER = "127.0.0.1:9092";
    private static final String GROUP_ID = "java-application-client-group";
    private static final String TOPIC = "java-app-client-topic";
    private static final String EARLIEST = "earliest";

    public static void main(String[] args) {
        new Main().runConsumer();
    }

    private void runConsumer() {
        final KafkaConsumer<String, String> kafkaConsumer = createConsumer();
        kafkaConsumer.subscribe(Collections.singletonList(TOPIC));
        while (true) {
            final ConsumerRecords<String, String> records = kafkaConsumer.poll(Duration.ofSeconds(10));
            for (final ConsumerRecord<String, String> record : records) {
                System.out.println(record.toString());
            }
        }
    }

    private KafkaConsumer<String, String> createConsumer() {
        Properties producerProperties = new Properties();
        producerProperties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KAFKA_SERVER);
        producerProperties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        producerProperties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        producerProperties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, GROUP_ID);
        producerProperties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, EARLIEST);
        return new KafkaConsumer<>(producerProperties);
    }
}