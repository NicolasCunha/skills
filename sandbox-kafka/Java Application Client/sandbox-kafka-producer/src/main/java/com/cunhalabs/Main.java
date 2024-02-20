package com.cunhalabs;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import com.google.gson.Gson;

public class Main {

    private static final String KAFKA_SERVER = "127.0.0.1:9092";
    private static final String TOPIC = "java-app-client-topic";

    public static void main(String[] args) {
        new Main().runProducer();
    }

    private void runProducer() {
        KafkaProducer<String, String> kafkaProducer = createProducer();
        getJsonList().forEach(msg -> {
            ProducerRecord<String, String> producerRecord = new ProducerRecord<>(TOPIC, msg);
            kafkaProducer.send(producerRecord);
        });
        kafkaProducer.flush();
        kafkaProducer.close();
    }

    private List<String> getJsonList() {
        final List<String> list = new LinkedList<>();
        for (int i = 0; i < 1000; i++) {
            final Map<String, Object> jsonMap = new LinkedHashMap<>();
            jsonMap.put("description", "Message No " + i);
            jsonMap.put("id", new Random().nextInt());
            jsonMap.put("value", new Random().nextDouble());
            jsonMap.put("timestamp", Instant.now().toString());
            final Gson gson = new Gson();
            list.add(gson.toJson(jsonMap));
        }
        return list;
    }

    private KafkaProducer<String, String> createProducer() {
        Properties producerProperties = new Properties();
        producerProperties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, KAFKA_SERVER);
        producerProperties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        producerProperties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        return new KafkaProducer<>(producerProperties);
    }

}