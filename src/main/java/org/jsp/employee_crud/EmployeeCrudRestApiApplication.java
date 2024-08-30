package org.jsp.employee_crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Employee CRUD",description = "REST Api for Performing CRUD Operations on Employee Data",version = "1.0",contact = @Contact(email = "saishkulkarni7@gmail.com",name = "Saish",url = "https://github.com/saishkulkarni")))
public class EmployeeCrudRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeCrudRestApiApplication.class, args);
	}

}
