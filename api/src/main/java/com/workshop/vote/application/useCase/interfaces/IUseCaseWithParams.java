package com.workshop.vote.application.useCase.interfaces;

public interface IUseCaseWithParams<TParams, TOut> extends IUseCase<TOut> {
    TOut execute(TParams params);
}
