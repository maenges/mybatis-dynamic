package com.sample.demo.mappers;

import java.util.List;
import java.util.Map;

import com.sample.demo.vo.Criteria;
import com.sample.demo.vo.Employee;

public interface EmployeeMapper {
	
	List<Employee> searchEmployees(Employee employee);
	List<Employee> getAllEmployees();
	List<Employee> findEmployees(Criteria c);
	List<Employee> getEmployees(Map<String, Object> search);
	List<Map<String, Object>> takeEmployees(Map<String, Object> search);
	List<Employee> fetchEmployees(Criteria c);
}
