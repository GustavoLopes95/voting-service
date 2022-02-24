package com.workshop.vote.domain.messages;

import lombok.Getter;

import java.time.Instant;
import java.util.UUID;

@Getter
public abstract class BaseIntegrationEvent extends BaseEvent {
    private UUID correlationalId;

    public BaseIntegrationEvent(String sourcePlatform) {
        super(sourcePlatform);
        this.correlationalId = UUID.randomUUID();
    }

    public BaseIntegrationEvent(Instant timeStamp, String messageType, UUID messageId, String sourcePlatform, UUID correlationalId) {
        super(timeStamp, messageType, messageId, sourcePlatform);
        this.correlationalId = correlationalId;
    }
}
