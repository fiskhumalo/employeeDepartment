package com.fiskhumalo.employeeManagement.service;

import com.fiskhumalo.employeeManagement.model.department.EmployeeDepartment;
import com.fiskhumalo.employeeManagement.model.employee.Employee;
import com.fiskhumalo.employeeManagement.model.employee.EmployeeRegistrationRequest;
import com.fiskhumalo.employeeManagement.model.employeeId.EmployeeIdCard;
import com.fiskhumalo.employeeManagement.model.manager.Manager;
import com.fiskhumalo.employeeManagement.model.schedule.Schedule;
import com.fiskhumalo.employeeManagement.repository.employeeRepository.EmployeeRepository;
import com.fiskhumalo.employeeManagement.service.employeeService.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class EmployeeServiceTest {


    private final EmployeeService employeeService;

    @MockBean
    private final EmployeeRepository employeeRepository;

    @Autowired
    EmployeeServiceTest(EmployeeService employeeService, EmployeeRepository employeeRepository) {
        this.employeeService = employeeService;
        this.employeeRepository = employeeRepository;
    }

    @BeforeEach
    void setUp() {
        Employee employee = Employee.builder()
                .Id(1L)
                .name("Dolsk")
                .surname("Khumalo")
                .email("ayanda@fiskhumalo.com")
                .isPermanent(true)
                .age(26)
                .occupation("Manager")
                .salary(new BigDecimal(1000))
                .build();

        Mockito.when(employeeRepository.existsEmployeeByEmail("ayanda@fiskhumalo.com")).thenReturn(!employee.isPermanent());
    }

    @BeforeEach
     void getEmployees() {
        List<Employee> employee =List.of(
                new Employee(
                        "Neli",
                        "Khumalo",
                        "th@fiskhumalo.com",
                        false,
                        45,
                        "Manager",
                        new BigDecimal(2600), EmployeeIdCard.builder()
                        .employeeId(12346577L)
                        .expiryDate(LocalDate.of(2027, Month.JUNE,30))
                        .build()));

Mockito.when(employeeRepository.findAll()).thenReturn(employee);


    }

    @Test
    public void whenEmailNotExists_thenShouldAddEmployee(){
        String email = "dolsk@fiskhumalo.com";
        Employee found = employeeService
                .addNewEmployee(new EmployeeRegistrationRequest(
                        "Dolsk",
                        "Khumalo",
                        email,
                        true,
                        23,
                        "Manager",
                        new BigDecimal(1000), EmployeeIdCard.builder()
                        .employeeId(12346577L)
                        .expiryDate(LocalDate.of(2027, Month.JUNE,30))
                        .build(), Manager.builder()
                        .managerId(1L)
                        .firstName("Tina")
                        .department("Deli").build(),   EmployeeDepartment.builder().build(),
                        Schedule.builder().build()));
        assertEquals(email, found.getEmail());
    }

//    @Test
//    void ItShouldDisplayAllEmployees() {
//        List<Employee> employeeList = List.of(
//                new Employee(
//                        "Neli",
//                        "Khumalo",
//                        "th@fiskhumalo.com",
//                        false,
//                        45,
//                        "Manager",
//                        new BigDecimal(2600)));
//
//
//     List<Employee> employees = employeeService.displayAllEmployees().stream().toList();
//
//
//        assertEquals(employeeList, employees.get(0));
//
//

    }

