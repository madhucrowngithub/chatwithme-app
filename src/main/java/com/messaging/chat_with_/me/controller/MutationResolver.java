package com.messaging.chat_with_.me.controller;

import com.messaging.chat_with_.me.models.Message;
import com.messaging.chat_with_.me.models.Room;
import com.messaging.chat_with_.me.models.User;
import com.messaging.chat_with_.me.services.ChatService;
import com.messaging.chat_with_.me.services.RoomService;
import com.messaging.chat_with_.me.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class MutationResolver {

    @Autowired
    private ChatService chatService;
    @Autowired
    private UserService userService;
    @Autowired
    private RoomService roomService;

    @MutationMapping
    public Room createRoom(@Argument String name) {
        return roomService.createRoom(name);
    }
    @MutationMapping
    public User createUser(
            @Argument String username,
            @Argument String status) {
        return userService.createUser(username, status);
    }
    @MutationMapping
    public Message sendMessage(
            @Argument String roomId,
            @Argument String senderId,
            @Argument String content) {
        return chatService.sendMessage(roomId, senderId, content);
    }
}
