package com.workshop.vote.domain.entities;

import com.workshop.vote.domain.enums.TopicStatusEnum;
import com.workshop.vote.domain.valueObject.VoteValueObject;
import lombok.Getter;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Getter
public class OpenedTopic extends BaseTopic {

    private List<VoteValueObject> votes;

    //Public Constructor
    public OpenedTopic() {
        super(TopicStatusEnum.OPENED);
        votes = new ArrayList<>();
    }

    //Public Methods
    public ClosedTopic close(Integer votes) {
        var topic = new ClosedTopic();
        topic.setTopicInfo(
                this.getId(),
                this.name,
                votes,
                this.expirationTime,
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

    public void addVote(VoteValueObject voteVO) {
        this.votes.add(voteVO);
    }

    public Collection<VoteValueObject> getVotes() {
        return Collections.unmodifiableCollection(this.votes);
    }

    public Boolean isExpired() {
        return this.getExpirationTime().isBefore(LocalDateTime.now(ZoneOffset.UTC));
    }

    public void setInfoRegister(
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
