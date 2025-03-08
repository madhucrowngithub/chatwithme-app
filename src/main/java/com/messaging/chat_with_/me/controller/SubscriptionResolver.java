package com.messaging.chat_with_.me.controller;

import com.messaging.chat_with_.me.models.Message;
import com.messaging.chat_with_.me.services.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.SubscriptionMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.time.Duration;

@Controller
public class SubscriptionResolver {

    private final Sinks.Many<Message> messageSink = Sinks.many().multicast().onBackpressureBuffer();

    @SubscriptionMapping
    public Flux<Message> messageSent(@Argument String roomId) {
//        return messageSink.asFlux()
//                .filter(message -> message.getRoomId().equals(roomId));
        return messageSink.asFlux()
                .filter(message -> message.getRoomId().equals(roomId))
                .doOnSubscribe(subscription ->
                        System.out.println("Subscribed to roomId: " + roomId))  // Debugging line
                .doOnTerminate(() ->
                        System.out.println("Subscription terminated for roomId: " + roomId)); // Debugging line
    }
    public void publishMessage(Message message) {
        messageSink.tryEmitNext(message);
    }
}

