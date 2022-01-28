package com.workshop.vote.domain.interfaces;

import com.workshop.vote.domain.entities.BaseTopic;
import com.workshop.vote.domain.entities.ClosedTopic;
import com.workshop.vote.domain.entities.NewTopic;
import com.workshop.vote.domain.entities.OpenedTopic;
import com.workshop.vote.infra.crossCutting.data.interfaces.IRepository;

public interface ITopicRepository extends IRepository<BaseTopic> {
    NewTopic findById(Long id);
    OpenedTopic save(OpenedTopic topic);
    void update(ClosedTopic topic);
}
