package com.workshop.vote.application.controllers;

import com.workshop.vote.application.inputs.CreateTopicInput;
import com.workshop.vote.application.useCase.CreateTopicUseCase;
import com.workshop.vote.application.useCase.VoteUseCase;
import com.workshop.vote.infra.crossCutting.messages.notifications.NotificationHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/topic")
public class TopicController extends BaseController {

    private CreateTopicUseCase createTopicUseCase;
    private VoteUseCase voteUseCase;

    @Autowired
    public TopicController(CreateTopicUseCase createTopicUseCase, VoteUseCase voteUseCase, NotificationHandler handler) {
        super(handler);
        this.createTopicUseCase = createTopicUseCase;
        this.voteUseCase = voteUseCase;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody CreateTopicInput command) {
        this.createTopicUseCase.execute(command);
        if(this.hasNotification()) {
            return ResponseEntity.badRequest().body(this.getNotifications());
        }
        return ResponseEntity.ok().build();
    }
}
