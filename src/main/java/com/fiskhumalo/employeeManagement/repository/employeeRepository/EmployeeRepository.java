package com.fiskhumalo.employeeManagement.repository.employeeRepository;


import com.fiskhumalo.employeeManagement.model.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    boolean existsEmployeeByEmail(String email);

}
