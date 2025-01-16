package com.fiskhumalo.employeeManagement.service.employeeIdCardService;


import com.fiskhumalo.employeeManagement.dao.employeeCardDao.EmployeeIdCardDao;



import com.fiskhumalo.employeeManagement.model.employeeId.EmployeeIdCard;


import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class EmployeeIdCardService {
    private final EmployeeIdCardDao employeeIdCardDao;


    public EmployeeIdCardService(EmployeeIdCardDao employeeIdCardDao) {
        this.employeeIdCardDao = employeeIdCardDao;

    }

    public List<EmployeeIdCard> getAllCards() {
            return employeeIdCardDao.getAllAvailableCards();
        }

    }
