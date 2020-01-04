package org.lesson.dao;


import org.lesson.pojo.Mobile;

import java.util.Collection;

public interface MobileDao {
  boolean addMobile(Mobile mobile);

  Mobile getMobileById(Integer id);

  Collection<Mobile> getAllMobile();
}
