package com.messaging.chat_with_.me.services;

import com.messaging.chat_with_.me.models.Message;
import com.messaging.chat_with_.me.models.User;

import java.util.List;

public interface ChatService {


    public List<Message> getMessages(String roomId);
    public Message sendMessage(String roomId, String senderId, String content);
}
