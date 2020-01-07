package org.lesson.servlet;


import org.lesson.auth.AuthUtils;
import org.lesson.dao.LoggingUsersDao;
import org.lesson.dao.UsersDaoJdbcImpl;
import org.lesson.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.sql.SQLException;
import java.util.Optional;
import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * @author KhafizovR by 03.01.2020
 * STC20_Sevlets
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private Logger logger = LoggerFactory.getLogger(LoginServlet.class);

    @Inject
    private LoggingUsersDao loggingUsersDao;

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher //
                = this.getServletContext().getRequestDispatcher("/loginView.jsp");

        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        Optional<User> userAccount = null;
        try {
            userAccount = loggingUsersDao.findUser(userName, password);
        } catch (SQLException e) {
            logger.error("LoginServlet doGet", e);
            throw new ServletException(e);
        }

        if (!userAccount.isPresent()) {
            String errorMessage = "Неправильное имя пользователя или пароль";

            request.setAttribute("errorMessage", errorMessage);

            RequestDispatcher dispatcher //
                    = this.getServletContext().getRequestDispatcher("/loginView.jsp");

            dispatcher.forward(request, response);
            return;
        }

        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/");
        dispatcher.forward(request, response);
        AuthUtils.storeLoginedUser(request.getSession(), userAccount.get());
    }
}