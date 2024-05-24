package javamicroservices.departmentservice.Service;

import javamicroservices.departmentservice.DTO.DepartmentDto;

public interface DepartmentService {
    DepartmentDto saveDepartment(DepartmentDto departmentDTO);
    DepartmentDto getDepartmentByCode(String Code);
}
