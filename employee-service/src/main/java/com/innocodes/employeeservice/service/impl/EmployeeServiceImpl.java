package com.innocodes.employeeservice.service.impl;

import com.innocodes.employeeservice.dto.ApiResponseDto;
import com.innocodes.employeeservice.dto.DepartmentDto;
import com.innocodes.employeeservice.dto.EmployeeDto;
import com.innocodes.employeeservice.entity.Employee;
import com.innocodes.employeeservice.repository.EmployeeRepository;
import com.innocodes.employeeservice.service.APIClient;
import com.innocodes.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@AllArgsConstructor
//@NoArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private APIClient apiClient;
//    private RestTemplate restTemplate;
//    private WebClient webClient;
    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                employeeDto.getDepartmentCode()
        );
        Employee saveDEmployee = employeeRepository.save(employee);

        EmployeeDto savedEmployeeDto = new EmployeeDto(
            saveDEmployee.getId(),
            saveDEmployee.getFirstName(),
            saveDEmployee.getLastName(),
            saveDEmployee.getEmail(),
            saveDEmployee.getDepartmentCode()

        );
        return savedEmployeeDto;
    }

    @Override
    public ApiResponseDto getEmployeeById(Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId).get();

//        ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/department/" + employee.getDepartmentCode(),
//                DepartmentDto.class);
//        DepartmentDto departmentDto = responseEntity.getBody();
//
//        DepartmentDto departmentDto = webClient.get()
//                .uri("http://localhost:8080/api/department/" + employee.getDepartmentCode())
//                .retrieve()
//                .bodyToMono(DepartmentDto.class)
//                .block();

       DepartmentDto departmentDto =  apiClient.getDepartment(employee.getDepartmentCode());

        EmployeeDto employeeDto = new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDepartmentCode()
        );

        ApiResponseDto apiResponseDto = new ApiResponseDto();
        apiResponseDto.setEmployeeDto(employeeDto);
        apiResponseDto.setDepartmentDto(departmentDto);
        return apiResponseDto;

    }

}
