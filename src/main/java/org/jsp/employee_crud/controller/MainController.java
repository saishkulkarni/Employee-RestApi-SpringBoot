package org.jsp.employee_crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/")
	public String loadSwagger() {
		return "redirect:/swagger-ui/index.html";
	}
}
