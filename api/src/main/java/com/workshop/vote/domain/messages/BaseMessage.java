package com.workshop.vote.domain.messages;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Getter
public abstract class BaseMessage {
    private UUID messageId;
    private String messageType;
    private String sourcePlatform;

    public BaseMessage(String sourcePlatform) {
        this.messageId = UUID.randomUUID();
        this.messageType = this.getClass().getTypeName();
        this.sourcePlatform = sourcePlatform;
    }

    public BaseMessage(UUID messageId, String messageType, String sourcePlatform) {
        this.messageId = messageId;
        this.messageType = messageType;
        this.sourcePlatform = sourcePlatform;
    }
}
