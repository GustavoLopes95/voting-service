package com.workshop.vote;

import com.workshop.vote.application.commands.CreateTopicCommand;
import com.workshop.vote.domain.entities.NewTopic;
import com.workshop.vote.domain.entities.OpenedTopic;
import com.workshop.vote.domain.factories.NewTopicFactory;
import com.workshop.vote.domain.factories.OpenedTopicFactory;
import org.javatuples.Ennead;
import org.javatuples.Quartet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@ContextConfiguration(classes = TestBaseConfig.class)
public class BaseTest {

    @Autowired
    NewTopicFactory newTopicFactory;

    @Autowired
    OpenedTopicFactory openedTopicFactory;

    public CreateTopicCommand makeCreateTopicCommand() {
        return new CreateTopicCommand("TopicTest", 90.0);
    }

    public CreateTopicCommand makeInvalidCreateTopicCommand() {
        return new CreateTopicCommand("", null);
    }

    public NewTopic makeNewTopic() {
        return newTopicFactory.create(Quartet.with("Topic test", 60.0, "username", "api-vote"));
    }

    public OpenedTopic makeOpenedTopic() {
        return openedTopicFactory.create(
                Ennead.with(
                        1L,
                        "Topic test",
                        60.0,
                        "username",
                        Instant.now(),
                        "usernameTwo",
                        Instant.now(),
                        "api-vote",
                        1
                )
        );
    }

    protected Collection<OpenedTopic> makeExpiredTopicCollection() {
        var list = new Collection<OpenedTopic>();
        for (var i = 0; i <= 5; i++) {
            list.add
        }
    }
}
