package com.workshop.vote.application.controllers;

import com.workshop.vote.infra.crossCutting.messages.interfaces.INotification;
import com.workshop.vote.infra.crossCutting.messages.notifications.NotificationHandler;

import java.util.Collection;

public abstract class BaseController {

    private NotificationHandler notificationHandler;

    public BaseController(NotificationHandler handler) {
        this.notificationHandler = handler;
    }

    protected Boolean hasNotification() {
        return this.notificationHandler.hasNotification();
    }

    protected Collection<INotification> getNotifications() {
        return this.notificationHandler.getNotification();
    }
}
