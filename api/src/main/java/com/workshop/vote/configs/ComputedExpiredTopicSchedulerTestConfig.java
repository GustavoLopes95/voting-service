package com.workshop.vote.configs;

import com.workshop.vote.domain.entities.OpenedTopic;
import com.workshop.vote.domain.interfaces.ITopicRepository;
import com.workshop.vote.domain.interfaces.ITopicSchedulerRepository;
import com.workshop.vote.domain.valueObject.VoteValueObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.transaction.Transactional;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Configuration
@Profile("test")
public class ComputedExpiredTopicSchedulerTestConfig implements CommandLineRunner {

    @Autowired
    private ITopicSchedulerRepository schedulerRepository;

    @Autowired
    private ITopicRepository repository;


    @Transactional
    @Override
    public void run(String... args) {
        var openedTopic = new OpenedTopic();
        openedTopic.setInfoRegister(
                1L,
                "Topic test ".concat(String.valueOf(1L)),
                LocalDateTime.now(ZoneOffset.UTC),
                "username".concat(String.valueOf(1L)),
                Instant.now(),
                "usernameTwo".concat(String.valueOf(1L)),
                Instant.now(),
                "api-vote",
                1
        );
        var vote = new VoteValueObject(1L, openedTopic, Instant.now(), "username", Instant.now(), "username", Instant.now(), "api-vote", 1);
        openedTopic.addVote(vote);
        this.repository.save(openedTopic);
        this.schedulerRepository.save(openedTopic);
    }
}
