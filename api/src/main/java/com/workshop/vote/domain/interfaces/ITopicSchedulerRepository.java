package com.workshop.vote.domain.interfaces;

import com.workshop.vote.domain.entities.OpenedTopic;

public interface ITopicSchedulerRepository {
    void save(OpenedTopic topic);
    void remove(String id);
}
