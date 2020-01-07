package org.lesson.dao;


import org.lesson.pojo.Mobile;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Optional;

public interface MobileDao {
  boolean addMobile(Mobile mobile) throws SQLException;

  Optional<Mobile> getMobileById(Integer id) throws SQLException;

  Collection<Mobile> getAllMobile() throws SQLException;
}
