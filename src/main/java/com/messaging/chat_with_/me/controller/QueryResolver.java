package com.messaging.chat_with_.me.controller;

import com.messaging.chat_with_.me.models.Message;
import com.messaging.chat_with_.me.models.Room;
import com.messaging.chat_with_.me.models.User;
import com.messaging.chat_with_.me.services.ChatService;
import com.messaging.chat_with_.me.services.RoomService;
import com.messaging.chat_with_.me.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class QueryResolver {
    @Autowired
    private ChatService chatService;

    @Autowired
    private UserService userService;
    @Autowired
    private RoomService roomService;
    @QueryMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }
    @QueryMapping
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }

    @QueryMapping
    public List<Message> getMessages(@Argument String roomId) {
        return chatService.getMessages(roomId);
    }
}
