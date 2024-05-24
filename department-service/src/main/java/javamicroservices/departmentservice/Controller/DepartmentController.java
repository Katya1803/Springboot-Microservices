package javamicroservices.departmentservice.Controller;

import javamicroservices.departmentservice.DTO.DepartmentDto;
import javamicroservices.departmentservice.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    // Save department REST API
    @PostMapping
    public ResponseEntity<DepartmentDto> post(@RequestBody DepartmentDto departmentDTO){
        DepartmentDto savedDepartment = departmentService.saveDepartment(departmentDTO);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    @GetMapping("{code}")
    public ResponseEntity<DepartmentDto> get(@PathVariable("code") String code){
        DepartmentDto departmentDTO = departmentService.getDepartmentByCode(code);
        return new ResponseEntity<>(departmentDTO, HttpStatus.OK);
    }
}
