package com.zkteco.employee.service;

import com.zkteco.employee.dto.EmployeeDTO;

import jakarta.servlet.http.HttpServletRequest;

public interface EmployeeService {

	Object getAllData();

	Object getById(String employeeId, HttpServletRequest request);

	Object create(EmployeeDTO employee);

	Object delete(String employeeId);

	Object update(EmployeeDTO employee, String employeeId);
}
