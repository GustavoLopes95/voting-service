package com.workshop.vote.application.useCase;

import com.workshop.vote.application.useCase.interfaces.IUseCaseWithParams;
import com.workshop.vote.infra.crossCutting.messages.notifications.NotificationHandler;

public abstract class BaseUseCaseWithParams<TParams, TOut> extends BaseUseCase<TOut> implements IUseCaseWithParams<TParams, TOut> {

    public BaseUseCaseWithParams(NotificationHandler notificationHandler) {
        super(notificationHandler);
    }

    @Override
    public TOut execute() {
        return null;
    }

    public abstract TOut execute(TParams params);
}
