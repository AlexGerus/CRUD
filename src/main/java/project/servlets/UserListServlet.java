package project.servlets;

import project.dao.DAOFactory;
import project.dbService.DBService;
import project.module.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/userList")
public class UserListServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBService dbService = null;
        try {
            dbService = new DBService();
            List<User> list = dbService.findAllUsers();
            req.setAttribute("list", list);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/userList.jsp");
        dispatcher.forward(req, resp);
    }
}
