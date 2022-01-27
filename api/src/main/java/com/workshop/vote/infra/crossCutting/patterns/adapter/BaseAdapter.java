package com.workshop.vote.infra.crossCutting.patterns.adapter;

import com.workshop.vote.infra.crossCutting.patterns.adapter.interfaces.IAdapter;

public abstract class BaseAdapter<TTarget> implements IAdapter<TTarget> {
    protected TTarget from;

    protected BaseAdapter(TTarget target) {
        from = target;
    }
}
