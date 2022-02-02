package com.workshop.vote.infra.data.mapper;

import com.workshop.vote.domain.entities.OpenedTopic;
import com.workshop.vote.domain.factories.OpenedTopicFactory;
import com.workshop.vote.infra.data.model.TopicRedisModel;
import org.javatuples.Ennead;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class TopicRedisMapper {

    private OpenedTopicFactory openedTopicFactory;

    @Autowired
    public TopicRedisMapper(OpenedTopicFactory openedTopicFactory) {
        this.openedTopicFactory = openedTopicFactory;
    }

    public TopicRedisModel toRepository(OpenedTopic topic) {
        return new TopicRedisModel(topic.getId(), topic.getName(), topic.getStatus(), topic.getExpirationTime());
    }

    public OpenedTopic toDomain(TopicRedisModel model) {
        return this.openedTopicFactory.create(
                Ennead.with(
                        model.getId(),
                        model.getName(),
                        model.getExpirationTime(),
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
