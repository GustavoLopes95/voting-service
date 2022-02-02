package com.workshop.vote.application.scheduler;

import com.workshop.vote.application.useCase.ComputeExpiredTopicUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Component
public class ComputeExpiredTopicScheduler {

    private static final Logger log = LoggerFactory.getLogger(ComputeExpiredTopicScheduler.class);
    private ComputeExpiredTopicUseCase useCase;

    @Autowired
    public ComputeExpiredTopicScheduler(ComputeExpiredTopicUseCase useCase) {
        this.useCase = useCase;
    }

    @Scheduled(fixedDelay = 5000)
    public void run() {
        log.info("Run ComputeExpiredTopicScheduler at ".concat(LocalDateTime.now(ZoneOffset.UTC).toString()));
        this.useCase.execute();
    }

}
