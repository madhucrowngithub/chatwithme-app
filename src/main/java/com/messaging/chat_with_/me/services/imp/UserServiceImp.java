package com.messaging.chat_with_.me.services.imp;

import com.messaging.chat_with_.me.models.User;
import com.messaging.chat_with_.me.repository.UserRepository;
import com.messaging.chat_with_.me.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User createUser(String username, String status) {
        User user = new User();
        user.setUsername(username);
        user.setStatus(status);

        return userRepository.save(user);
    }
}
