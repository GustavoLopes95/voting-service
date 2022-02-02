package com.workshop.vote.application.useCase;

import com.workshop.vote.application.commands.VoteCommand;
import com.workshop.vote.domain.entities.OpenedTopic;
import com.workshop.vote.domain.interfaces.ITopicRepository;
import com.workshop.vote.domain.valueObject.VoteValueObject;
import com.workshop.vote.infra.crossCutting.messages.notifications.NotificationHandler;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

public class VoteUseCase extends BaseUseCaseWithParams<VoteCommand, Void> {

    private ITopicRepository repository;

    @Autowired
    public VoteUseCase(NotificationHandler notificationHandler, ITopicRepository repository) {
        super(notificationHandler);
        this.repository = repository;
    }

    @Override
    public Void execute(VoteCommand command) {
        if(!this.isCommandValid(command)) return null;

        var topic = this.repository.findById(command.getTopicId());
        if(Objects.isNull(topic)) return null;

        this.addVote(topic);

        this.repository.update(topic);

        return null;
    }

    private void addVote(OpenedTopic topic) {
        var vote = new VoteValueObject("username", "vote-api");
        topic.addVote(vote);
    }



}
