package com.fiskhumalo.employeeManagement.controller.managerController;


import com.fiskhumalo.employeeManagement.model.employee.Employee;
import com.fiskhumalo.employeeManagement.model.manager.Manager;
import com.fiskhumalo.employeeManagement.model.manager.ManagerRegistration;
import com.fiskhumalo.employeeManagement.model.response.Response;
import com.fiskhumalo.employeeManagement.service.managerService.ManagerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("api/v1/managers")
public class ManagerController {

    private final ManagerService managerService;

    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

//    @GetMapping
//    public List<Manager> getManagers(){
//        return managerService.getAllManagers();
//    }
    @GetMapping
    public ResponseEntity<Response> getManagers(){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("managers",managerService.getAllManagers().stream().limit(10)))
                        .message("managers retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }


    @PostMapping()
    public ResponseEntity<Manager> addManagers(
            @RequestBody ManagerRegistration managerRegistration
    ){
     return ResponseEntity.ok(managerService.saveNewManager(managerRegistration));
    }
}




