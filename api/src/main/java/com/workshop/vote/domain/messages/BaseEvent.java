package com.workshop.vote.domain.messages;

import lombok.Getter;

import java.time.Instant;
import java.util.UUID;

@Getter
public abstract class BaseEvent extends BaseMessage {
    private Instant timeStamp;

    public BaseEvent(String sourcePlatform) {
        super(sourcePlatform);
        this.timeStamp = Instant.now();
    }

    public BaseEvent(Instant timeStamp, String messageType, UUID messageId, String sourcePlatform) {
        super(messageId, messageType, sourcePlatform);
        this.timeStamp = timeStamp;
    }
}
