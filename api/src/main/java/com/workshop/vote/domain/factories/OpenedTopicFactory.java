package com.workshop.vote.domain.factories;

import com.workshop.vote.domain.entities.NewTopic;
import com.workshop.vote.domain.entities.OpenedTopic;
import com.workshop.vote.infra.crossCutting.patterns.factory.BaseFactoryWithParams;
import org.javatuples.Ennead;
import org.javatuples.Octet;
import org.javatuples.Triplet;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Component
public class OpenedTopicFactory extends BaseFactoryWithParams<Ennead<Long, String, LocalDateTime, String, Instant, String, Instant, String, Integer>, OpenedTopic> {

    @Override
    public OpenedTopic create(
            Ennead<Long, String, LocalDateTime, String, Instant, String, Instant, String, Integer> params
    ) {
        var entity = new OpenedTopic();
        entity.setInfoRegister(
            params.getValue0(), //id
            params.getValue1(), //name
            params.getValue2(), //expirationTime
            params.getValue3(), //createdBy
            params.getValue4(), //createdAt
            params.getValue5(), //updatedBy
            params.getValue6(), //updatedAt
            params.getValue7(), //lastSource
            params.getValue8()  //registerVersion
        );

        return entity;
    }
}
