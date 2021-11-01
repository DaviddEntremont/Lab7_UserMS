package services;

import dataaccess.UserDB;
import java.util.List;
import models.Role;
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
    
    public void insert(String Email, int Active, String Firstname, String Lastname, String Password, Role Role) throws Exception {
        User user = new User(Email, Active, Firstname, Lastname, Password, Role);
        UserDB userDB = new UserDB();
        userDB.insert(user);
    }
    
    public void update(String Email, int Active, String Firstname, String Lastname, String Password, Role Role) throws Exception {
        User user = new User(Email, Active, Firstname, Lastname, Password, Role);
        UserDB userDB = new UserDB();
        userDB.update(user);
    }
    
    public void delete(String Email) throws Exception {
        User user = get(Email);
        UserDB userDB = new UserDB();
        userDB.delete(user);
    }
}
