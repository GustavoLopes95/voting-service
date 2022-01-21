package com.workshop.vote.domain.entities;

import com.workshop.vote.domain.enums.TopicStatusEnum;

import java.time.Instant;

public class ClosedTopic extends BaseTopic {

    public ClosedTopic() {
        super(TopicStatusEnum.CLOSED);
    }

    public void setTopicInfo(
            Long id,
            String name,
            String createdBy,
            Instant createdAt,
            String updatedBy,
            Instant updatedAt,
            String lastSourcePlatform,
            Integer registerVersion
    ) {
        this.setTopicInfo(
                id,
                name,
                createdBy,
                createdAt,
                updatedBy,
                updatedAt,
                lastSourcePlatform,
                registerVersion
        );
    }
}
