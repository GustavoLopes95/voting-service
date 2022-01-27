package com.workshop.vote.application.useCase.interfaces;

public interface IUseCase<TOut> {
    TOut execute();
}
