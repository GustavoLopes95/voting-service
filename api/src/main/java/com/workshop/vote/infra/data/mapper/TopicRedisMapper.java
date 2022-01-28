package com.workshop.vote.infra.data.mapper;

import com.workshop.vote.domain.entities.OpenedTopic;
import com.workshop.vote.infra.data.model.TopicRedisModel;

public class TopicRedisMapper {

    public static TopicRedisModel toRepository(OpenedTopic topic) {
        return new TopicRedisModel(topic.getId(), topic.getName(), topic.getStatus());
    }
}
