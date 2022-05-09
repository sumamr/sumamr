package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Department;
import com.example.demo.service.DepartmentService;

@RestController
public class DepartmentController {
	@Autowired
	DepartmentService  departmentService;
	@PostMapping("/departments/")
	
	public Department saveDepartment(@RequestBody Department department) {
		return departmentService .saveDepartment(department);
		
		
	}

}
