package com.innocodes.employeeservice.controller;

import com.innocodes.employeeservice.dto.ApiResponseDto;
import com.innocodes.employeeservice.dto.EmployeeDto;
import com.innocodes.employeeservice.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Tag(
        name = "Employee Service - EmployeeController",
        description = "Employee Controller Exposes REST APIs for Employee-Service"
)

@RequestMapping("api/employees")
@RestController
@AllArgsConstructor
public class EmployeeController {



    private EmployeeService employeeService;

    @Operation(
            summary = "Save Employee REST API",
            description = "Save Employee REST API is used to save Employee object in the database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )


    //Build save Employee REST API
    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployee = employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }


    @Operation(
            summary = "Get Employee REST API",
            description = "Get Employee REST API is used to get Employee object in the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    //Build get Employee REST API
    @GetMapping("{id}")
    public ResponseEntity<ApiResponseDto> getEmployee(@PathVariable("id") Long employeeId){
        ApiResponseDto apiResponseDto = employeeService.getEmployeeById(employeeId);
        return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);
    }
}
