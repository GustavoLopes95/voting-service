package com.workshop.vote.domain.entities;

import com.workshop.vote.domain.enums.TopicStatusEnum;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class ClosedTopic extends BaseTopic {

    //Public Constructor
    public ClosedTopic() {
        super(TopicStatusEnum.CLOSED);
    }

    //Public methods
    public void setTopicInfo(
            Long id,
            String name,
            LocalDateTime expirationTime,
            String createdBy,
            Instant createdAt,
            String updatedBy,
            Instant updatedAt,
            String lastSourcePlatform,
            Integer registerVersion
    ) {
        this.setExistsTopicInfo(
                id,
                name,
                expirationTime,
                createdBy,
                createdAt,
                updatedBy,
                updatedAt,
                lastSourcePlatform,
                registerVersion
        );
    }
}
