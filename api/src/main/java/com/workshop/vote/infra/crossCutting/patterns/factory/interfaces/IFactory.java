package com.workshop.vote.infra.crossCutting.patterns.factory.interfaces;

public interface IFactory<TOut> {
    TOut create();
}
