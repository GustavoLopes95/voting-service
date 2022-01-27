package com.workshop.vote.application.useCase;

import com.workshop.vote.application.useCase.interfaces.IUseCaseWithParams;
import com.workshop.vote.infra.crossCutting.messages.BaseCommand;
import com.workshop.vote.infra.crossCutting.messages.notifications.DomainNotification;
import com.workshop.vote.infra.crossCutting.messages.notifications.NotificationHandler;

import java.util.Objects;

public abstract class BaseUseCaseWithParams<TParams, TOut> implements IUseCaseWithParams<TParams, TOut> {

    private NotificationHandler notificationHandler;

    public BaseUseCaseWithParams(NotificationHandler notificationHandler) {
        this.notificationHandler = notificationHandler;
    }

    @Override
    public TOut execute() {
        return null;
    }

    public abstract TOut execute(TParams params);

    protected Boolean isCommandValid(BaseCommand command) {
        if(command.isValid()) return true;

        for(var error : command.getErrors()) {
            this.notificationHandler.addNotification(
                    new DomainNotification(
                            error.getField(),
                            this.toStringOrEmpty(error.getAttemptedValue()),
                            error.getMessage()
                    )
            );
        }
        return false;
    }

    private String toStringOrEmpty(Object value) {
        if(Objects.isNull(value)) return "";
        return value.toString();
    }
}
