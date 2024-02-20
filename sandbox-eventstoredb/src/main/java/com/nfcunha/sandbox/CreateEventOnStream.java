package com.nfcunha.sandbox;

import com.eventstore.dbclient.EventData;
import com.eventstore.dbclient.EventStoreDBClient;
import com.eventstore.dbclient.WriteResult;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nfcunha.sandbox.event.UserCreatedEvent;
import java.time.Instant;
import java.util.concurrent.ExecutionException;

public class CreateEventOnStream {

    public void run() throws JsonProcessingException, ExecutionException, InterruptedException {
        final EventStoreDbConnectionProvider connectionProvider = new EventStoreDbConnectionProvider();
        final EventStoreDBClient client = connectionProvider.getEventStoreDbClient();
        final UserCreatedEvent userCreatedEvent = UserCreatedEvent.of("nicolasfcunha",
                "system_admin",
                Instant.now());
        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        final String json = objectMapper.writeValueAsString(userCreatedEvent);
        final EventData eventData = EventData.builderAsBinary("UserCreated", json.getBytes()).build();
        final WriteResult writeResult = client.appendToStream("users-" + userCreatedEvent.getUuid(), eventData).get();
        System.out.println(writeResult.toString());
    }

}
