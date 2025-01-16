package com.fiskhumalo.employeeManagement.dao.employeeCardDao;

import com.fiskhumalo.employeeManagement.model.employeeId.EmployeeIdCard;


import java.util.List;

public interface EmployeeIdCardDao {
    List<EmployeeIdCard>  getAllAvailableCards();
     void addIdCard();



}
