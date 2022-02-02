package com.workshop.vote.infra.data.adpter;

import com.workshop.vote.domain.entities.BaseTopic;
import com.workshop.vote.infra.data.model.TopicModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.redis.listener.Topic;
import org.springframework.data.repository.query.Param;

public interface ITopicRepositorySpringJPA extends JpaRepository<TopicModel, Long> {
    @Query("SELECT COUNT(1) FROM topic t inner join t.votes v WHERE v.topic = :topic")
    Integer countVoteByTopicId(@Param("topic") TopicModel topicId);
}
