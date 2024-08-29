package org.jsp.employee_crud.controller;

import java.util.List;

import org.jsp.employee_crud.dto.Employee;
import org.jsp.employee_crud.helper.ResponseStructure;
import org.jsp.employee_crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	@Autowired
	EmployeeService service;

	// Save One Employee
	@Operation(summary = "Save One EMployee")
	@PostMapping("/employees")
	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(@RequestBody Employee employee) {
		return service.save(employee);
	}

	// Fetch One Employee
	@GetMapping("/employees/{id}")
	public ResponseEntity<ResponseStructure<Employee>> fetchEmployeeById(@PathVariable int id) {
		return service.fetchById(id);
	}

	// Fetch All Employee
	@GetMapping("/employees")
	public ResponseEntity<ResponseStructure<List<Employee>>> fetchEmployees() {
		return service.fetchAll();
	}

	// Save Employees - Multiple
	@PostMapping("/employees/many")
	public ResponseEntity<ResponseStructure<List<Employee>>> saveEmployees(@RequestBody List<Employee> employees) {
		return service.saveAll(employees);
	}

	// Fetch By Name
	@GetMapping("/employees/name/{name}")
	public ResponseEntity<ResponseStructure<List<Employee>>> fetchEmployeeByName(@PathVariable String name) {
		return service.fetchByName(name);
	}

	// Fetch By Salary
	@GetMapping("/employees/salary/{salary}")
	public ResponseEntity<ResponseStructure<List<Employee>>> fetchEmployeeBySalary(@PathVariable double salary) {
		return service.fetchBySalary(salary);
	}

	// Fetch By Mobile
	@GetMapping("/employees/mobile/{mobile}")
	public ResponseEntity<ResponseStructure<Employee>> fetchEmployeeByMobile(@PathVariable long mobile) {
		return service.fetchByMobile(mobile);
	}

	// Delete By Id
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<ResponseStructure<Employee>> deleteEmployeeById(@PathVariable int id) {
		return service.deleteById(id);
	}

}
