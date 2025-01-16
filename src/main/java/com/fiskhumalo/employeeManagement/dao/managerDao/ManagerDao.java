package com.fiskhumalo.employeeManagement.dao.managerDao;

import com.fiskhumalo.employeeManagement.model.manager.Manager;

import java.util.List;

public interface ManagerDao {
  List<Manager> printAllManagers();
 Manager insertManager(Manager manager);
  boolean existsManagerWithEmail(String email);


  Manager updateManager(Manager manager);
  boolean existsManagerWithId(Long id);


  void deleteManager(Long managerId);

}
