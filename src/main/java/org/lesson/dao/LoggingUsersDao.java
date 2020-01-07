package org.lesson.dao;

import org.lesson.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Optional;

/**
 * @author KhafizovR by 07.01.2020
 * STC20_Sevlets
 */
public class LoggingUsersDao implements UsersDao {
    private static final Logger logger = LoggerFactory.getLogger(UsersDaoJdbcImpl.class);

    private UsersDao usersDao;

    @Inject
    public  LoggingUsersDao(UsersDaoJdbcImpl dao) {
        this.usersDao = dao;
    }
    @Override
    public Optional<User> findUser(String userName, String password) throws SQLException {
        logger.info("UsersDao findUser:" + userName);
        return usersDao.findUser(userName, password);
    }

    @Override
    public Collection<User> getAllUsers() throws SQLException {
        logger.info("UsersDao getAllUsers");
        return usersDao.getAllUsers();
    }
}
