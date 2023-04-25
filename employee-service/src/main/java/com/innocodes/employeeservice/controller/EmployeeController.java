package com.innocodes.employeeservice.controller;

import com.innocodes.employeeservice.dto.ApiResponseDto;
import com.innocodes.employeeservice.dto.EmployeeDto;
import com.innocodes.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/employees")
@RestController
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;


    //Build save Employee REST API
    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployee = employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }


    //Build get Employee REST API
    @GetMapping("{id}")
    public ResponseEntity<ApiResponseDto> getEmployee(@PathVariable("id") Long employeeId){
        ApiResponseDto apiResponseDto = employeeService.getEmployeeById(employeeId);
        return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);
    }
}
