package com.messaging.chat_with_.me.repository;

import com.messaging.chat_with_.me.models.Room;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoomRepository extends MongoRepository<Room, String> {
}
