package com.rosacolor.rosacolorback.services.User;

import java.util.List;

import com.rosacolor.rosacolorback.entitys.User;

public interface UserService {
    public List<User> getAllUsers();

    public User getUser(String userId);

    public User saveUser(User user);

    public User updateUser(User user);

    public User deleteUser(String userId);
}
