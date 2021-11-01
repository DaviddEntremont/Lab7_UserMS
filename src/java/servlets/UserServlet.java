package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.UserService;
import services.RoleService;
import models.User;
import models.Role;

public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        UserService us = new UserService();        
        
        try {
            List<User> users = us.getAll();    
            request.setAttribute("users", users);
        } catch (Exception ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("message", "error");
        }
        
        String selected = request.getParameter("selected");
        if (selected != null) {
            try {
                User user = us.get(selected);
                request.setAttribute("selecteduser", user);
                request.setAttribute("selected", null);
                request.setAttribute("message", "selected");
                request.setAttribute("userfullname", user.getFirstname() + " " + user.getLastname());
            } catch (Exception ex) {
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
                request.setAttribute("message", "error");
            }
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
     
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UserService us = new UserService();
        
        String action = request.getParameter("action");
        
        
        String email = request.getParameter("email");
        String active = request.getParameter("active");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String password = request.getParameter("password");
        String Rolename = request.getParameter("role");
        Role role = new Role();
        if (!action.equals("delete")) {
        RoleService roleservice = new RoleService();
        List<Role> roles = new ArrayList();
        try {
            roles = roleservice.getAll();
        } catch (Exception ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
                role = new Role(Rolename);
                for (int i = 0; i < roles.size(); i++) {
                    if (role.getRolename().equals(roles.get(i).getRolename())) {
                        role.setRoleid(roles.get(i).getRoleid());
                    } else {
                    }
                }
        }
        String selectedemail = request.getParameter("useremail");
        request.setAttribute("userfullname", firstname + " " + lastname);
           
        try {
            switch (action) {
                case "create":
                    us.insert(email, Integer.parseInt(active), firstname, lastname, password, role);
                    break;
                case "update":
                    us.update(selectedemail, 1, firstname, lastname, password, role);
                    break;
                case "delete":
                    us.delete(selectedemail);
                    break;
            }
            request.setAttribute("message", action);
        }
            catch (Exception ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("message", "error");
                    }
        
        try {
            List<User> users = us.getAll();
            request.setAttribute("users", users);
        } catch (Exception ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("message", "error");
        }

        getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
    }

}