package com.workshop.vote.infra.data;

import com.workshop.vote.domain.entities.BaseTopic;
import com.workshop.vote.domain.entities.ClosedTopic;
import com.workshop.vote.domain.entities.NewTopic;
import com.workshop.vote.domain.interfaces.ITopicRepository;
import com.workshop.vote.infra.data.adpter.TopicRepositoryAdapter;
import org.springframework.stereotype.Repository;

@Repository
public class TopicRepositorySQL implements ITopicRepository {

    private TopicRepositoryAdapter adapter;

    public TopicRepositorySQL(TopicRepositoryAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public BaseTopic findById(Long id) {
        return null;
    }

    @Override
    public void save(NewTopic topic) {
        this.adapter.save(topic);
    }

    @Override
    public void update(ClosedTopic topic) {

    }
}
