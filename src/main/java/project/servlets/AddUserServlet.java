package project.servlets;

import project.dao.DAOFactory;
import project.dbService.DBService;
import project.module.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/addUser")
public class AddUserServlet extends HttpServlet{


    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String role = req.getParameter("role");
        DBService dbService = new DBService();
        User user = new User(name, age, role, login, password);
        dbService.saveUser(user);
        resp.sendRedirect("/userList");
    }
}
