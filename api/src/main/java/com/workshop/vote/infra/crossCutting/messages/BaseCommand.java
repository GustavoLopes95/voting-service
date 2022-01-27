package com.workshop.vote.infra.crossCutting.messages;

import br.com.fluentvalidator.context.Error;
import br.com.fluentvalidator.context.ValidationResult;
import com.workshop.vote.infra.crossCutting.messages.interfaces.ICommand;

import java.util.Collection;
import java.util.Collections;

public abstract class BaseCommand implements ICommand {

    //Protected Properties
    protected ValidationResult validator;

    //Public Methods
    public Collection<Error> getErrors() {
        return Collections.unmodifiableCollection(this.validator.getErrors());
    }

    @Override
    public abstract Boolean isValid();
}
