package com.workshop.vote.domain.factories;

import com.workshop.vote.domain.entities.NewTopic;
import com.workshop.vote.infra.crossCutting.patterns.factory.BaseFactoryWithParams;
import org.javatuples.Quartet;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;

@Component
public class NewTopicFactory extends BaseFactoryWithParams<Quartet<String, Long, String, String>, NewTopic> {

    @Override
    public NewTopic create(Quartet<String, Long, String, String> params) {
        var entity = new NewTopic();
        entity.setNewInfoRegister(
            params.getValue0(), // Topic name
            params.getValue1(), // expirationTime
            params.getValue2(), // createdBy
            params.getValue3() // lastPlatformSource
        );

        return entity;
    }
}
