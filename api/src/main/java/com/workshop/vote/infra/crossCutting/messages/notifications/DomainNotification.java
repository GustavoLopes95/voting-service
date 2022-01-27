package com.workshop.vote.infra.crossCutting.messages.notifications;

import com.workshop.vote.infra.crossCutting.messages.interfaces.INotification;
import lombok.Getter;

@Getter
public class DomainNotification implements INotification {
    private String field;
    private String attemptValue;
    private String message;

    public DomainNotification(String field, String attemptValue, String message) {
        this.field = field;
        this.attemptValue = attemptValue;
        this.message = message;
    }
}
