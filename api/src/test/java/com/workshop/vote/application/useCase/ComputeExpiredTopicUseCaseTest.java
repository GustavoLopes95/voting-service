package com.workshop.vote.application.useCase;

import com.workshop.vote.BaseTest;
import com.workshop.vote.domain.interfaces.ITopicSchedulerRepository;
import com.workshop.vote.infra.crossCutting.messages.notifications.NotificationHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class ComputeExpiredTopicUseCaseTest extends BaseTest {

    @MockBean
    ITopicSchedulerRepository repository;

    @Autowired
    NotificationHandler notificationHandler;

    private ComputeExpiredTopicUseCase useCase;

    @BeforeEach
    public void setup() {
        this.useCase = new ComputeExpiredTopicUseCase(notificationHandler, repository);
    }

    @Test
    @DisplayName("[USECASE] - Should update expired topics to computing")
    public void shouldUpdateExpiredTopicsToComputing() {
        //Scenario
        var expiredTopicCollection = this.makeExpiredTopicCollection();
        Mockito.doReturn().when(repository).findAll();

        //Run
        this.useCase.execute();
    }
}
