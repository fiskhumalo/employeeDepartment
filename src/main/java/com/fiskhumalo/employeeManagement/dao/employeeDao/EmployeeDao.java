package com.fiskhumalo.employeeManagement.dao.employeeDao;

import com.fiskhumalo.employeeManagement.model.employee.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeDao{
    List<Employee> getAllEmployees();
    Optional<Employee> getEmployeeById(Long id);


    Employee insertEmployee(Employee employee);
    boolean existsEmployeeWithEmail(String email);


    Employee updateEmployee(Employee employee);
    boolean existsEmployeeWithId(Long id);


    void deleteEmployee(Long employeeId);

    List<Employee> findHighestEarningEmployee();
    List<Employee> findLowestEarningEmployee();

    List<Employee> getTotalOfSalaries();

   Employee increaseSalariesOfEmployees(Employee employee);
}

