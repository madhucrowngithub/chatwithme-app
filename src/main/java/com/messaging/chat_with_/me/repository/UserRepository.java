package com.messaging.chat_with_.me.repository;

import com.messaging.chat_with_.me.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends MongoRepository<User, String> {

}
