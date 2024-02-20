package com.nfcunha.sandbox.event;

import java.time.Instant;
import java.util.UUID;

public class UserCreatedEvent {

    private final UUID uuid;
    private final String user;
    private final String creationUser;
    private final Instant timestamp;

    public UserCreatedEvent(UUID uuid, String user, String creationUser, Instant timestamp) {
        this.uuid = uuid;
        this.user = user;
        this.creationUser = creationUser;
        this.timestamp = timestamp;
    }

    public static UserCreatedEvent of(String user, String creationUser, Instant timestamp) {
        return new UserCreatedEvent(UUID.randomUUID(), user, creationUser, timestamp);
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getUser() {
        return user;
    }

    public String getCreationUser() {
        return creationUser;
    }

    public Instant getTimestamp() {
        return timestamp;
    }
}
