package com.fiskhumalo.employeeManagement.controller.employeeController;

import com.fiskhumalo.employeeManagement.model.employee.Employee;
import com.fiskhumalo.employeeManagement.model.employee.EmployeeRegistrationRequest;
import com.fiskhumalo.employeeManagement.model.employee.EmployeeUpdateRequest;
import com.fiskhumalo.employeeManagement.model.response.Response;
import com.fiskhumalo.employeeManagement.service.employeeService.EmployeeService;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

import java.util.Map;
import java.util.Optional;

import static org.springframework.http.HttpStatus.OK;


@RestController
@RequestMapping("api/v1/employees")
@CrossOrigin(origins = "http://127.0.0.1:5174")
public class EmployeeController {



    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;

    }




    @GetMapping
    public ResponseEntity<Response> getAllEmployees(){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("employees", employeeService.displayAllEmployees()))
                        .status(OK)
                        .message("fetching employees")
                        .statusCode(OK.value())
                        .build()
        );
    }
    @GetMapping("{employeeId}")
    public Employee getEmployeeById(
            @PathVariable("employeeId") Long id){
       return employeeService.getEmployeeById(id);

    }

    @PostMapping
    public Employee addEmployee(
            @RequestBody EmployeeRegistrationRequest employeeRegistrationRequest ){
      return   employeeService.addNewEmployee(employeeRegistrationRequest);

    }

    @PutMapping("{employeeId}")
    public Employee updateEmployees(@PathVariable("employeeId") Long employeeId,
                                @RequestBody EmployeeUpdateRequest employeeUpdateRequest){
         return employeeService.updateEmployee(employeeId,employeeUpdateRequest);

    }
    @DeleteMapping("{employeeId}")
    public void removeEmployeeById(
            @PathVariable("employeeId") Long employeeId){
        employeeService.deleteEmployeeById(employeeId);

    }

    @GetMapping("getMostPaidEmployee")
    public Optional<Employee> getMostPaidEmployee(){
       return employeeService.getMostPaidEmployee();

    }


    @GetMapping("getLowestEarningEmployee")
    public Optional<Employee> getLowestPaidEmployee(){
        return employeeService.getLowestPaidEmployee();
    }

    @GetMapping("getTotalCostOfSalaries")
    public double getTotalOfSalaries(){
        return employeeService.getTotalOfAllSalaries();
  }

    @GetMapping("IncreaseSalary")
    public Employee incrementSalary(Employee employee){
        return employeeService.increaseSalaries(employee);
  }



}

