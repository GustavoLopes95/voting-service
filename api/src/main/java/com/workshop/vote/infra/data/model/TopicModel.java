package com.workshop.vote.infra.data.model;

import com.workshop.vote.domain.base.BaseDomainEntity;
import com.workshop.vote.domain.enums.TopicStatusEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@NoArgsConstructor
@Entity( name = "topic")
public class TopicModel extends BaseDomainEntity {
    //Protected Properties
    protected String name;

    //Private Properties
    private TopicStatusEnum status;

    public TopicModel(String name, TopicStatusEnum status) {
        this.name = name;
        this.status = status;
    }

    public TopicModel(String name, TopicStatusEnum status, String createdBy, String lastSourcePlatform) {
        this(name, status);
        this.createNewRegister(createdBy, lastSourcePlatform);
    }
}
