package com.workshop.vote.infra.data;

import com.workshop.vote.domain.entities.OpenedTopic;
import com.workshop.vote.domain.interfaces.ITopicSchedulerRepository;
import com.workshop.vote.infra.data.mapper.TopicRedisMapper;
import com.workshop.vote.infra.data.model.TopicRedisModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

@Repository
public class TopicRedisRepository implements ITopicSchedulerRepository {

    private RedisTemplate<String, TopicRedisModel> template;

    private HashOperations<String, String, TopicRedisModel> hashOperations;

    private TopicRedisMapper mapper;

    private String entry = "TOPIC";

    @Autowired
    public TopicRedisRepository(RedisTemplate<String, TopicRedisModel> template, TopicRedisMapper mapper) {
        this.template = template;
        this.hashOperations = template.opsForHash();
        this.mapper = mapper;
    }

    public Collection<OpenedTopic> findAll() {
        var entries = this.hashOperations.entries(entry);
        return entries.values().stream().map(topicRedisModel -> mapper.toDomain(topicRedisModel)).collect(Collectors.toUnmodifiableList());
    }

    public void save(OpenedTopic topic) {
        var entity = mapper.toRepository(topic);
        hashOperations.put(entry, topic.getHash(), entity);
    }

    public void remove(String hashKey) {
        hashOperations.delete(entry, hashKey);
    }
}
