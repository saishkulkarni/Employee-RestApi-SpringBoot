package org.jsp.employee_crud.controller;

import java.util.List;

import org.jsp.employee_crud.dto.Employee;
import org.jsp.employee_crud.helper.ResponseStructure;
import org.jsp.employee_crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	@Autowired
	EmployeeService service;

	@Operation(summary = "Save One Employee",description = "Dont Enter Id Field")
	@PostMapping("/employees")
	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(@RequestBody Employee employee) {
		return service.save(employee);
	}

	@Operation(summary = "Fetch One Employee")
	@GetMapping("/employees/{id}")
	public ResponseEntity<ResponseStructure<Employee>> fetchEmployeeById(@PathVariable int id) {
		return service.fetchById(id);
	}

	@GetMapping("/employees")
	@Operation(summary = "Fetch All Employee")
	public ResponseEntity<ResponseStructure<List<Employee>>> fetchEmployees() {
		return service.fetchAll();
	}

	@PostMapping("/employees/many")
	@Operation(summary = " Save Employees - Multiple")
	public ResponseEntity<ResponseStructure<List<Employee>>> saveEmployees(@RequestBody List<Employee> employees) {
		return service.saveAll(employees);
	}

	@Operation(summary = "Fetch By Name")
	@GetMapping("/employees/name/{name}")
	public ResponseEntity<ResponseStructure<List<Employee>>> fetchEmployeeByName(@PathVariable String name) {
		return service.fetchByName(name);
	}

	@Operation(summary = "Fetch By Salary")
	@GetMapping("/employees/salary/{salary}")
	public ResponseEntity<ResponseStructure<List<Employee>>> fetchEmployeeBySalary(@PathVariable double salary) {
		return service.fetchBySalary(salary);
	}

	@Operation(summary = " Fetch By Mobile")
	@GetMapping("/employees/mobile/{mobile}")
	public ResponseEntity<ResponseStructure<Employee>> fetchEmployeeByMobile(@PathVariable long mobile) {
		return service.fetchByMobile(mobile);
	}

	@Operation(summary = "Delete By Id")
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<ResponseStructure<Employee>> deleteEmployeeById(@PathVariable int id) {
		return service.deleteById(id);
	}

	@Operation(summary = "Update - PUT")
	@PutMapping("/employees")
	public ResponseEntity<ResponseStructure<Employee>> updateEMployee(@RequestBody Employee employee) {
		return service.update(employee);
	}

	@Operation(summary = "Update - Patch")
	@PatchMapping("/employees/{id}")
	public ResponseEntity<ResponseStructure<Employee>> updateEmployee(@RequestBody Employee employee,
			@PathVariable int id) {
		return service.updateEmployee(employee, id);
	}
}
