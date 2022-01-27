package com.workshop.vote.infra.crossCutting.messages.notifications;

import com.workshop.vote.infra.crossCutting.messages.interfaces.INotification;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Component
@RequestScope
public class NotificationHandler {

    List<INotification> notifications;

    public NotificationHandler() {
        this.notifications = new ArrayList<>();
    }

    public void addNotification(INotification notification) {
        this.notifications.add(notification);
    }

    public Boolean hasNotification() {
        return this.notifications.size() > 0;
    }

    public Collection<INotification> getNotification() {
        return Collections.unmodifiableCollection(this.notifications);
    }

    public void clearNotification() {
        this.notifications.clear();
    }
}
