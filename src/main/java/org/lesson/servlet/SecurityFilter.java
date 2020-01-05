package org.lesson.servlet;

import org.lesson.auth.AuthUtils;
import org.lesson.pojo.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author KhafizovR by 03.01.2020
 * STC20_Sevlets
 */
@WebFilter("/*")
public class SecurityFilter implements Filter{

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        // какой смысл в этом условии?
        if (request.getServletPath().equals("/login")) {
            chain.doFilter(request, response);
            return;
        }

        if (AuthUtils.getLoginedUser(request.getSession()) != null) {
            chain.doFilter(request, response);
            return;
        }
        response.sendRedirect(request.getContextPath() + "/login");
        return;
    }
}
