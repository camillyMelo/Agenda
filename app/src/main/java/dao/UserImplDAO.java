package dao;

import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import model.User;

public class UserImplDAO implements UserDAO{
    private static UserImplDAO instance = null;

    private static List<User> database = new ArrayList<User>();

    public UserImplDAO(){}
    public static UserImplDAO getInstance(){
        if (instance == null){
            instance = new UserImplDAO();
        }
        return instance;
    }
    @Override
    public void userAdd(User user) {
        if(user != null){
            database.add(user);
        }
    }

    @Override
    public User findByUsername(String username) {
        return database.stream()
                .filter(user -> user.getUsername() == username)
                .findAny()
                .orElse(null);
    }

    @Override
    public boolean validateUser(String username, String senha) {
        if (database.isEmpty()){
            return false;
        }else{
            for(User user : database) {
                if (user.getUsername().equals(username) && user.getSenha().equals(senha)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public List<User> findAll() {
        return database;
    }
}
