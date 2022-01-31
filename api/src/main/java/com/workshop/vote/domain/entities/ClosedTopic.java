package com.workshop.vote.domain.entities;

import com.workshop.vote.domain.enums.TopicStatusEnum;

import java.time.Instant;
import java.time.LocalDateTime;

public class ClosedTopic extends BaseTopic {

    //Private properties
    private Instant closedTime;

    //Public Constructor
    public ClosedTopic() {
        super(TopicStatusEnum.CLOSED);
    }

    //Private methods
    private void setClosedTime(Instant closedTime) {
        this.closedTime = closedTime;
    }

    //Public methods
    public void setTopicInfo(
            Long id,
            String name,
            LocalDateTime expirationTime,
            Instant closedTime,
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

        this.setClosedTime(closedTime);
    }
}
