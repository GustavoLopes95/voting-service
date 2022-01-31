package com.workshop.vote.domain.entities;

import com.workshop.vote.domain.base.BaseDomainEntity;
import com.workshop.vote.domain.enums.TopicStatusEnum;
import com.workshop.vote.infra.crossCutting.data.interfaces.IAggregateRoot;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.MappedSuperclass;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Getter
@MappedSuperclass
@NoArgsConstructor
public abstract class BaseTopic extends BaseDomainEntity implements IAggregateRoot {

    //Protected Properties
    protected String name;

    protected LocalDateTime expirationTime;

    //Private Properties
    private TopicStatusEnum status;

    //Protected Constructor
    protected BaseTopic(TopicStatusEnum status) {
        this.status = status;
    }

    //Private Methods
    private void setExpirationTime(Long expirationTime) {
        var instant = LocalDateTime.now(ZoneOffset.UTC);
        this.expirationTime = instant.plusSeconds(expirationTime);
    }

    private void setExpirationTime(LocalDateTime expirationTime) {
        this.expirationTime = expirationTime;
    }

    private void setTopicInfo(String name, Long expirationTime) {
        this.name = name;
        this.setExpirationTime(expirationTime);
    }

    private void setTopicInfo(String name, LocalDateTime expirationTime) {
        this.name = name;
        this.setExpirationTime(expirationTime);
    }

    //Protected Methods
    protected void generateNewTopic(
            String name,
            Long expirationTime,
            String createdBy,
            String lastSourcePlatform
    ) {

        this.createNewRegister(
                createdBy,
                lastSourcePlatform
        );

        this.setTopicInfo(name, expirationTime);
    }

    protected void setExistsTopicInfo(
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

        this.setRegisterInfo(
                id,
                createdBy,
                createdAt,
                updatedBy,
                updatedAt,
                lastSourcePlatform,
                registerVersion
        );

        this.setTopicInfo(name, expirationTime);
    }

    public String getHash() {
        return ""+this.getId()+":"+status;
    }
}