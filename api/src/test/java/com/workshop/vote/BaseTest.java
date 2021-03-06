package com.workshop.vote;

import com.workshop.vote.application.inputs.CreateTopicInput;
import com.workshop.vote.application.inputs.VoteInput;
import com.workshop.vote.domain.entities.NewTopic;
import com.workshop.vote.domain.entities.OpenedTopic;
import com.workshop.vote.domain.factories.NewTopicFactory;
import com.workshop.vote.domain.factories.OpenedTopicFactory;
import org.javatuples.Ennead;
import org.javatuples.Quartet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.time.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.UUID;

@ContextConfiguration(classes = TestBaseConfig.class)
public class BaseTest {

    @Autowired
    NewTopicFactory newTopicFactory;

    @Autowired
    OpenedTopicFactory openedTopicFactory;

    public CreateTopicInput makeCreateTopicCommand() {
        return new CreateTopicInput("TopicTest", 90L);
    }

    public CreateTopicInput makeInvalidCreateTopicCommand() {
        return new CreateTopicInput("", null);
    }

    public VoteInput makeVoteCommand() {
        return new VoteInput(1L, UUID.randomUUID(), "VOTE_MESSAGE", "vote-api");
    }

    public NewTopic makeNewTopic() {
        return newTopicFactory.create(Quartet.with("Topic test", 60L, "username", "api-vote"));
    }

    public OpenedTopic makeOpenedTopic() {
        return openedTopicFactory.create(
                Ennead.with(
                        1L,
                        "Topic test",
                        LocalDateTime.now(ZoneOffset.UTC),
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
        var list = new ArrayList<OpenedTopic>();
        var instant = LocalDateTime.now(ZoneOffset.UTC);
        var pastTime = instant.minusHours(1);
        for (var i = 0L; i <= 5L; i++) {
            list.add(openedTopicFactory.create(
                    Ennead.with(
                            i,
                            "Topic test ".concat(String.valueOf(i)),
                            pastTime,
                            "username".concat(String.valueOf(i)),
                            Instant.now(),
                            "usernameTwo".concat(String.valueOf(i)),
                            Instant.now(),
                            "api-vote",
                            1
                    )
                )
            );
        }
        return Collections.unmodifiableCollection(list);
    }
}
