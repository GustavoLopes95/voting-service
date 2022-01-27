package com.workshop.vote.application.useCase;


import com.workshop.vote.application.commands.CreateTopicCommand;
import com.workshop.vote.domain.factories.NewTopicFactory;
import com.workshop.vote.domain.interfaces.ITopicRepository;
import com.workshop.vote.infra.crossCutting.messages.notifications.NotificationHandler;
import org.javatuples.Quartet;
import org.javatuples.Triplet;
import org.springframework.stereotype.Service;

@Service
public class CreateTopicUseCase extends BaseUseCaseWithParams<CreateTopicCommand, Void> {

    private ITopicRepository repository;
    private NewTopicFactory factory;

    public CreateTopicUseCase(
            ITopicRepository repository,
            NewTopicFactory factory,
            NotificationHandler notificationHandler
    ) {
        super(notificationHandler);
        this.repository = repository;
        this.factory = factory;
    }

    @Override
    public Void execute(CreateTopicCommand command) {
        if(!this.isCommandValid(command)) return null;

        var newTopic = factory.create(
                Quartet.with(command.getName(), command.getSecondsDuration(), "username", "vote-api")
        );
        this.repository.save(newTopic);
        return null;
    }
}
