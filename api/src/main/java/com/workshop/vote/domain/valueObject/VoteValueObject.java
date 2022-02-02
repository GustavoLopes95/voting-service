package com.workshop.vote.domain.valueObject;

import com.workshop.vote.domain.base.BaseDomainEntity;
import com.workshop.vote.domain.entities.OpenedTopic;
import com.workshop.vote.infra.data.model.TopicModel;
import lombok.Getter;

import java.time.Instant;

@Getter
public class VoteValueObject extends BaseDomainEntity {

    private OpenedTopic topic;

    private Instant votedAt;

    public VoteValueObject(String createdBy, String lastSourcePlatform) {
        this.votedAt = Instant.now();
        this.createNewRegister(createdBy, lastSourcePlatform);
    }

    public VoteValueObject(
            Long id,
            OpenedTopic topic,
            Instant votedAt,
            String createdBy,
            Instant createdAt,
            String updatedBy,
            Instant updatedAt,
            String lastSourcePlatform,
            Integer registerVersion
    ) {
        this.votedAt = votedAt;
        this.attachTopic(topic);
        this.setRegisterInfo(id, createdBy, createdAt, updatedBy, updatedAt, lastSourcePlatform, registerVersion);
    }

    public void attachTopic(OpenedTopic topic) {
        this.topic = topic;
    }
}
