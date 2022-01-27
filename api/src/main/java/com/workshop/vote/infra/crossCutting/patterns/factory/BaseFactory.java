package com.workshop.vote.infra.crossCutting.patterns.factory;

import com.workshop.vote.infra.crossCutting.patterns.factory.interfaces.IFactory;

public abstract class BaseFactory<TOut> implements IFactory<TOut> {
    @Override
    public abstract TOut create();
}
