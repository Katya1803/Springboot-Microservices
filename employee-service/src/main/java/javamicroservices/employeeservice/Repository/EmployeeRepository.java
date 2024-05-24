package javamicroservices.employeeservice.Repository;

import javamicroservices.employeeservice.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
