package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    void saveUser(User user);
    User getUser(Long id);
    void updateUser(Long id, User user);
    void deleteUser(Long id);
}
