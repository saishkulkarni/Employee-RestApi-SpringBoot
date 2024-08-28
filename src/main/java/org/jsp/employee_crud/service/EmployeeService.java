package org.jsp.employee_crud.service;

import java.util.List;

import org.jsp.employee_crud.dto.Employee;
import org.jsp.employee_crud.helper.ResponseStructure;
import org.jsp.employee_crud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository repository;

	@Autowired
	ResponseStructure<Employee> structure;

	@Autowired
	ResponseStructure<List<Employee>> structure2;

	public ResponseEntity<ResponseStructure<Employee>> save(Employee employee) {
		if (repository.existsByMobile(employee.getMobile())) {
			structure.setMessage("Data Already Exists");
			structure.setData(null);
			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.BAD_REQUEST);
		} else {
			repository.save(employee);
			structure.setMessage("Data Saved Success");
			structure.setData(employee);

			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.CREATED);
		}
	}
	
	public ResponseEntity<ResponseStructure<Employee>> fetchById(int id) {
		Employee employee = repository.findById(id).orElse(null);
		if (employee == null) {
			structure.setMessage("Data Not Found");
			structure.setData(null);
			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.NOT_FOUND);
		} else {
			structure.setMessage("Data Found");
			structure.setData(employee);
			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.FOUND);
		}
	}
	
	public ResponseEntity<ResponseStructure<List<Employee>>> fetchAll() {
		List<Employee> list = repository.findAll();
		if (list.isEmpty()) {
			structure2.setMessage("Data Not Found");
			structure2.setData(null);
			return new ResponseEntity<ResponseStructure<List<Employee>>>(structure2, HttpStatus.NOT_FOUND);
		} else {
			structure2.setMessage("Data Found");
			structure2.setData(list);
			return new ResponseEntity<ResponseStructure<List<Employee>>>(structure2, HttpStatus.FOUND);
		}
	}
	
	public ResponseEntity<ResponseStructure<List<Employee>>> saveAll(List<Employee> employees) {
		for (Employee employee : employees) {
			if (repository.existsByMobile(employee.getMobile())) {
				structure2.setMessage("Data Already Exists");
				structure2.setData(null);
				return new ResponseEntity<ResponseStructure<List<Employee>>>(structure2, HttpStatus.BAD_REQUEST);
			}
		}

		repository.saveAll(employees);

		structure2.setMessage("Data Saved Success");
		structure2.setData(employees);
		return new ResponseEntity<ResponseStructure<List<Employee>>>(structure2, HttpStatus.CREATED);
	}
	public ResponseEntity<ResponseStructure<List<Employee>>> fetchByName(String name) {
		List<Employee> list = repository.findByName(name);
		if (list.isEmpty()) {
			structure2.setMessage("Data Not Found");
			structure2.setData(null);
			return new ResponseEntity<ResponseStructure<List<Employee>>>(structure2, HttpStatus.NOT_FOUND);
		} else {
			structure2.setMessage("Data Found");
			structure2.setData(list);
			return new ResponseEntity<ResponseStructure<List<Employee>>>(structure2, HttpStatus.FOUND);
		}
	}



	public ResponseEntity<ResponseStructure<List<Employee>>> fetchBySalary(double salary) {
		List<Employee> list = repository.findBySalary(salary);
		if (list.isEmpty()) {
			structure2.setMessage("Data Not Found");
			structure2.setData(null);
			return new ResponseEntity<ResponseStructure<List<Employee>>>(structure2, HttpStatus.NOT_FOUND);
		} else {
			structure2.setMessage("Data Found");
			structure2.setData(list);
			return new ResponseEntity<ResponseStructure<List<Employee>>>(structure2, HttpStatus.FOUND);
		}
	}

	
	public ResponseEntity<ResponseStructure<Employee>> fetchByMobile(long mobile) {
		Employee employee = repository.findByMobile(mobile);
		if (employee == null) {
			structure.setMessage("Data Not Found");
			structure.setData(null);
			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.NOT_FOUND);
		} else {
			structure.setMessage("Data Found");
			structure.setData(employee);
			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.FOUND);
		}
	}


	public ResponseEntity<ResponseStructure<Employee>> deleteById(int id) {
		Employee employee = repository.findById(id).orElse(null);
		if (employee == null) {
			structure.setMessage("Data Not Found");
			structure.setData(null);
			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.NOT_FOUND);
		} else {
			repository.deleteById(id);
			structure.setMessage("Data Removed");
			structure.setData(employee);
			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.OK);
		}
	}

}
