package org.lesson.dao;

import org.apache.commons.codec.digest.DigestUtils;
import org.lesson.ConnectionManager.ConnectionManager;
import org.lesson.pojo.Mobile;
import org.lesson.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.inject.Inject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;


/**
 * @author KhafizovR by 03.01.2020
 * STC20_Sevlets
 */
@EJB
public class UsersDaoJdbcImpl implements UsersDao {

    private static final Logger logger = LoggerFactory.getLogger(UsersDaoJdbcImpl.class);
    public static final String SELECT_FROM_PUBLIC_USERS_WHERE_USERNAME_AND_PASSWORD = "SELECT * FROM public.\"users\" WHERE username = ? AND password = ?";

    private ConnectionManager connectionManager;

    @Inject
    public UsersDaoJdbcImpl(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    public Optional<User> findUser(String userName, String password) throws SQLException {

        try (Connection connection = this.connectionManager.getConnection();) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    SELECT_FROM_PUBLIC_USERS_WHERE_USERNAME_AND_PASSWORD);
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
        }
        return Optional.empty();
    }

    @Override public Collection<User> getAllUsers() throws SQLException {
        List<User> lstusrs = new ArrayList<>();
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM public.\"users\"");
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                lstusrs.add(new User(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4)));
            }
            return lstusrs;
        }
    }
}
