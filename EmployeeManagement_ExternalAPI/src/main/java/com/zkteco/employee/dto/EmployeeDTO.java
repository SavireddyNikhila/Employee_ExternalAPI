package com.zkteco.employee.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

	private String employeeId;
	private String firstName;
	private String lastName;
	private String gender;
	private String employeeEmailId;
	private String phoneNumber;
	private String password;
	private String dateOfBirth;
	private Boolean profilePhoto;
	private String createDate;
	private String updateDate;
	private DesignationDTO designation;
	private DepartmentDTO department;
}
