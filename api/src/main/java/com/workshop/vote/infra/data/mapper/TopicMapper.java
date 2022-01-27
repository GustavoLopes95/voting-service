package com.workshop.vote.infra.data.mapper;

import com.workshop.vote.domain.entities.BaseTopic;
import com.workshop.vote.infra.data.model.TopicModel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;


public class TopicMapper {

    public static TopicModel toRepository(BaseTopic topic) {
        return new TopicModel(topic.getName(), topic.getStatus(), topic.getAuditableInfo().getCreatedBy(), topic.getAuditableInfo().getLastSourcePlatform());
    }
}
