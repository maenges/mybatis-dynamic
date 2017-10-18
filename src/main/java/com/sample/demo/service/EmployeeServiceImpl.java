package com.sample.demo.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.demo.exception.EmptyResultException;
import com.sample.demo.mappers.EmployeeMapper;
import com.sample.demo.vo.Criteria;
import com.sample.demo.vo.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeMapper employeeMapper;
	
	public List<Employee> searchEmployees(Employee employee) {
		if (employee == null) {
			return employeeMapper.getAllEmployees();
		}
		List<Employee> employees = employeeMapper.searchEmployees(employee);
		if (employees.isEmpty()) {
			throw new EmptyResultException("조회결과가 존재하지 않습니다.");
		}
		return employees;
	}

	public List<Employee> findEmployees(Criteria c) {
		if(c == null) {
			throw new IllegalArgumentException("Criteria는 null을 허용하지 않습니다.");
		}
		return employeeMapper.findEmployees(c);
	}

	public List<Employee> getEmployees(Map<String, Object> search) {
		if(search == null) {
			throw new IllegalArgumentException("map은 null을 허용하지 않습니다.");
		}
		return employeeMapper.getEmployees(search);
	}

	public List<Map<String, Object>> takeEmployees(Map<String, Object> search) {
		if(search == null) {
			throw new IllegalArgumentException("map은 null을 허용하지 않습니다.");
		}
		return employeeMapper.takeEmployees(search);
	}

	public List<Employee> fetchEmployees(Criteria c) {
		if(c == null) {
			throw new IllegalArgumentException("Criteria는 null을 허용하지 않습니다.");
		}
		return employeeMapper.fetchEmployees(c);
		
	}
	
	
	
	
	
}







