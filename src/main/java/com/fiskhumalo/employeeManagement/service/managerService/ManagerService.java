package com.fiskhumalo.employeeManagement.service.managerService;

import com.fiskhumalo.employeeManagement.dao.managerDao.ManagerDao;
import com.fiskhumalo.employeeManagement.exception.RegistrationValidationException;
import com.fiskhumalo.employeeManagement.model.manager.Manager;
import com.fiskhumalo.employeeManagement.model.manager.ManagerRegistration;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerService {

    private final ManagerDao managerDao;

    public ManagerService(ManagerDao managerDao) {
        this.managerDao = managerDao;
    }

    public List<Manager> getAllManagers(){
        return managerDao.printAllManagers();
    }

    public Manager saveNewManager(ManagerRegistration managerRegistration){

        Long id = managerRegistration.managerId();

        if (managerDao.existsManagerWithId(id)) {
            throw new RegistrationValidationException("This id already taken");

        }
            Manager manager = new Manager(
                    managerRegistration.managerId(),
                    managerRegistration.firstName(),
                    managerRegistration.Department()


            );

        return managerDao.insertManager(manager);
    }}

