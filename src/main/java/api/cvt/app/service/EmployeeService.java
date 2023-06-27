package api.cvt.app.service;

import java.util.List;

import api.cvt.app.model.Employee;

public interface EmployeeService {
Employee saveEmployee(Employee employee);

List<Employee> getAllEmployees();

Employee getEmplyeeById(long id);

Employee updateEmployee(Employee employee,long id);

void deleteEmployee(long id);

List<Employee> findByFirstname(String name);


String findAdultUserByEmail(String name);
}
