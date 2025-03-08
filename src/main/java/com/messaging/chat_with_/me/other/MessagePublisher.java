package com.messaging.chat_with_.me.other;

import com.messaging.chat_with_.me.controller.SubscriptionResolver;
import com.messaging.chat_with_.me.models.Message;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
@Component
public class MessagePublisher {

    private final SubscriptionResolver subscriptionResolver;

    @Autowired
    public MessagePublisher(SubscriptionResolver subscriptionResolver) {
        this.subscriptionResolver = subscriptionResolver;
    }

    @PostConstruct
    public void start() {
        System.out.println("Starting to publish messages");
        startPublishingMessages();
    }

    public void startPublishingMessages() {
        Flux.interval(Duration.ofSeconds(2))
                .map(i -> new Message( "ksdhfks","678a824c9e032c7d1abb2993", "678a824c9e032c7d1abb2993", "test_" + i, System.currentTimeMillis()+"", null, null))
                .doOnNext(subscriptionResolver::publishMessage)
                .subscribe();
    }


    public void publishMessage(Message message) {
        subscriptionResolver.publishMessage(message);
    }
}
