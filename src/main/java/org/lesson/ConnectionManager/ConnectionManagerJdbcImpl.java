package org.lesson.ConnectionManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@EJB
public class ConnectionManagerJdbcImpl implements ConnectionManager {
  private static final Logger LOGGER = LoggerFactory.getLogger(ConnectionManagerJdbcImpl.class);
  private static ConnectionManager connectionManager;

  private ConnectionManagerJdbcImpl() {
  }

  public static ConnectionManager getInstance() {
    if (connectionManager == null) {
      connectionManager = new ConnectionManagerJdbcImpl();
    }
    return connectionManager;
  }

  @Override
  public Connection getConnection() {
    Connection connection = null;
    try {
      Class.forName("org.postgresql.Driver");
      connection = DriverManager.getConnection(
          /*"jdbc:postgresql://host.docker.internal:5433/mobile",*/
              "jdbc:postgresql://localhost:5432/mobile",
          "postgres",
          "123qwe");
    } catch (ClassNotFoundException | SQLException e) {
      LOGGER.error("Some thing wrong in getConnection method", e);
    }
    return connection;
  }
}
