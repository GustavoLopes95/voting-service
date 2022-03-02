package com.workshop.vote.configs;

import com.workshop.vote.application.inputs.VoteInput;
import com.workshop.vote.application.listeners.VoteListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RabbitMQTest implements CommandLineRunner {

    static final String routingKey = "vote.queue";
    private final RabbitTemplate rabbitTemplate;
    private final VoteListener receiver;

    public RabbitMQTest(RabbitTemplate rabbitTemplate, VoteListener receiver) {
        this.rabbitTemplate = rabbitTemplate;
        this.receiver = receiver;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Sending message....");
        rabbitTemplate.convertAndSend(BusConfig.topicExchangeName, routingKey, new VoteInput(1L, UUID.randomUUID(), "VOTE_MESSAGE", "vote-api"));
    }
}
