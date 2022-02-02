package com.workshop.vote.infra.data.mapper;

import com.workshop.vote.domain.entities.BaseTopic;
import com.workshop.vote.domain.entities.ClosedTopic;
import com.workshop.vote.domain.entities.OpenedTopic;
import com.workshop.vote.domain.enums.TopicStatusEnum;
import com.workshop.vote.infra.data.model.TopicModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;


@Component
public class TopicMapper {

    private VoteMapper voteMapper;

    @Autowired
    public TopicMapper(VoteMapper voteMapper) {
        this.voteMapper = voteMapper;
    }

    public TopicModel toRepository(OpenedTopic topic) {
        if(!Objects.isNull(topic.getId())) return this.existsRegisterToRepository(topic);
        return this.newRegisterToRepository(topic);
    }

    public TopicModel toRepository(ClosedTopic topic) {
        return this.existsRegisterToRepository(topic);
    }

    private TopicModel newRegisterToRepository(OpenedTopic topic) {
        final var model = new TopicModel(topic.getName(), topic.getStatus(), topic.getExpirationTime(), topic.getAuditableInfo().getCreatedBy(), topic.getAuditableInfo().getLastSourcePlatform());
        this.fillVotes(topic, model);
        return model;
    }

    private TopicModel existsRegisterToRepository(OpenedTopic topic) {
        final var model = this.factoryOpenedTopicModel(topic);
        this.fillVotes(topic, model);
        return model;
    }

    private TopicModel existsRegisterToRepository(ClosedTopic topic) {
       return this.factoryClosedTopicModel(topic);
    }

    private TopicModel factoryOpenedTopicModel(OpenedTopic topic) {
        return new TopicModel(
                topic.getId(),
                topic.getName(),
                topic.getStatus(),
                topic.getExpirationTime(),
                topic.getAuditableInfo().getCreatedBy(),
                topic.getAuditableInfo().getCreatedAt(),
                topic.getAuditableInfo().getUpdatedBy(),
                topic.getAuditableInfo().getUpdatedAt(),
                topic.getAuditableInfo().getLastSourcePlatform(),
                topic.getVersion().getRegisterVersion()
        );
    }

    private TopicModel factoryClosedTopicModel(ClosedTopic topic) {
        return new TopicModel(
                topic.getId(),
                topic.getName(),
                topic.getStatus(),
                topic.getExpirationTime(),
                topic.getClosedTime(),
                topic.getAuditableInfo().getCreatedBy(),
                topic.getAuditableInfo().getCreatedAt(),
                topic.getAuditableInfo().getUpdatedBy(),
                topic.getAuditableInfo().getUpdatedAt(),
                topic.getAuditableInfo().getLastSourcePlatform(),
                topic.getVersion().getRegisterVersion()
        );
    }

    private void fillVotes(OpenedTopic topic, TopicModel model) {
        topic.getVotes().forEach(vote -> {
            var voteModel = this.voteMapper.toRepository(vote);
            model.addVotes(voteModel);
        });
    }
}
