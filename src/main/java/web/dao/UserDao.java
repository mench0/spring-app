package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {

    void save(User user);
    User get(Long id);
    void update(User user);
    void delete(Long id);
    List<User> getAllUsers();
}
