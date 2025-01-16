package com.fiskhumalo.employeeManagement.service.employeeService;

import com.fiskhumalo.employeeManagement.dao.employeeDao.EmployeeDao;
import com.fiskhumalo.employeeManagement.model.employee.Employee;
import com.fiskhumalo.employeeManagement.repository.employeeRepository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Slf4j
public class EmployeeJPAAccessService implements EmployeeDao {

    private final EmployeeRepository employeeRepository;

    public EmployeeJPAAccessService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        log.info("displaying all employees");
        return employeeRepository.findAll();
    }



    @Override
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Employee insertEmployee(Employee employee) {
     employeeRepository.save(employee);
        return employee;
    }

    @Override
    public boolean existsEmployeeWithEmail(String email) {
        return employeeRepository.existsEmployeeByEmail(email);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        employeeRepository.save(employee);
        return employee;
    }

    @Override
    public boolean existsEmployeeWithId(Long id) {
        return employeeRepository.existsById(id);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        employeeRepository.deleteById(employeeId);

    }

    public List<Employee> findHighestEarningEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> findLowestEarningEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> getTotalOfSalaries() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee increaseSalariesOfEmployees(Employee increase) {
        return employeeRepository.save(increase);
    }
}
