package com.fiskhumalo.employeeManagement.controller.employeeIdCardController;

import com.fiskhumalo.employeeManagement.model.employeeId.EmployeeIdCard;
import com.fiskhumalo.employeeManagement.model.response.Response;
import com.fiskhumalo.employeeManagement.service.employeeIdCardService.EmployeeIdCardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpStatus.OK;


@RestController
@RequestMapping("api/v1/employeeIdCard")
public class EmployeeIdCardController {

    private final EmployeeIdCardService employeeIdCardService;

    public EmployeeIdCardController(EmployeeIdCardService employeeIdCardService) {
        this.employeeIdCardService = employeeIdCardService;
    }


//    @GetMapping
//    public List<EmployeeIdCard> displayAllCards(){
//       return employeeIdCardService.getAllCards();


    @GetMapping
    public ResponseEntity<Response> displayAllCards(){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("employeeIdCards", employeeIdCardService.getAllCards().stream().limit(5)))
                        .status(OK)
                        .message("retrieved idCards")
                        .statusCode(OK.value())
                        .build()
        );
    }
    }

