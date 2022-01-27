package com.workshop.vote.domain.interfaces;

import com.workshop.vote.domain.entities.BaseTopic;
import com.workshop.vote.domain.entities.ClosedTopic;
import com.workshop.vote.domain.entities.NewTopic;
import com.workshop.vote.infra.crossCutting.data.interfaces.IRepository;

public interface ITopicRepository extends IRepository<BaseTopic> {
    BaseTopic findById(Long id);
    void save(NewTopic topic);
    void update(ClosedTopic topic);
}
