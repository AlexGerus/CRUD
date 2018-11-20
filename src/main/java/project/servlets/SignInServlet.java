package project.servlets;

import project.dbService.DBService;
import project.module.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/signin")
public class SignInServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        HttpSession session = req.getSession();
        DBService dbService = null;
        try {
            dbService = new DBService();
            User user = dbService.getUserByLogin(login);
            if (login != null && password != null && user.getPassword().equals(password)){
                if (user.getRole().equals("User")){
                    session.setAttribute("userName", user.getName());
                    session.setAttribute("userAge", user.getAge());
                    session.setAttribute("userId", user.getId());
                    session.setAttribute("userRole", user.getRole());
                    resp.sendRedirect("pageForUsers.jsp");
                    return;
                }
                if(user.getRole().equals("Admin")){
                    session.setAttribute("userRole", user.getRole());
                    resp.sendRedirect("/userList");
                }
                else{
                    resp.sendRedirect("index.jsp");
                }
            }
            else{
                resp.sendRedirect("index.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
