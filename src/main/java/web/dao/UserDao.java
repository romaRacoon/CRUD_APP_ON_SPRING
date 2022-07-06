package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);
    void delete(int id);
    void edit(User user);
    List<User> getAllUsers();
    User getUserById(int id);
}
