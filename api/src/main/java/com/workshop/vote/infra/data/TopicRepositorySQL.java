package com.workshop.vote.infra.data;

import com.workshop.vote.domain.entities.ClosedTopic;
import com.workshop.vote.domain.entities.NewTopic;
import com.workshop.vote.domain.entities.OpenedTopic;
import com.workshop.vote.domain.interfaces.ITopicRepository;
import com.workshop.vote.infra.data.adpter.TopicRepositoryAdapter;
import com.workshop.vote.infra.data.mapper.TopicMapper;
import org.springframework.stereotype.Repository;

import java.util.Objects;

@Repository
public class TopicRepositorySQL implements ITopicRepository {

    private TopicRepositoryAdapter adapter;
    private TopicMapper mapper;

    public TopicRepositorySQL(TopicRepositoryAdapter adapter, TopicMapper mapper) {
        this.adapter = adapter;
        this.mapper = mapper;
    }

    @Override
    public OpenedTopic findById(Long id) {
        var model = this.adapter.findById(id);
        if(Objects.isNull(model)) return null;
        return mapper.toDomain(model);
    }

    @Override
    public OpenedTopic save(OpenedTopic topic) {
        this.adapter.save(mapper.toRepository(topic));
        return topic;
    }

    @Override
    public Integer countVoteByTopicId(OpenedTopic topic) {
        var topicModel = mapper.toRepository(topic);
        return this.adapter.countVoteByTopicId(topicModel);
    }

    public void update(OpenedTopic topic) {
        var model = mapper.toRepository(topic);
        this.adapter.update(model);
    }

    @Override
    public void update(ClosedTopic topic) {
        var model = mapper.toRepository(topic);
        this.adapter.update(model);
    }


}
