package org.lesson.dao;


import org.lesson.pojo.Mobile;

import java.util.Collection;
import java.util.Optional;

public interface MobileDao {
  boolean addMobile(Mobile mobile);

  Optional<Mobile> getMobileById(Integer id);

  Collection<Mobile> getAllMobile();
}
