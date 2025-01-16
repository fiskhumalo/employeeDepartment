package com.fiskhumalo.employeeManagement.model.employee;

import com.fiskhumalo.employeeManagement.model.department.EmployeeDepartment;
import com.fiskhumalo.employeeManagement.model.employeeId.EmployeeIdCard;
import com.fiskhumalo.employeeManagement.model.manager.Manager;
import com.fiskhumalo.employeeManagement.model.schedule.Schedule;

import java.math.BigDecimal;


public record EmployeeRegistrationRequest(

        String name,
        String surname,
        String email,
        boolean isPermanent,
        int age,
        String occupation,
        BigDecimal salary,
        EmployeeIdCard employeeId,
        Manager manager,
        EmployeeDepartment employeeDepartment,
        Schedule schedules


) {

}
