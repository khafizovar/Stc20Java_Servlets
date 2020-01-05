package org.lesson.auth;

import org.lesson.pojo.User;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author KhafizovR by 03.01.2020
 * STC20_Sevlets
 */
public class AuthUtils  {

    public static void storeLoginedUser(HttpSession session, User loginedUser) {
        session.setAttribute("loginedUser", loginedUser);
    }

    public static Optional<User> getLoginedUser(HttpSession session) {
        return (session.getAttribute("loginedUser") != null) ? Optional.of((User) session.getAttribute("loginedUser")) : Optional.empty();
    }
}
