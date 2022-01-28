package com.workshop.vote.application.useCase;

import com.workshop.vote.domain.interfaces.ITopicSchedulerRepository;
import com.workshop.vote.infra.crossCutting.messages.notifications.NotificationHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComputeExpiredTopicUseCase extends BaseUseCase<Void> {

    private ITopicSchedulerRepository repository;

    @Autowired
    public ComputeExpiredTopicUseCase(NotificationHandler notificationHandler, ITopicSchedulerRepository repository) {
        super(notificationHandler);
        this.repository = repository;
    }

    @Override
    public Void execute() {
        return null;
    }
}
