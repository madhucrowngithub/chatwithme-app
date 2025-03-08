package com.messaging.chat_with_.me.services;

import com.messaging.chat_with_.me.models.User;

import java.util.List;

public interface UserService {

    public User createUser(String username, String status);

    public List<User> getUsers();
}
