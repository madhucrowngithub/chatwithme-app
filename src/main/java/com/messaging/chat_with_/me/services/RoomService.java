package com.messaging.chat_with_.me.services;

import com.messaging.chat_with_.me.models.Room;

import java.util.List;

public interface RoomService {
    public Room createRoom(String name);

    public List<Room> getAllRooms();
}
