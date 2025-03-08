package com.messaging.chat_with_.me.services.imp;

import com.messaging.chat_with_.me.controller.SubscriptionResolver;
import com.messaging.chat_with_.me.models.Message;
import com.messaging.chat_with_.me.models.Room;
import com.messaging.chat_with_.me.models.User;
import com.messaging.chat_with_.me.other.MessagePublisher;
import com.messaging.chat_with_.me.repository.MessageRepository;
import com.messaging.chat_with_.me.repository.RoomRepository;
import com.messaging.chat_with_.me.repository.UserRepository;
import com.messaging.chat_with_.me.services.ChatService;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

@Data
@Service
@Transactional
public class ChatServiceImp implements ChatService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
   private MessagePublisher messagePublisher;
    public ChatServiceImp() {
        super();
    }



    public List<Message> getMessages(String roomId) {
        return messageRepository.findByRoomId(roomId);
    }

    public Message sendMessage(String roomId, String senderId, String content) {

        User sender = userRepository.findById(senderId)
                .orElseThrow(() -> new RuntimeException("Sender not found: " + senderId));

        // Fetch room
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new RuntimeException("Room not found: " + roomId));

        Message message = new Message();
        message.setRoomId(roomId);
        message.setSenderId(senderId);
        message.setContent(content);
        message.setTimestamp(Instant.now().toString());
        message.setRoom(room);
        message.setSender(sender);

        Message savedMessage = messageRepository.save(message);

        // Publish message to subscribers
        messagePublisher.publishMessage(savedMessage);

        return savedMessage;
    }
}
