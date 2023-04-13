package com.zkteco.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zkteco.employee.dto.EmployeeDTO;
import com.zkteco.employee.service.EmployeeService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping()
	public Object create(@RequestBody EmployeeDTO employee) {
		return employeeService.create(employee);
	}

	@GetMapping()
	public Object getAllData() {
		return employeeService.getAllData();
	}

	@GetMapping("/{id}")
	public Object getById(@PathVariable("id") String employeeId, HttpServletRequest request) {
		return employeeService.getById(employeeId, request);
	}

	@DeleteMapping("/{id}")
	public Object delete(@PathVariable("id") String employeeId) {
		return employeeService.delete(employeeId);
		
	}
	
	@PutMapping("/{id}")
	public Object update(@PathVariable("id") String employeeId, @RequestBody EmployeeDTO employee) {
		return employeeService.update(employee, employeeId);
	}
}
