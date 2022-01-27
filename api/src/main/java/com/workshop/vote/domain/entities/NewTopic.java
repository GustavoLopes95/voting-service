package com.workshop.vote.domain.entities;

import com.workshop.vote.domain.enums.TopicStatusEnum;

public class NewTopic extends BaseTopic {

    //Public Constructor
    public NewTopic() {
        super(TopicStatusEnum.NEW);
    }

    //Public Methods
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
