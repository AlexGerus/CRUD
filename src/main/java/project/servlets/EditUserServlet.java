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

@WebServlet("/editUser")
public class EditUserServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long idchange = Long.parseLong(req.getParameter("idchange"));
        String namechange = req.getParameter("namechange");
        int agechange = Integer.parseInt(req.getParameter("agechange"));
        req.setAttribute("idchange", idchange);
        req.setAttribute("namechange", namechange);
        req.setAttribute("agechange", agechange);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/editUser.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long idchange = Long.valueOf(req.getParameter("idchange"));
        String namechange = req.getParameter("namechange");
        int agechange = Integer.parseInt(req.getParameter("agechange"));
        DBService dbService = null;
        try {
            dbService = new DBService();
            User user = new User(idchange, namechange, agechange);
            dbService.updateUser(user);
        }catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/userList");

    }
}
