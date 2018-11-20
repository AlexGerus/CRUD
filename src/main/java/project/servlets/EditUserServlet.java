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
        String rolechange = req.getParameter("rolechange");
        String loginchange = req.getParameter("loginchange");
        String passwordchange = req.getParameter("passwordchange");
        req.setAttribute("idchange", idchange);
        req.setAttribute("namechange", namechange);
        req.setAttribute("agechange", agechange);
        req.setAttribute("rolechange", rolechange);
        req.setAttribute("loginchange", loginchange);
        req.setAttribute("passwordchange", passwordchange);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/editUser.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long idchange = Long.valueOf(req.getParameter("idchange"));
        String namechange = req.getParameter("namechange");
        int agechange = Integer.parseInt(req.getParameter("agechange"));
        String rolechange = req.getParameter("rolechange");
        String loginchange = req.getParameter("loginchange");
        String passwordchange = req.getParameter("passwordchange");
        DBService dbService = new DBService();
        User user = new User(idchange, namechange, agechange, rolechange, loginchange, passwordchange);
        dbService.updateUser(user);
        resp.sendRedirect("/userList");

    }
}
