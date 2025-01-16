package com.fiskhumalo.employeeManagement.controller;

import com.fiskhumalo.employeeManagement.model.department.EmployeeDepartment;
import com.fiskhumalo.employeeManagement.model.employee.Employee;
import com.fiskhumalo.employeeManagement.model.employee.EmployeeRegistrationRequest;
import com.fiskhumalo.employeeManagement.model.employeeId.EmployeeIdCard;
import com.fiskhumalo.employeeManagement.model.manager.Manager;
import com.fiskhumalo.employeeManagement.model.schedule.Schedule;
import com.fiskhumalo.employeeManagement.service.employeeService.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import org.springframework.test.web.servlet.MockMvc;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//
//
//@AutoConfigureMockMvc
//@SpringBootTest

//class EmployeeControllerTest {
//
//
//
//
//   @MockBean
//    private  EmployeeService employeeService;
//    private Employee employee;
//    private final MockMvc mockMvc;
//
//
//    @Autowired
//    EmployeeControllerTest( MockMvc mockMvc) {
//
//        this.mockMvc = mockMvc;
//    }
//
//
//    @BeforeEach
//    void setUp() {
//  employee = Employee.builder()
//                .Id(1L)
//                .name("Thoko")
//                .surname("Sibanda")
//                .email("thok@fiskhumalo.com")
//                .isPermanent(true)
//                .age(34)
//                .occupation("Deli")
//                .salary(new BigDecimal(8800))
//                .build();
//    }
//
//    @Test
//    void getEmployees() {
//    }
//
//    @Test
//    void getEmployeeById() throws Exception {
//
//        Mockito.when(employeeService.getEmployeeById(1L))
//                .thenReturn(employee);
//
//        mockMvc.perform(get("http://localhost:8080/api/v1/employees/1")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.name")
//                        .value(employee.getName()));
//
//    }
//
//    @Test
//    void addEmployee() throws Exception {
//
//            EmployeeRegistrationRequest inputEmployee = new EmployeeRegistrationRequest(
//
//                    "Thoko",
//                    "Sibanda",
//                    "thok@fiskhumalo.com",
//                    true,
//                    34,
//                    "Deli",
//                    new BigDecimal(8800),
//                    EmployeeIdCard.builder()
//                            .employeeId(1L)
//                            .expiryDate(LocalDate.of(2027, Month.JUNE,30))
//                            .build(), Manager.builder()
//                    .managerId(1L)
//                    .firstName("Tina")
//                    .department("Deli").build(),
//                    EmployeeDepartment.builder().build(),
//                    Schedule.builder().build());
//
//            Mockito.when(employeeService.addNewEmployee(inputEmployee)).thenReturn(employee);
//            mockMvc.perform(post("http://localhost:8080/api/v1/employees")
//                    .contentType(MediaType.APPLICATION_JSON).content(
//                        "  {\n" +
//                                "        \"name\": \"Thoko\",\n" +
//                                "        \"surname\": \"Sibanda\",\n" +
//                                "        \"email\": \"thok@fiskhumalo.com\",\n" +
//                                "        \"age\": 34,\n" +
//                                "        \"occupation\": \"Deli\",\n" +
//                                "        \"salary\": 8800,\n" +
//                                "        \"employeeId\": null,\n" +
//                                "        \"id\": 1,\n" +
//                                "        \"permanent\": true\n" +
//
//                                "    }"
//                    )).andExpect(status().isOk());
//
//
//
//
//        }
//
//
//
//    @Test
//    void updateEmployees() {
//    }
//
//    @Test
//    void removeEmployeeById() {
//    }
//
//    @Test
//    void getMostPaidEmployee() {
//    }
//
//    @Test
//    void getLowestPaidEmployee() {
//    }
//
//    @Test
//    void getTotalOfSalaries() {
//    }
//
//    @Test
//    void incrementSalary() {
//    }
//}