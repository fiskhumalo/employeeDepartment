package com.fiskhumalo.employeeManagement.service.managerService;

import com.fiskhumalo.employeeManagement.dao.managerDao.ManagerDao;
import com.fiskhumalo.employeeManagement.model.manager.Manager;
import com.fiskhumalo.employeeManagement.repository.managerRepository.ManagerRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public class ManagerJPADataAccessService implements ManagerDao {

    private final ManagerRepository managerRepository;

    public ManagerJPADataAccessService(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    @Override
    public List<Manager> printAllManagers() {
        return managerRepository.findAll();
    }

    @Override
    public Manager insertManager(Manager manager) {
        return managerRepository.save(manager);
    }

    @Override
    public boolean existsManagerWithEmail(String email) {
        return false;
    }

    @Override
    public Manager updateManager(Manager manager) {
        return null;
    }

    @Override
    public boolean existsManagerWithId(Long id) {
        return false;
    }

    @Override
    public void deleteManager(Long managerId) {

    }
}
