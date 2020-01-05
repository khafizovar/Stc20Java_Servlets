package org.lesson.auth;

import org.lesson.pojo.User;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author KhafizovR by 03.01.2020
 * STC20_Sevlets
 */
public class AuthUtils  {

    public static void storeLoginedUser(HttpSession session, User loginedUser) {
        session.setAttribute("loginedUser", loginedUser);
    }

    // помним про Optional, да и в целом тут можно сделать метод, который возвращает boolean
    public static User getLoginedUser(HttpSession session) {
        return (session.getAttribute("loginedUser") != null) ? (User) session.getAttribute("loginedUser") : null;
    }
}
