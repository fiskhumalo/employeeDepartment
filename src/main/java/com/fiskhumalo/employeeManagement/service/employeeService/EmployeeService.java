package com.fiskhumalo.employeeManagement.service.employeeService;

import com.fiskhumalo.employeeManagement.dao.employeeDao.EmployeeDao;


import com.fiskhumalo.employeeManagement.exception.EmailValidationReportException;

import com.fiskhumalo.employeeManagement.exception.IdVerificationResponse;
import com.fiskhumalo.employeeManagement.exception.RegistrationValidationException;
import com.fiskhumalo.employeeManagement.exception.ResourceNotFoundException;
import com.fiskhumalo.employeeManagement.model.employee.Employee;
import com.fiskhumalo.employeeManagement.model.employee.EmployeeRegistrationRequest;
import com.fiskhumalo.employeeManagement.model.employee.EmployeeUpdateRequest;
import com.fiskhumalo.employeeManagement.model.schedule.Schedule;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeDao employeeDao;

    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public List<Employee> displayAllEmployees() {
        return employeeDao.getAllEmployees();

    }

    public Employee getEmployeeById(Long id) {
        return employeeDao.getEmployeeById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException("employee with id %s not found".formatted(id)));

    }

    public Employee addNewEmployee(EmployeeRegistrationRequest registrationRequest) {
        String email = registrationRequest.email();
        if (employeeDao.existsEmployeeWithEmail(email)) {
            throw new EmailValidationReportException("email already used");

        }
        Employee employee = new Employee(
                registrationRequest.name(),
                registrationRequest.surname(),
                registrationRequest.email(),
                registrationRequest.isPermanent(),
                registrationRequest.age(),
                registrationRequest.occupation(),
                registrationRequest.salary(),
                registrationRequest.employeeId(),
                registrationRequest.manager(),
                registrationRequest.schedules()
        );

//        if (!employee.isPermanent()) {
//            throw new RegistrationValidationException("Sorry we are registering only permanent employees");
//        }

       return employeeDao.insertEmployee(employee);

    }


    public Employee updateEmployee(Long EmployeeId, EmployeeUpdateRequest employeeUpdate) {

        Employee employees = getEmployeeById(EmployeeId);
        boolean update = false;
//
//        if (employeeUpdate.id() != 0 && !employeeUpdate.id().equals(employees.getId())) {
////            if (employeeDao.existsEmployeeWithId(employeeUpdate.id())) {
////                throw new IdVerificationResponse("id %s in use".formatted(employeeUpdate.id()));
////            }
//            employees.setId(employeeUpdate.id());
//            update = true;
//        }


        if (employeeUpdate.name() != null && !employeeUpdate.name().equals(employees.getName())) {
            employees.setName(employeeUpdate.name());
            update = true;
        }

        if (employeeUpdate.surname() != null && !employeeUpdate.surname().equals(employees.getSurname())) {
            employees.setSurname(employeeUpdate.surname());
            update = true;

        }
        if (employeeUpdate.email() != null && !employeeUpdate.email().equals(employees.getEmail())) {
            if (employeeDao.existsEmployeeWithEmail(employeeUpdate.email())) {
                throw new EmailValidationReportException("email is in use");
            }
            employees.setEmail(employeeUpdate.email());
            update = true;
        }

        if (!employeeUpdate.isPermanent()) {
            employees.setPermanent(true);
            update = true;
        }
        if (employeeUpdate.age() >= 0) {
            employees.setAge(employeeUpdate.age());
            update = true;

        }
        if (employeeUpdate.salary() != null && !employeeUpdate.salary().equals(employees.getSalary())) {
            employees.setSalary(employeeUpdate.salary());
            update = true;
        }

        if (employeeUpdate.occupation() != null && !employeeUpdate.occupation().equals(employees.getOccupation())) {
            employees.setOccupation(employeeUpdate.occupation());
            update = true;
            System.out.println("Update status: " + update);

        }

        if (!update) {
            throw new RegistrationValidationException("no updates were made");

        }
       return employeeDao.updateEmployee(employees);

    }

    public void deleteEmployeeById(Long employeeId) {
        if (!employeeDao.existsEmployeeWithId(employeeId)){
            throw new IdVerificationResponse("no employee with such id found");
        }
        employeeDao.deleteEmployee(employeeId);
    }

    public Optional<Employee> getMostPaidEmployee() {
        if (employeeDao == null){
            throw new ResourceNotFoundException("No such Employee found");
        }
        return employeeDao.findHighestEarningEmployee()
                .stream()
                .max(Comparator.comparing(Employee::getSalary));
    }

    public Optional<Employee> getLowestPaidEmployee(){
        if (employeeDao == null){
            throw new ResourceNotFoundException("No employee found");
        }
     return employeeDao.findLowestEarningEmployee()
              .stream()
              .min(Comparator.comparing(Employee::getSalary));
    }

    public double getTotalOfAllSalaries(){
        return employeeDao.getTotalOfSalaries()
                .stream()
                .map(Employee::getSalary)
                .mapToDouble(BigDecimal::doubleValue)
                .sum();
       }

       public Employee increaseSalaries(Employee employee) {
        boolean change = false;
      if(!Objects.equals(employee.getSalary(), new BigDecimal(2500).add(new BigDecimal(1500)))){
          change = true;
          System.out.println("salary changed");
      }



           if (!change){
               throw new IllegalArgumentException("salary not changed");
           }

           return employeeDao.increaseSalariesOfEmployees(employee);
       }
    }







