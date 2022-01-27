package com.workshop.vote.infra.crossCutting.patterns.factory;

import com.workshop.vote.infra.crossCutting.patterns.factory.interfaces.IFactoryWithParams;

public abstract class BaseFactoryWithParams<TParams, TOut> extends BaseFactory<TOut> implements IFactoryWithParams<TParams, TOut> {

    @Override
    public TOut create() {
        return null;
    }

    @Override
    public abstract TOut create(TParams params);
}
