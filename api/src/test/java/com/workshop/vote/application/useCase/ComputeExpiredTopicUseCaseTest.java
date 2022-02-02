package com.workshop.vote.application.useCase;

import com.workshop.vote.BaseTest;
import com.workshop.vote.domain.entities.ClosedTopic;
import com.workshop.vote.domain.entities.OpenedTopic;
import com.workshop.vote.domain.interfaces.ITopicRepository;
import com.workshop.vote.domain.interfaces.ITopicSchedulerRepository;
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

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
public class ComputeExpiredTopicUseCaseTest extends BaseTest {

    @MockBean
    ITopicRepository repository;

    @MockBean
    ITopicSchedulerRepository schedulerRepository;

    @Autowired
    NotificationHandler notificationHandler;

    private ComputeExpiredTopicUseCase useCase;

    @BeforeEach
    public void setup() {
        this.useCase = new ComputeExpiredTopicUseCase(notificationHandler, repository, schedulerRepository);
    }

    @Test
    @DisplayName("[USECASE] - Should update expired topics to computing")
    public void shouldUpdateExpiredTopicsToComputing() {
        //Scenario
        var expiredTopicCollection = this.makeExpiredTopicCollection();
        Mockito.doReturn(expiredTopicCollection).when(schedulerRepository).findAll();
        Mockito.doNothing().when(schedulerRepository).remove(Mockito.anyString());
        Mockito.doReturn(90).when(repository).countVoteByTopicId(Mockito.any(OpenedTopic.class));
        Mockito.doNothing().when(repository).update(Mockito.any(ClosedTopic.class));

        //Run
        this.useCase.execute();

        //Assertions
        Mockito.verify(schedulerRepository, Mockito.times(1)).findAll();
        Mockito.verify(schedulerRepository, Mockito.times(expiredTopicCollection.size())).remove(Mockito.anyString());
        Mockito.verify(repository, Mockito.times(expiredTopicCollection.size())).countVoteByTopicId(Mockito.any(OpenedTopic.class));
        Mockito.verify(repository, Mockito.times(expiredTopicCollection.size())).update(Mockito.any(ClosedTopic.class));
    }
}
