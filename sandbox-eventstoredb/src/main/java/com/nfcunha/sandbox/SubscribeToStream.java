package com.nfcunha.sandbox;

import com.eventstore.dbclient.EventStoreDBPersistentSubscriptionsClient;
import com.eventstore.dbclient.PersistentSubscription;
import com.eventstore.dbclient.PersistentSubscriptionListener;
import com.eventstore.dbclient.PersistentSubscriptionToStreamInfo;
import com.eventstore.dbclient.ResolvedEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class SubscribeToStream {

    public void run() throws ExecutionException, JsonProcessingException, InterruptedException {
        // "Regular" Subscriptions catches up on the stream, so they read all events.
        // Persistent Subscriptions stays created on the server, so they only read newer events.
        final PersistentSubscriptionListener persistentSubscription = new PersistentSubscriptionListener() {
            @Override
            public void onEvent(PersistentSubscription subscription, int retryCount, ResolvedEvent event) {
                super.onEvent(subscription, retryCount, event);
                System.out.println("Reading event " + event.getEvent().getStreamId());
            }
        };
        final EventStoreDbConnectionProvider connectionProvider = new EventStoreDbConnectionProvider();
        final EventStoreDBPersistentSubscriptionsClient client = connectionProvider.getPersistentSubscriptionsClient();
        createSubscriberGroup(client);
        client.subscribeToStream("users", "users-group", persistentSubscription).get();
    }

    private void createSubscriberGroup(final EventStoreDBPersistentSubscriptionsClient client) throws ExecutionException, InterruptedException {
        if (!subscriberGroupExists(client, "users", "users-group")) {
            client.createToStream("users", "users-group").get();
        }
    }

    private boolean subscriberGroupExists(final EventStoreDBPersistentSubscriptionsClient client,
                                       final String stream,
                                       final String group) throws ExecutionException, InterruptedException {
        // EventStore Client does not contain a utility method to check if a subscription exists on the server, so we do a manual check
        // or catch an exception.
        // however catching the exception requires the dependency with gRPC (io.grpc.StatusResultException),
        // which for some reason is not available on the client SDK
        final List<PersistentSubscriptionToStreamInfo> subscriptionInfoList = client.listToStream(stream).get();
        for (PersistentSubscriptionToStreamInfo subscription : subscriptionInfoList) {
            if (subscription.getGroupName().equals(group)) {
                System.out.println("Group already exists");
                return true;
            }
        }
        return false;
    }

}
