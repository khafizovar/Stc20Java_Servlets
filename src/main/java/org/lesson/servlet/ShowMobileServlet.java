package org.lesson.servlet;

import org.lesson.dao.MobileDao;
import org.lesson.pojo.Mobile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.annotation.Inherited;
import java.sql.SQLException;
import java.util.Optional;

@WebServlet("/showmobile")
public class ShowMobileServlet extends HttpServlet {

    private Logger logger = LoggerFactory.getLogger(AppContextListener.class);
    @Inject
    private MobileDao mobileDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mobileId = req.getParameter("id");
        if (mobileId == null) {
            throw new ServletException("Missing parameter id");
        }
        Optional<Mobile> mobile = null;
        try {
            mobile = mobileDao.getMobileById(Integer.valueOf(mobileId));
        } catch (SQLException e) {
            logger.error("ShowMobileServlet doGet", e);
            throw new ServletException(e);
        }
        if (!mobile.isPresent()) {
            resp.setStatus(404);
            req.getRequestDispatcher("/notfound.jsp").forward(req, resp);
            return;
        }
        req.setAttribute("mobile", mobile.get());
        req.getRequestDispatcher("/showmobile.jsp").forward(req, resp);
    }
}
