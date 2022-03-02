package com.workshop.vote.application.useCase;

import com.workshop.vote.BaseTest;
import com.workshop.vote.domain.entities.OpenedTopic;
import com.workshop.vote.domain.interfaces.ITopicRepository;
import com.workshop.vote.infra.crossCutting.messages.notifications.NotificationHandler;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class VoteUseCaseTest extends BaseTest {

    @MockBean
    ITopicRepository repository;

    @Autowired
    NotificationHandler notificationHandler;

    private VoteUseCase useCase;

    @BeforeEach
    public void setup() {
        this.useCase = new VoteUseCase(notificationHandler, repository);
    }

    @Test
    @DisplayName("[USECASE] - Do a valid vote")
    public void doValidVoteTest() {
        //Scenery
        var openedTopic = this.makeOpenedTopic();
        var command = this.makeVoteCommand();
        Mockito.doReturn(openedTopic).when(repository).findById(Mockito.anyLong());
        Mockito.doNothing().when(repository).update(Mockito.any(OpenedTopic.class));

        //Run
        useCase.execute(command);

        //Assertions
        Mockito.verify(repository, Mockito.times(1)).findById(Mockito.anyLong());
        Mockito.verify(repository, Mockito.times(1)).update(Mockito.any(OpenedTopic.class));
        Assertions.assertThat(openedTopic.getVotes().size()).isEqualTo(1);
    }

    @Test
    @DisplayName("[USECASE] - Do a valid vote")
    public void doInvalidValidVoteTest() {
        //Scenery
        var openedTopic = this.makeOpenedTopic();
        var command = this.makeVoteCommand();
        Mockito.doReturn(null).when(repository).findById(Mockito.anyLong());
        Mockito.doNothing().when(repository).update(Mockito.any(OpenedTopic.class));

        //Run
        useCase.execute(command);

        //Assertions
        Mockito.verify(repository, Mockito.times(1)).findById(Mockito.anyLong());
        Mockito.verify(repository, Mockito.never()).update(Mockito.any(OpenedTopic.class));
        Assertions.assertThat(openedTopic.getVotes().size()).isEqualTo(0);
    }
}
