package javamicroservices.employeeservice.Service.iml;

import javamicroservices.employeeservice.DTO.ApiResponseDto;
import javamicroservices.employeeservice.DTO.DepartmentDto;
import javamicroservices.employeeservice.DTO.EmployeeDto;
import javamicroservices.employeeservice.DTO.OrganizationDto;
import javamicroservices.employeeservice.Entity.Employee;
import javamicroservices.employeeservice.Mapper.EmployeeMapper;
import javamicroservices.employeeservice.Repository.EmployeeRepository;
import javamicroservices.employeeservice.Service.APIClient;
import javamicroservices.employeeservice.Service.EmployeeService;
import javamicroservices.employeeservice.Service.OrganizationClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor

public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private OrganizationClient organizationClient;
    @Autowired
    private EmployeeRepository employeeRepository;

//    @Autowired
//    private RestTemplate restTemplate;

//    @Autowired
//    private WebClient webClient;

    @Autowired
    private APIClient apiClient;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        EmployeeDto savedEmployeeDto = EmployeeMapper.mapToEmployeeDto(savedEmployee);
        return savedEmployeeDto;
    }

    @Override
    public ApiResponseDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).get();

//        ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/departments/" + employee.getDepartmentCode(), DepartmentDto.class);
//        DepartmentDto departmentDto = responseEntity.getBody();

//        DepartmentDto departmentDto = webClient.get()
//                .uri("http://localhost:8080/api/departments/" +employee.getDepartmentCode())
//                .retrieve().bodyToMono(DepartmentDto.class)
//                .block();

        DepartmentDto departmentDto = apiClient.getDepartment(employee.getDepartmentCode());
        EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);
        OrganizationDto organizationDto; // Giả sử Employee có organizationCode
        try {
            organizationDto = organizationClient.getOrganization(employee.getOrganizationCode()); // Giả sử Employee có organizationCode
        } catch (Exception e) {
            // Handle the case where the organization service is unavailable
            organizationDto = new OrganizationDto();
            organizationDto.setOrganizationName("Unknown Organization");
        }


        ApiResponseDto apiResponseDto = new ApiResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);
        apiResponseDto.setOrganization(organizationDto);

        return apiResponseDto;

    }
}

