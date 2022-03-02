package com.workshop.vote.application.useCase;

import com.workshop.vote.application.useCase.interfaces.IUseCase;
import com.workshop.vote.infra.crossCutting.messages.BaseInput;
import com.workshop.vote.infra.crossCutting.messages.notifications.DomainNotification;
import com.workshop.vote.infra.crossCutting.messages.notifications.NotificationHandler;

import java.util.Objects;

public abstract class BaseUseCase<TOut> implements IUseCase<TOut> {

    private NotificationHandler notificationHandler;

    public BaseUseCase(NotificationHandler notificationHandler) {
        this.notificationHandler = notificationHandler;
    }

    @Override
    public abstract TOut execute();

    protected Boolean isCommandValid(BaseInput command) {
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
