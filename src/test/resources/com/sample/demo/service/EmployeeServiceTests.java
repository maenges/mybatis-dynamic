package com.sample.demo.service;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.*;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sample.demo.exception.EmptyResultException;
import com.sample.demo.vo.Criteria;
import com.sample.demo.vo.Employee;

import org.junit.Test;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/META-INF/spring/app-context.xml"})
public class EmployeeServiceTests {
	
	@Autowired
	EmployeeService employeeService;
	
	@Test
	public void testconfig() {
		// 앞에 예상값, 뒤가 notnullvalue라고 확신한다. 둘다 같은내용
		//assertThat(employeeService, notNullValue());
		assertNotNull(employeeService);
	}
	@Test
	public void testSearchEmployees() {
		List<Employee> result = null;
		result = employeeService.searchEmployees(null);
		assertEquals(107, result.size());
		
		Employee employee = new Employee();
		employee.setDepartmentId(new Long(80));
		result = employeeService.searchEmployees(employee);
		assertEquals(34, result.size());
		
		employee.setDepartmentId(new Long(80));
		employee.setJobId("SA_MAN");
		result = employeeService.searchEmployees(employee);
		assertEquals(5, result.size());
	}
	
	@Test
	public void testFindEmployees() {
		Criteria c = new Criteria();
		c.setOpt("job");
		c.setKeyword("SA_MAN");
		
		List<Employee> result = employeeService.findEmployees(c);
		assertEquals(5, result.size());
	}
	
	@Test
	public void testGetEmployees() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("job", "SA_MAN");
		map.put("dept", 80);
		
		List<Employee> result = employeeService.getEmployees(map);
		assertEquals(5, result.size());
	}
	
	@Test
	public void takeEmployees() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", 100);
		
		List<Map<String, Object>> result = employeeService.takeEmployees(map);
		assertEquals(1, result.size());
		
		for (Map<String, Object> emp : result) {
			System.out.println("EMPLOYEE_ID");
			System.out.println("JOB_ID");
			System.out.println("SALARY");
		}
	}
	
	@Test
	public void fetchEmployees() {
		Criteria c = new Criteria();
		c.setDepts(Arrays.asList(10, 20, 30, 40));
		
		List<Employee> result = employeeService.fetchEmployees(c);
		assertEquals(10, result.size());
	}
	
	@Test(expected=EmptyResultException.class)
	public void testEmptyResultException() {
		Employee employee = new Employee();
		employee.setDepartmentId(new Long(1234));
		
		employeeService.searchEmployees(employee);
	}
}

