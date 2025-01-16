package com.fiskhumalo.employeeManagement.repository;


import com.fiskhumalo.employeeManagement.model.manager.Manager;
import com.fiskhumalo.employeeManagement.repository.managerRepository.ManagerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
public class ManagerTest {

    private final ManagerRepository managerRepository;


    @Autowired
    public ManagerTest(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }


    @Test
        public void saveManager(){

        Manager manager = Manager.builder()
                .managerId(23L)
                .firstName("Dolsk")
                .department("Project Manager")
                .build();

        managerRepository.save(manager);
    }}




