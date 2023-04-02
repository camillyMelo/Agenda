package dao;

import java.util.List;

import model.User;

public interface UserDAO {

    void userAdd(User user);

    User findByUsername(String username);

    boolean validateUser(String username, String senha);

    List<User> findAll();
}
