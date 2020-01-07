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
import java.sql.SQLException;

@WebServlet("/addmobile")
public class AddMobileServlet extends HttpServlet {

    private Logger logger = LoggerFactory.getLogger(AddMobileServlet.class);

    @Inject
    private MobileDao mobileDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("PageTitle", "New Mobiles");
        req.setAttribute("PageBody", "form.jsp");
        req.getRequestDispatcher("/layout.jsp")
            .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setCharacterEncoding("utf-8");
        String model = req.getParameter("model");
        String price = req.getParameter("price");
        String manufacturer = req.getParameter("manufacturer");
        Mobile mobile = new Mobile(null, model, Integer.valueOf(price), manufacturer);
        try {
            mobileDao.addMobile(mobile);
        } catch (SQLException e) {
            logger.error("AddMobileServlet doGet", e);
            throw new ServletException(e);
        }

        resp.sendRedirect(req.getContextPath() + "/allmobiles");
    }
}
