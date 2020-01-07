package org.lesson.dao;

import org.lesson.pojo.User;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Optional;

/**
 * @author KhafizovR by 04.01.2020
 * STC20_Sevlets
 */
public interface UsersDao {
    Optional<User> findUser(String userName, String password) throws SQLException;

    Collection<User> getAllUsers() throws SQLException;
}
