package org.lesson.servlet;

import org.lesson.dao.UsersDao;
import org.lesson.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

/**
 * @author KhafizovR by 04.01.2020
 * STC20_Sevlets
 */
@WebServlet(urlPatterns = "/allusers")
public class AllUsersServlet extends HttpServlet {

    private Logger logger = LoggerFactory.getLogger(AllUsersServlet.class);

    @Inject
    private UsersDao usersDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Collection<User> users = null;
        try {
            users = usersDao.getAllUsers();
        } catch (SQLException e) {
            logger.error("AllUsersServlet doGet", e);
            throw new ServletException(e);
        }
        req.setAttribute("users", users);
        req.setAttribute("PageTitle", "Users");
        req.setAttribute("PageBody", "allusers.jsp");
        req.getRequestDispatcher("/layout.jsp")
                .forward(req, resp);
    }
}
