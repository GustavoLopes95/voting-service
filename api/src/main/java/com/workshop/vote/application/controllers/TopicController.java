package com.workshop.vote.application.controllers;

import com.workshop.vote.application.commands.CreateTopicCommand;
import com.workshop.vote.application.useCase.CreateTopicUseCase;
import com.workshop.vote.infra.crossCutting.messages.notifications.NotificationHandler;
import org.javatuples.Pair;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/topic")
public class TopicController extends BaseController {

    private CreateTopicUseCase createTopicUseCase;

    public TopicController(CreateTopicUseCase createTopicUseCase, NotificationHandler handler) {
        super(handler);
        this.createTopicUseCase = createTopicUseCase;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody CreateTopicCommand command) {
        this.createTopicUseCase.execute(command);
        if(this.hasNotification()) {
            return ResponseEntity.badRequest().body(this.getNotifications());
        }
        return ResponseEntity.ok().build();
    }
}
