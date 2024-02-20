package com.nfcunha.sandbox;

import com.eventstore.dbclient.EventStoreDBClient;
import com.eventstore.dbclient.EventStoreDBClientSettings;
import com.eventstore.dbclient.EventStoreDBPersistentSubscriptionsClient;

public class EventStoreDbConnectionProvider {

    public EventStoreDBClient getEventStoreDbClient() {
        final EventStoreDBClientSettings settings = EventStoreDBClientSettings.builder()
                .addHost("localhost", 2113)
                .tls(false)
                .buildConnectionSettings();
        return EventStoreDBClient.create(settings);
    }

    public EventStoreDBPersistentSubscriptionsClient getPersistentSubscriptionsClient() {
        final EventStoreDBClientSettings settings = EventStoreDBClientSettings.builder()
                .addHost("localhost", 2113)
                .tls(false)
                .buildConnectionSettings();
        return EventStoreDBPersistentSubscriptionsClient.create(settings);
    }

}
