package javamicroservices.employeeservice.Service;

import javamicroservices.employeeservice.DTO.ApiResponseDto;
import javamicroservices.employeeservice.DTO.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto empoyeeDTO);
    ApiResponseDto getEmployeeById(Long id);
}
