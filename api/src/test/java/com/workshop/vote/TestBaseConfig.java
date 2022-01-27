package com.workshop.vote;

import com.workshop.vote.application.useCase.CreateTopicUseCase;
import com.workshop.vote.domain.factories.NewTopicFactory;
import com.workshop.vote.domain.factories.OpenedTopicFactory;
import com.workshop.vote.infra.crossCutting.messages.notifications.NotificationHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestBaseConfig {

    @Bean
    public NewTopicFactory newTopicFactory() {
        return new NewTopicFactory();
    }

    @Bean
    public OpenedTopicFactory openedTopicFactory() {
        return new OpenedTopicFactory();
    }

    @Bean
    public NotificationHandler notificationHandler() {
        return new NotificationHandler();
    }
}
