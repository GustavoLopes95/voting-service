package com.workshop.vote.infra.data.adpter;

import com.workshop.vote.infra.crossCutting.patterns.adapter.BaseAdapter;
import com.workshop.vote.infra.data.model.TopicModel;
import org.springframework.stereotype.Repository;


@Repository
public class TopicRepositoryAdapter extends BaseAdapter<ITopicRepositorySpringJPA> {

    public TopicRepositoryAdapter(ITopicRepositorySpringJPA to) {
        super(to);
    }

    public void save(TopicModel topic) {
        this.to.save(topic);
    }

    public void update(TopicModel topic) {
        this.to.save(topic);
    }

    public Integer countVoteByTopicId(TopicModel topicId) {
        return this.to.countVoteByTopicId(topicId);
    }
}
