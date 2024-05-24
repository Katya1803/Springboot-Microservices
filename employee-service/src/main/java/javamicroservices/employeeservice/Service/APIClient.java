package javamicroservices.employeeservice.Service;

import javamicroservices.employeeservice.DTO.DepartmentDto;
import javamicroservices.employeeservice.DTO.OrganizationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "DEPARTMENT-SERVICE")
public interface APIClient {
    @GetMapping("api/departments/{code}")
    DepartmentDto getDepartment(@PathVariable("code") String code);
}

