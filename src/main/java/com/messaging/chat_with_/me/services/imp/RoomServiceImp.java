package com.messaging.chat_with_.me.services.imp;

import com.messaging.chat_with_.me.models.Room;
import com.messaging.chat_with_.me.repository.RoomRepository;
import com.messaging.chat_with_.me.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImp implements RoomService {
    @Autowired
    private RoomRepository roomRepository;

    public Room createRoom(String name) {
        Room room = new Room();
        room.setName(name);

        return roomRepository.save(room);
    }

    @Override
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }
}
