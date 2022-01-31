package com.workshop.vote.domain.entities;

import com.workshop.vote.domain.enums.TopicStatusEnum;

import java.time.ZonedDateTime;

public class NewTopic extends BaseTopic {

    //Public Constructor
    public NewTopic() {
        super(TopicStatusEnum.NEW);
    }

    //Public Methods
    public OpenedTopic open() {
        var openedTopic = new OpenedTopic();
        openedTopic.setInfoRegister(
                null,
                this.name,
                this.secondDuration,
                this.getAuditableInfo().getCreatedBy(),
                this.getAuditableInfo().getCreatedAt(),
                this.getAuditableInfo().getUpdatedBy(),
                this.getAuditableInfo().getUpdatedAt(),
                this.getAuditableInfo().getLastSourcePlatform(),
                this.getVersion().getRegisterVersion()
        );
        return openedTopic;
    }


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
