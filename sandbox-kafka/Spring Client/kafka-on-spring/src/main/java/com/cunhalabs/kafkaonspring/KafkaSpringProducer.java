package com.cunhalabs.kafkaonspring;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class KafkaSpringProducer {

    private static final String TOPIC = "spring-topic";
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public KafkaSpringProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping(value = "/api/springProduce",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public void produceSomething(@RequestBody final Map<String, Object> body) {
        final String json = new Gson().toJson(body);
        this.kafkaTemplate.send(TOPIC, json);
    }

}
