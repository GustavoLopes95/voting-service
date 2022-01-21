package com.workshop.vote.domain.entities;

import com.workshop.vote.domain.base.BaseDomainEntity;
import com.workshop.vote.domain.enums.TopicStatusEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.MappedSuperclass;
import java.time.Instant;

@Getter
@MappedSuperclass
@NoArgsConstructor
public abstract class BaseTopic extends BaseDomainEntity {

    //Protected Properties
    protected String name;

    //Private Properties
    private TopicStatusEnum status;

    //Protected Constructor
    protected BaseTopic(TopicStatusEnum status) {
        this.status = status;
    }

    //Private Methods
    private void setName(String name) {
        this.name = name;
    }

    //Protected Methods
    protected void generateNewTopic(
            String name,
            String createdBy,
            String lastSourcePlatform
    ) {

        this.createNewRegister(
                createdBy,
                lastSourcePlatform
        );

        this.setName(name);
    }

    protected void setTopicInfo(
            Long id,
            String name,
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

        this.setName(name);
    }
}
