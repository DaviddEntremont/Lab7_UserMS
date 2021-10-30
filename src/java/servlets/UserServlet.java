package servlets;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import services.UserService;

public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();

        UserService us = new UserService();
        
        String action = request.getParameter("action");
        String email = request.getParameter("email");
        String active = request.getParameter("active");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        Boolean isactive = false;
        
        if (active.equals("true")) {
            isactive = true;
        }
        else if (active.equals("false")) {
            isactive = false;
        }
        else {
            // Improper value
        }
        
        try {
            switch (action) {
                case "create":
                    us.insert(email, isactive, firstname, lastname, password, Integer.parseInt(role));
                    break;
                case "update":
                    us.update(email, isactive, firstname, lastname, password, Integer.parseInt(role));
                    break;
                case "delete":
                    us.delete(email);
            }
            request.setAttribute("message", action);
            } catch (Exception ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("message", "error");
        }
    }

}
