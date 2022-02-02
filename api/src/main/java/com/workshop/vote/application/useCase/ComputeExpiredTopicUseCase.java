package com.workshop.vote.application.useCase;

import com.workshop.vote.domain.entities.OpenedTopic;
import com.workshop.vote.domain.interfaces.ITopicRepository;
import com.workshop.vote.domain.interfaces.ITopicSchedulerRepository;
import com.workshop.vote.infra.crossCutting.messages.notifications.NotificationHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComputeExpiredTopicUseCase extends BaseUseCase<Void> {

    private ITopicRepository repository;
    private ITopicSchedulerRepository schedulerRepository;

    @Autowired
    public ComputeExpiredTopicUseCase(NotificationHandler notificationHandler, ITopicRepository repository, ITopicSchedulerRepository schedulerRepository) {
        super(notificationHandler);
        this.repository = repository;
        this.schedulerRepository = schedulerRepository;
    }

    @Override
    public Void execute() {
        var openedTopics = this.schedulerRepository.findAll();
        openedTopics.forEach(topic -> {
            if(topic.isExpired()) {
                this.compute(topic);
                this.removeTopicFromScheduler(topic);
            }
        });

        return null;
    }

    private void compute(OpenedTopic topic) {
        var votes = this.repository.countVoteByTopicId(topic);
        var closedTopic = topic.close(votes);
        this.repository.update(closedTopic);
    }

    private void removeTopicFromScheduler(OpenedTopic topic) {
        this.schedulerRepository.remove(topic.getHash());
    }
}
