package org.lesson.dao;

import org.lesson.pojo.User;

import java.util.Optional;

/**
 * @author KhafizovR by 04.01.2020
 * STC20_Sevlets
 */
public interface UsersDao {
    Optional<User> findUser(String userName, String password);
}
