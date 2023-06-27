package api.cvt.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import api.cvt.app.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
	
	@Query("select u from Employee u WHERE u.firstName =?1")
	List<Employee> findFirstname(String firstname);
	
	
	@Query(value = "SELECT id FROM employees WHERE first_name = ?1 ", nativeQuery = true)
	String findAdultUserByEmail(String firstname);
	
	
}
