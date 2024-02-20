package com.nfcunha.sandbox;

import com.eventstore.dbclient.EventStoreDBClient;
import com.eventstore.dbclient.ReadResult;
import com.eventstore.dbclient.ReadStreamOptions;
import com.eventstore.dbclient.ResolvedEvent;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.concurrent.ExecutionException;

public class ReadEventsFromStream {

    public void run() throws ExecutionException, JsonProcessingException, InterruptedException {
        // First, create some events
        //new CreateEventOnStream().run();
        // Then, read it
        final EventStoreDbConnectionProvider connectionProvider = new EventStoreDbConnectionProvider();
        final EventStoreDBClient client = connectionProvider.getEventStoreDbClient();
        final ReadStreamOptions readStreamOptions = ReadStreamOptions.get().fromStart();
        final ReadResult readResult = client.readStream("$ce-users", readStreamOptions).get();
        for (ResolvedEvent resolvedEvent : readResult.getEvents()) {
            final String eventStream = getStreamFromEventData(resolvedEvent.getEvent().getEventData());
            System.out.println("Found stream: " + eventStream);
            final ReadResult streamResult = client.readStream(eventStream, readStreamOptions).get();
            for (ResolvedEvent streamEvent : streamResult.getEvents()) {
                System.out.println("Found event: " + streamEvent.getEvent().toString());
            }
        }
    }

    private String getStreamFromEventData(final byte[] data) {
        final String parsedString = new String(data);
        return parsedString.split("@")[1];
    }

}
