package com.workshop.vote.domain.entities;

import com.workshop.vote.domain.enums.TopicStatusEnum;

import java.time.ZonedDateTime;

public class NewTopic extends BaseTopic {

    //Public Constructor
    public NewTopic() {
        super(TopicStatusEnum.NEW);
    }

    //Public Methods
    public void setNewInfoRegister(
            String name,
            Long expirationTime,
            String createdBy,
            String lastSourcePlatform
    ) {
        this.generateNewTopic(
            name,
            expirationTime,
            createdBy,
            lastSourcePlatform
        );
    }

}
