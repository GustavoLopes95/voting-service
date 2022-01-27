package com.workshop.vote.infra.crossCutting.messages.interfaces;

import br.com.fluentvalidator.context.Error;

import java.util.Collection;

public interface ICommand {
    Collection<Error> getErrors();
    Boolean isValid();
}
