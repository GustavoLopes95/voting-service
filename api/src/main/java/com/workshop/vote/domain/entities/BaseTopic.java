package com.workshop.vote.domain.entities;

import com.workshop.vote.domain.base.BaseDomainEntity;
import com.workshop.vote.domain.enums.TopicStatusEnum;
import com.workshop.vote.infra.crossCutting.data.interfaces.IAggregateRoot;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.MappedSuperclass;
import java.time.Instant;
import java.util.Objects;

@Getter
@MappedSuperclass
@NoArgsConstructor
public abstract class BaseTopic extends BaseDomainEntity implements IAggregateRoot {

    //Protected Properties
    protected String name;

    protected Double secondDuration;

    //Private Properties
    private TopicStatusEnum status;

    //Protected Constructor
    protected BaseTopic(TopicStatusEnum status) {
        this.status = status;
    }

    //Private Methods
    private void setTopicInfo(String name, Double secondDuration) {
        this.name = name;
        this.secondDuration = secondDuration;
    }

    //Protected Methods
    protected void generateNewTopic(
            String name,
            Double secondDuration,
            String createdBy,
            String lastSourcePlatform
    ) {

        this.createNewRegister(
                createdBy,
                lastSourcePlatform
        );

        this.setTopicInfo(name, secondDuration);
    }

    protected void setExistsTopicInfo(
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

        this.setRegisterInfo(
                id,
                createdBy,
                createdAt,
                updatedBy,
                updatedAt,
                lastSourcePlatform,
                registerVersion
        );

        this.setTopicInfo(name, secondDuration);
    }

    public String getHash() {
        return ""+this.getId()+":"+status;
    }
}