package com.workshop.vote.domain.entities;

import com.workshop.vote.domain.enums.TopicStatusEnum;
import lombok.Getter;

import java.time.Instant;

@Getter
public class OpenedTopic extends BaseTopic {

    //Public Constructor
    public OpenedTopic() {
        super(TopicStatusEnum.OPENED);
    }

    //Public Methods
    public ClosedTopic close() {
        var topic = new ClosedTopic();
        topic.setTopicInfo(
                this.getId(),
                this.name,
                this.secondDuration,
                Instant.now(), //closedTime
                this.getAuditableInfo().getCreatedBy(),
                this.getAuditableInfo().getCreatedAt(),
                this.getAuditableInfo().getUpdatedBy(),
                this.getAuditableInfo().getUpdatedAt(),
                this.getAuditableInfo().getLastSourcePlatform(),
                this.getVersion().getRegisterVersion()
        );
        return topic;
    }

    public void setInfoRegister(
            Long id,
            String name,
            Double secondDuration,
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
                secondDuration,
                createdBy,
                createdAt,
                updatedBy,
                updatedAt,
                lastSourcePlatform,
                registerVersion
        );
    }
}
