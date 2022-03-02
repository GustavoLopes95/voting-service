package com.workshop.vote.application.useCase;


import com.workshop.vote.application.inputs.CreateTopicInput;
import com.workshop.vote.domain.entities.NewTopic;
import com.workshop.vote.domain.entities.OpenedTopic;
import com.workshop.vote.domain.factories.NewTopicFactory;
import com.workshop.vote.domain.interfaces.ITopicRepository;
import com.workshop.vote.domain.interfaces.ITopicSchedulerRepository;
import com.workshop.vote.infra.crossCutting.messages.notifications.NotificationHandler;
import org.javatuples.Quartet;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CreateTopicUseCase extends BaseUseCaseWithParams<CreateTopicInput, Void> {

    private ITopicRepository repository;
    private ITopicSchedulerRepository schedulerRepository;
    private NewTopicFactory factory;

    public CreateTopicUseCase(
            ITopicRepository repository,
            ITopicSchedulerRepository schedulerRepository,
            NewTopicFactory factory,
            NotificationHandler notificationHandler
    ) {
        super(notificationHandler);
        this.repository = repository;
        this.schedulerRepository = schedulerRepository;
        this.factory = factory;
    }

    @Override
    @Transactional
    public Void execute(CreateTopicInput command) {
        if(!this.isCommandValid(command)) return null;

        var newTopic = this.parseToNewTopic(command);

        var openedTopic = this.persistInRelationalDatabase(newTopic.open());
        this.persistInSchedulerDatabase(openedTopic);
        return null;
    }

    private NewTopic parseToNewTopic(CreateTopicInput command) {
        return factory.create(
                Quartet.with(command.getName(), command.getSecondsDuration(), "username", "vote-api")
        );
    }

    private OpenedTopic persistInRelationalDatabase(OpenedTopic topic) {
        return this.repository.save(topic);
    }

    private void persistInSchedulerDatabase(OpenedTopic topic) {
        this.schedulerRepository.save(topic);
    }
}
