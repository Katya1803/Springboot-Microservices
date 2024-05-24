package javamicroservices.departmentservice.Mapper;

import javamicroservices.departmentservice.DTO.DepartmentDto;
import javamicroservices.departmentservice.Entity.Department;

public class DepartmentMapper {
    public static DepartmentDto mapToDepartmentDto(Department department){
        DepartmentDto departmentDto = new DepartmentDto(
            department.getId(),
            department.getDepartmentName(),
                department.getDepartmentCode(),
                department.getDepartmentDescription()
        );
        return departmentDto;
    }

    public static Department mapToDepartment(DepartmentDto departmentDto){
        Department department = new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription(),
                departmentDto.getDepartmentCode()
        );
        return department;
    }
}
