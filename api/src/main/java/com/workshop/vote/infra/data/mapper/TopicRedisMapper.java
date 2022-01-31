package com.workshop.vote.infra.data.mapper;

import com.workshop.vote.domain.entities.OpenedTopic;
import com.workshop.vote.domain.factories.OpenedTopicFactory;
import com.workshop.vote.infra.data.model.TopicRedisModel;
import org.javatuples.Ennead;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Instant;

public class TopicRedisMapper {

    private OpenedTopicFactory openedTopicFactory;

    @Autowired
    public TopicRedisMapper(OpenedTopicFactory openedTopicFactory) {
        this.openedTopicFactory = openedTopicFactory;
    }

    public TopicRedisModel toRepository(OpenedTopic topic) {
        return new TopicRedisModel(topic.getId(), topic.getName(), topic.getStatus());
    }

    public OpenedTopic toDomain(TopicRedisModel model) {
        return this.openedTopicFactory.create(
                Ennead.with(
                        model.getId(),
                        model.getName(),
                        60.0,
                        "username",
                        Instant.now(),
                        "usernameTwo",
                        Instant.now(),
                        "api-vote",
                        1
                )
        );
    }
}
