package org.lesson.dao;

import jdk.nashorn.internal.runtime.options.Option;
import org.apache.commons.codec.digest.DigestUtils;
import org.lesson.ConnectionManager.ConnectionManager;
import org.lesson.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.inject.Inject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;


/**
 * @author KhafizovR by 03.01.2020
 * STC20_Sevlets
 */
@EJB
public class UsersDao {

    private static final Logger logger = LoggerFactory.getLogger(UsersDao.class);

    private ConnectionManager connectionManager;

    @Inject
    public UsersDao(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    public Optional<User> findUser(String userName, String password) {

        try (Connection connection = this.connectionManager.getConnection();) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM public.\"users\" WHERE username = ? AND password = ?");
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, DigestUtils.md5Hex(password));
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(new User(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4)));
            }
        } catch (SQLException e) {
            logger.error("Error in UsersDao.findUser: " + userName , e);
        }
        return Optional.empty();
    }
}
