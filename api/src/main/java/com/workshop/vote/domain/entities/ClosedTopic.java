package com.workshop.vote.domain.entities;

import com.workshop.vote.domain.enums.TopicStatusEnum;
import lombok.Getter;

import java.time.Instant;
import java.time.LocalDateTime;

@Getter
public class ClosedTopic extends BaseTopic {

    //Private properties
    private Instant closedTime;

    private Integer votes;

    //Public Constructor
    public ClosedTopic() {
        super(TopicStatusEnum.CLOSED);
    }

    //Private methods
    private void setClosedTopicInfo(Integer votes, Instant closedTime) {
        this.votes = votes;
        this.closedTime = closedTime;
    }

    //Public methods
    public void setTopicInfo(
            Long id,
            String name,
            Integer votes,
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

        this.setClosedTopicInfo(votes, closedTime);
    }
}
