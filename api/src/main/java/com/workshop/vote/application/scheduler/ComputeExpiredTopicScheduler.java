package com.workshop.vote.application.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ComputeExpiredTopicScheduler {

    private static final Logger log = LoggerFactory.getLogger(ComputeExpiredTopicScheduler.class);

    @Scheduled(fixedDelay = 5000)
    public void run() {
        log.info("Hello world");
    }

}
