package com.workshop.vote.domain.entities;

import com.workshop.vote.domain.enums.TopicStatusEnum;

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
            Double secondDuration,
            String createdBy,
            String lastSourcePlatform
    ) {
        this.generateNewTopic(
                name,
                secondDuration,
                createdBy,
                lastSourcePlatform
        );
    }

}
