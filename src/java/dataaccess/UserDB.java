package dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Role;
import models.User;
import services.RoleService;

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
                int Active = rs.getInt(2);
                String Firstname = rs.getString(3);
                String Lastname = rs.getString(4);
                String Password = rs.getString(5);
                int RoleNumber = rs.getInt(6);
                RoleService roleservice = new RoleService();
                List<Role> roles = roleservice.getAll();
                Role role = new Role(RoleNumber);
                for (int i = 0; i < roles.size(); i++) {
                    if (role.getRoleid() == roles.get(i).getRoleid()) {
                        role.setRolename(roles.get(i).getRolename());
                    }
                }
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
    
    public User get(String Email) throws Exception {
        User user = null;
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM user WHERE email=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, Email);
            rs = ps.executeQuery();
            if (rs.next()) {
                int Active = rs.getInt(2);
                String Firstname = rs.getString(3);
                String Lastname = rs.getString(4);
                String Password = rs.getString(5);
                int RoleNumber = rs.getInt(6);
                RoleService roleservice = new RoleService();
                List<Role> roles = roleservice.getAll();
                Role role = new Role(RoleNumber);
                for (int i = 0; i < roles.size(); i++) {
                    if (role.getRoleid() == roles.get(i).getRoleid()) {
                        role.setRolename(roles.get(i).getRolename());
                    }
                }
                user = new User(Email, Active, Firstname, Lastname, Password, role);
            }
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
        
        return user;
    }
    
    public void insert(User user) throws Exception {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        String sql = "INSERT INTO user (email, active, first_name, last_name, password, role) VALUES (?, ?, ?, ?, ?, ?)";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getEmail());
            ps.setInt(2, user.isActive());
            ps.setString(3, user.getFirstname());
            ps.setString(4, user.getLastname());
            ps.setString(5, user.getPassword());
            ps.setInt(6, user.getRole().getRoleid());
            ps.executeUpdate();
        } finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
    }
    
    public void update(User user) throws Exception {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        String sql = "UPDATE user SET active=?, first_name=?, last_name=?, password=?, role=? WHERE email=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, user.isActive());
            ps.setString(2, user.getFirstname());
            ps.setString(3, user.getLastname());
            ps.setString(4, user.getPassword());
            ps.setInt(5, user.getRole().getRoleid());
            ps.setString(6, user.getEmail());
            ps.executeUpdate();
        } finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
    }
    
    public void delete (User user) throws Exception {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        String sql = "DELETE FROM user WHERE email=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getEmail());
            ps.executeUpdate();
        } finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
    }
}
