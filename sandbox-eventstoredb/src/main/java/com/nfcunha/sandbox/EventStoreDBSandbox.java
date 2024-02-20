package com.nfcunha.sandbox;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.concurrent.ExecutionException;

public class EventStoreDBSandbox {

    public static void main(String[] args) throws JsonProcessingException, ExecutionException, InterruptedException {
        //new CreateEventOnStream().run();
        new ReadEventsFromStream().run();
        //new SubscribeToStream().run();
    }

}
