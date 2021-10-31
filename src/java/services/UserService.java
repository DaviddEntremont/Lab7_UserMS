package services;

import dataaccess.UserDB;
import java.util.List;
import models.User;

public class UserService {
    
    public User get(String Email) throws Exception {
        UserDB userDB = new UserDB();
        User user = userDB.get(Email);
        return user;
    }
    
    public List<User> getAll() throws Exception {
        UserDB userDB = new UserDB();
        List<User> users = userDB.getAll();
        return users;
    }
    
    public void insert(String Email, Boolean Active, String Firstname, String Lastname, String Password, int Thisrole) throws Exception {
        User user = new User(Email, Active, Firstname, Lastname, Password, Thisrole);
        UserDB userDB = new UserDB();
        userDB.insert(user);
    }
    
    public void update(String Email, Boolean Active, String Firstname, String Lastname, String Password, int Thisrole) throws Exception {
        User user = new User(Email, Active, Firstname, Lastname, Password, Thisrole);
        UserDB userDB = new UserDB();
        userDB.update(user);
    }
    
    public void delete(String Email) throws Exception {
        User user = new User();
        user.setEmail(Email);
        UserDB userDB = new UserDB();
        userDB.delete(user);
    }
}
