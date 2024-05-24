package javamicroservices.departmentservice.Service.impl;

import javamicroservices.departmentservice.DTO.DepartmentDto;
import javamicroservices.departmentservice.Entity.Department;
import javamicroservices.departmentservice.Mapper.DepartmentMapper;
import javamicroservices.departmentservice.Repository.DepartmentRepository;
import javamicroservices.departmentservice.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDTO) {
        Department department = DepartmentMapper.mapToDepartment(departmentDTO);

        Department savedDepartment = departmentRepository.save(department);
        DepartmentDto savedDepartmentDto = DepartmentMapper.mapToDepartmentDto(savedDepartment);
        return  savedDepartmentDto;
    }
    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
        Department department = departmentRepository.findByDepartmentCode(departmentCode);
        DepartmentDto departmentDto = DepartmentMapper.mapToDepartmentDto(department);
        return  departmentDto;
    }

}
