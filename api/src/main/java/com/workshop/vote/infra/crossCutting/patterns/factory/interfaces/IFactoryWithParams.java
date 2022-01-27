package com.workshop.vote.infra.crossCutting.patterns.factory.interfaces;

public interface IFactoryWithParams<TParams, TOut> extends IFactory<TOut> {
    TOut create(TParams params);
}
