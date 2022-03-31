package com.rosacolor.rosacolorback.services.User;

import java.util.List;
import java.util.Objects;

import com.rosacolor.rosacolorback.entitys.User;
import com.rosacolor.rosacolorback.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    public UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        // return userRepository.findAll();
        return userRepository.findUsersByDeleted(false);
    }

    @Override
    public User getUser(String userId) {
        return userRepository.findById(userId).get();
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        User newUser = userRepository.findById(user.getId()).get();

        // First name
        if (Objects.nonNull(user.getFirstName()) && !"".equals(user.getFirstName())) {
            newUser.setFirstName(user.getFirstName());
        }

        // Last name
        if (Objects.nonNull(user.getLastName()) && !"".equals(user.getLastName())) {
            newUser.setLastName(user.getLastName());
        }

        // Email
        if (Objects.nonNull(user.getEmail()) && !"".equals(user.getEmail())) {
            newUser.setEmail(user.getEmail());
        }

        // Password
        if (Objects.nonNull(user.getPassword()) && !"".equals(user.getPassword())) {
            newUser.setPassword(user.getPassword());
        }

        // Deleted
        if (Objects.nonNull(user.getDeleted()) && !"".equals(user.getDeleted())) {
            newUser.setDeleted(user.getDeleted());
        }

        return userRepository.save(newUser);
    }

    @Override
    public User deleteUser(String userId) {
        User deletedUser = userRepository.findById(userId).get();

        // Deleted
        deletedUser.setDeleted(true);

        return userRepository.save(deletedUser);
    }

}
