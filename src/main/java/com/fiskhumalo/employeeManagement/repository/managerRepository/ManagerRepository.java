package com.fiskhumalo.employeeManagement.repository.managerRepository;

import com.fiskhumalo.employeeManagement.model.manager.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager, Long> {

}
