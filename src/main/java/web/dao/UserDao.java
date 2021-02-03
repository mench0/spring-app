package web.dao;

import web.model.User;

public interface UserDao {

    void save(User user);
    User get(Long id);
    void update(Long id, User user);
    void delete(Long id);
}
