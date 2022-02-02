package com.workshop.vote.infra.data.model;

import com.workshop.vote.domain.base.BaseDomainEntity;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.Instant;

@NoArgsConstructor
@Entity(name = "vote")
public class VoteModel extends BaseDomainEntity {

    @ManyToOne
    @JoinColumn(name = "topic_id")
    private TopicModel topic;

    private Instant votedAt;

    public VoteModel(Instant votedAt) {
        this.votedAt = votedAt;
    }

    public VoteModel(TopicModel topic, Instant votedAt, String createdBy, String lastSourcePlatform) {
        this(votedAt);
        this.attachTopic(topic);
        this.createNewRegister(createdBy, lastSourcePlatform);
    }

    public VoteModel(
            Long id,
            TopicModel topic,
            Instant votedAt,
            String createdBy,
            Instant createdAt,
            String updatedBy,
            Instant updatedAt,
            String lastSourcePlatform,
            Integer registerVersion
    ) {
        this(votedAt);
        this.attachTopic(topic);
        this.setRegisterInfo(id, createdBy, createdAt, updatedBy, updatedAt, lastSourcePlatform, registerVersion);
    }

    public void attachTopic(TopicModel topic) {
        this.topic = topic;
    }
}
