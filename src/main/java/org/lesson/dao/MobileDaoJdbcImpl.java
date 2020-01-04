package org.lesson.dao;

import org.lesson.ConnectionManager.ConnectionManager;
import org.lesson.pojo.Mobile;
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

@EJB
public class MobileDaoJdbcImpl implements MobileDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(MobileDaoJdbcImpl.class);
  public static final String INSERT_INTO_MOBILE = "INSERT INTO mobile values (DEFAULT, ?, ?, ?)";
  public static final String SELECT_FROM_MOBILE = "SELECT * FROM mobile WHERE id = ?";
  public static final String SELECT_ALL_FROM_MOBILE = "SELECT * FROM mobile";


  private ConnectionManager connectionManager;

  @Inject
  public MobileDaoJdbcImpl(ConnectionManager connectionManager) {
    this.connectionManager = connectionManager;
  }

  @Override
  public boolean addMobile(Mobile mobile) {
    try (Connection connection = connectionManager.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_MOBILE)) {
      preparedStatement.setString(1, mobile.getModel());
      preparedStatement.setInt(2, mobile.getPrice());
      preparedStatement.setString(3, mobile.getManufacturer());
      preparedStatement.execute();
    } catch (SQLException e) {
      LOGGER.error("Some thing wrong in addMobile method", e);
      return false;
    }
    return true;
  }

  @Override
  public Mobile getMobileById(Integer id) {
    try (Connection connection = connectionManager.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FROM_MOBILE)) {
      preparedStatement.setInt(1, id);
      try (ResultSet resultSet = preparedStatement.executeQuery()) {
        if (resultSet.next()) {
          return new Mobile(
              resultSet.getInt(1),
              resultSet.getString(2),
              resultSet.getInt(3),
              resultSet.getString(4));
        }
      }
    } catch (SQLException e) {
      LOGGER.error("Some thing wrong in getMobileById method", e);
    }
    return null;
  }

  @Override public Collection<Mobile> getAllMobile() {
    List<Mobile> lstmb = new ArrayList<>();
    try (Connection connection = connectionManager.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_FROM_MOBILE);
        ResultSet resultSet = preparedStatement.executeQuery()) {
      while (resultSet.next()) {
        lstmb.add(new Mobile(
            resultSet.getInt(1),
            resultSet.getString(2),
            resultSet.getInt(3),
            resultSet.getString(4)));
      }
      return lstmb;
    } catch (SQLException e) {
      LOGGER.error("Some thing wrong in getMobileById method", e);
    }
    return new ArrayList<>();
  }
}
