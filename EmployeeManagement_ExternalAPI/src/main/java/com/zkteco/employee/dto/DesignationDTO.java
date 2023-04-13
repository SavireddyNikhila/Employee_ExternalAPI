package com.zkteco.employee.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DesignationDTO {

	private String desigId;
	private String desigCode;
	private String desigName;
	private String createDate;
	private String updateDate;
}
