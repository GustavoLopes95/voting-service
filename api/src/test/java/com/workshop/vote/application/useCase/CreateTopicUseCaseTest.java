package com.workshop.vote.application.useCase;

import com.workshop.vote.TestBase;
import com.workshop.vote.domain.entities.NewTopic;
import com.workshop.vote.domain.entities.OpenedTopic;
import com.workshop.vote.domain.factories.NewTopicFactory;
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
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
public class CreateTopicUseCaseTest extends TestBase {

    @MockBean
    ITopicRepository repository;

    @MockBean
    ITopicSchedulerRepository schedulerRepository;

    @Autowired
    private NewTopicFactory factory;

    @Autowired
    private NotificationHandler notificationHandler;

    private CreateTopicUseCase useCase;

    @BeforeEach
    public void setup() {
        this.useCase = new CreateTopicUseCase(repository, schedulerRepository, factory, notificationHandler);
    }

    @Test
    @DisplayName("[USECASE] - must create a new Topic")
    public void createNewValidTopic() {
        //Scenario
        var openedTopic = this.makeOpenedTopic();
        var command = this.makeCreateTopicCommand();
        Mockito.doReturn(openedTopic).when(repository).save(Mockito.any(OpenedTopic.class));
        Mockito.doNothing().when(schedulerRepository).save(Mockito.any(OpenedTopic.class));

        //Run
        this.useCase.execute(command);

        Mockito.verify(repository, Mockito.times(1)).save(Mockito.any(OpenedTopic.class));
        Mockito.verify(schedulerRepository, Mockito.times(1)).save(Mockito.any(OpenedTopic.class));
    }

    @Test
    @DisplayName("[USECASE] - must notifier errors when try insert a invalid new Topic")
    public void createNewInvalidTopic() {
        //Scenario
        var command = this.makeInvalidCreateTopicCommand();
        Mockito.doNothing().when(repository).save(Mockito.any(OpenedTopic.class));
        Mockito.doNothing().when(schedulerRepository).save(Mockito.any(OpenedTopic.class));

        //Run
        this.useCase.execute(command);

        //Asserts
        Mockito.verify(repository, Mockito.never()).save(Mockito.any(OpenedTopic.class));
        Mockito.verify(schedulerRepository, Mockito.never()).save(Mockito.any(OpenedTopic.class));
        assertThat(this.notificationHandler.hasNotification()).isTrue();

        var notification = new ArrayList<>(this.notificationHandler.getNotification());
        assertThat(notification).extracting("field").contains("name", "secondsDuration");
    }
}
