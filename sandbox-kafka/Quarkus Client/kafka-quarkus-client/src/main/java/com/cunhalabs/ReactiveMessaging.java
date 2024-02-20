package com.cunhalabs;

import org.eclipse.microprofile.reactive.messaging.*;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.concurrent.CompletionStage;

@ApplicationScoped
public class ReactiveMessaging {

    @Incoming("quarkus-topic")
    public CompletionStage<Void> receiveMessage(Message<String> message) {
        System.out.println(message.toString());
        return message.ack();
    }

}
