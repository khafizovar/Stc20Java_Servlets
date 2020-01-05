package org.lesson.ConnectionManager;

import java.sql.Connection;

public interface ConnectionManager {
  Connection getConnection();
  // что-то дебажили? :)
  int get15();
}
