package com.workshop.vote.application.listeners;

import com.workshop.vote.application.inputs.VoteInput;
import com.workshop.vote.application.useCase.VoteUseCase;
import org.springframework.stereotype.Component;

@Component
public class VoteListener {

    private VoteUseCase voteUseCase;

    public VoteListener(VoteUseCase voteUseCase) {
        this.voteUseCase = voteUseCase;
    }

    public void execute(VoteInput message) {
        this.voteUseCase.execute(message);
    }
}
