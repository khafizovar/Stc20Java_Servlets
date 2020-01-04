package org.lesson.servlet;

import org.lesson.dao.MobileDao;
import org.lesson.dao.UsersDao;
import org.lesson.pojo.Mobile;
import org.lesson.pojo.User;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

/**
 * @author KhafizovR by 04.01.2020
 * STC20_Sevlets
 */
@WebServlet(urlPatterns = "/allusers")
public class AllUsersServlet extends HttpServlet {

    @Inject
    private UsersDao usersDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Collection<User> users = usersDao.getAllUsers();
        req.setAttribute("users", users);
        req.setAttribute("PageTitle", "Users");
        req.setAttribute("PageBody", "allusers.jsp");
        req.getRequestDispatcher("/layout.jsp")
                .forward(req, resp);
    }
}
