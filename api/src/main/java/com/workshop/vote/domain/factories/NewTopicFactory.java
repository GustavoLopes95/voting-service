package com.workshop.vote.domain.factories;

import com.workshop.vote.domain.entities.NewTopic;
import com.workshop.vote.infra.crossCutting.patterns.factory.BaseFactoryWithParams;
import org.javatuples.Quartet;
import org.springframework.stereotype.Component;

@Component
public class NewTopicFactory extends BaseFactoryWithParams<Quartet<String, Double, String, String>, NewTopic> {

    @Override
    public NewTopic create(Quartet<String, Double, String, String> params) {
        var entity = new NewTopic();
        entity.setNewInfoRegister(
            params.getValue0(), // Topic name
            params.getValue1(), // secondDuration
            params.getValue2(), // createdBy
            params.getValue3() // lastPlatformSource
        );

        return entity;
    }
}
