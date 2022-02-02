package com.workshop.vote.domain.interfaces;

import com.workshop.vote.domain.entities.OpenedTopic;

import java.util.Collection;

public interface ITopicSchedulerRepository {
    Collection<OpenedTopic> findAll();
    void save(OpenedTopic topic);
    void remove(String id);
}
