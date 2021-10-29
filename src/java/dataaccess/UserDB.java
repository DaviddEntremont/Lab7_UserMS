package dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Role;
import models.User;

public class UserDB {
    public List<User> getAll() throws Exception {
        List<User> list = new ArrayList<>();
        
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = "SELECT * FROM user";
        
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String Email = rs.getString(1);
                Boolean Active = rs.getBoolean(2);
                String Firstname = rs.getString(3);
                String Lastname = rs.getString(4);
                String Password = rs.getString(5);
                int RoleNumber = rs.getInt(6);
                Role role = new Role(RoleNumber);
                User user = new User(Email, Active, Firstname, Lastname, Password, role);
                list.add(user);
            }
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
        
        return list;
       
    }
    
    
    public User get(String email) throws Exception {
        User user = null;
    
        return user;
    }
    
    public void insert(User user) throws Exception {
        
    }
    
    public void update(User user) throws Exception {
        
    }
    
    public void delete (User user) throws Exception {
        
    }
    
    
}
