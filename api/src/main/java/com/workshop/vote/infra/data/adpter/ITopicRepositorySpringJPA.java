package com.workshop.vote.infra.data.adpter;

import com.workshop.vote.domain.entities.BaseTopic;
import com.workshop.vote.infra.data.model.TopicModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITopicRepositorySpringJPA extends JpaRepository<TopicModel, Long> {}
