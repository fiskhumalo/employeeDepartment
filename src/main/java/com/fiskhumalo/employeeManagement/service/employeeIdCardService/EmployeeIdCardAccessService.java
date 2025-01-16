package com.fiskhumalo.employeeManagement.service.employeeIdCardService;

import com.fiskhumalo.employeeManagement.dao.employeeCardDao.EmployeeIdCardDao;
import com.fiskhumalo.employeeManagement.model.employeeId.EmployeeIdCard;
import com.fiskhumalo.employeeManagement.repository.employeeIdCardRepo.EmployeeIdCardRepository;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
public class EmployeeIdCardAccessService implements EmployeeIdCardDao {

    private final EmployeeIdCardRepository employeeIdCardRepository;

    public EmployeeIdCardAccessService(EmployeeIdCardRepository employeeIdCardRepository) {
        this.employeeIdCardRepository = employeeIdCardRepository;
    }

    @Override
    public List<EmployeeIdCard> getAllAvailableCards() {
       return employeeIdCardRepository.findAll();

    }

    @Override
    public void addIdCard( ) {

    }
}
