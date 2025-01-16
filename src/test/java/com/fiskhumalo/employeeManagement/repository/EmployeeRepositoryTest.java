package com.fiskhumalo.employeeManagement.repository;

import com.fiskhumalo.employeeManagement.model.employee.Employee;
import com.fiskhumalo.employeeManagement.repository.employeeRepository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class EmployeeRepositoryTest {

    private final EmployeeRepository employeeRepository;

    @MockBean
    private final TestEntityManager testEntityManager;

    @Autowired
    EmployeeRepositoryTest(EmployeeRepository employeeRepository, TestEntityManager testEntityManager) {
        this.employeeRepository = employeeRepository;
        this.testEntityManager = testEntityManager;
    }
    @BeforeEach
    void setUp() {
        Employee employee = Employee.builder()
                .name("Magret")
                .surname("Nyoni")
                .email("dolsk@fiskhumalo.com")
                .isPermanent(true)
                .age(45)
                .occupation("waiters")
                .salary( new BigDecimal(2500))
                .build();
        testEntityManager.persist(employee);
    }
    @Test
    void ifExistsEmployeeByEmail_thenReturnEmployee() {
     boolean employee = employeeRepository.existsEmployeeByEmail("mag@fiskhumalo.com");
        assertTrue(employee);
        System.out.println("emailExists");



    }
}