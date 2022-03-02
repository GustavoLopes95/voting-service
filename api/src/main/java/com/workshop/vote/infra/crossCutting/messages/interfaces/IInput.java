package com.workshop.vote.infra.crossCutting.messages.interfaces;

import br.com.fluentvalidator.context.Error;

import java.util.Collection;

public interface IInput {
    Collection<Error> getErrors();
    Boolean isValid();
}
