package com.workshop.vote.infra.data.adpter;

import com.workshop.vote.domain.entities.NewTopic;
import com.workshop.vote.domain.entities.OpenedTopic;
import com.workshop.vote.infra.crossCutting.patterns.adapter.BaseAdapter;
import com.workshop.vote.infra.data.mapper.TopicMapper;
import org.springframework.stereotype.Repository;

@Repository
public class TopicRepositoryAdapter extends BaseAdapter<ITopicRepositorySpringJPA> {

    public TopicRepositoryAdapter(ITopicRepositorySpringJPA from) {
        super(from);
    }

    public void save(OpenedTopic topic) {
        var model = TopicMapper.toRepository(topic);
        this.from.save(model);
    }
}
