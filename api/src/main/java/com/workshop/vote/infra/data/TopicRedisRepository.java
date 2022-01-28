package com.workshop.vote.infra.data;

import com.workshop.vote.domain.entities.OpenedTopic;
import com.workshop.vote.domain.interfaces.ITopicSchedulerRepository;
import com.workshop.vote.infra.data.mapper.TopicRedisMapper;
import com.workshop.vote.infra.data.model.TopicRedisModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TopicRedisRepository implements ITopicSchedulerRepository {

    private RedisTemplate<String, TopicRedisModel> template;

    private HashOperations hashOperations;

    private String entry = "TOPIC";

    @Autowired
    public TopicRedisRepository(RedisTemplate<String, TopicRedisModel> template) {
        this.template = template;
        this.hashOperations = template.opsForHash();
    }

    public void save(OpenedTopic topic) {
        var entity = TopicRedisMapper.toRepository(topic);
        hashOperations.put(entry, topic.getHash(), entity);
    }

    public void remove(String hashKey) {
        hashOperations.delete(entry, hashKey);
    }
}
