package com.innocodes.employeeservice.service;

import com.innocodes.employeeservice.dto.ApiResponseDto;
import com.innocodes.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    ApiResponseDto getEmployeeById(Long employeeId);

}
