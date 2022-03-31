package com.rosacolor.rosacolorback.repository;

import java.util.List;

import com.rosacolor.rosacolorback.entitys.User;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    // List<User> findUsersByDeleted
    List<User> findUsersByDeleted(boolean deleted);

    List<User> findUserByDeleted(boolean deleted);
}
