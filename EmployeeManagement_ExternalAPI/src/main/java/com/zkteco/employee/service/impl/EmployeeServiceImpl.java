package com.zkteco.employee.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.zkteco.employee.dto.EmployeeDTO;
import com.zkteco.employee.service.EmployeeService;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${external.api.url}")
	private String ApiBaseUrl;

	@Override
	public Object getAllData() {
		String uri = ApiBaseUrl + "/all";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<EmployeeDTO> httpEntity = new HttpEntity<>(headers);
		return restTemplate.exchange(uri, HttpMethod.GET, httpEntity, Object.class);
		//return restTemplate.getForObject(uri, Object[].class);
	}

	@Override
	public Object getById(String employeeId, HttpServletRequest request) {
		String uri = ApiBaseUrl + "/" + employeeId;
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<EmployeeDTO> httpEntity = new HttpEntity<>(headers);
		return restTemplate.exchange(uri, HttpMethod.GET, httpEntity, Object.class,employeeId);
		//return restTemplate.getForObject(uri, Object.class);
	}

	@Override
	public Object create(EmployeeDTO employee) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<EmployeeDTO> httpEntity = new HttpEntity<>(employee,headers);
		return restTemplate.exchange(ApiBaseUrl, HttpMethod.POST, httpEntity, Object.class);
	}

	@Override
	public Object delete(String employeeId) {
		String uri = ApiBaseUrl + "/" + employeeId;
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<EmployeeDTO> httpEntity = new HttpEntity<>(headers);
		return restTemplate.exchange(uri, HttpMethod.DELETE, httpEntity, Object.class, employeeId);

	}

	@Override
	public Object update(EmployeeDTO employee, String employeeId) {
		String uri = ApiBaseUrl + "/" + employeeId;
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<EmployeeDTO> httpEntity = new HttpEntity<>(employee, headers);
		return restTemplate.exchange(uri, HttpMethod.PUT, httpEntity, Object.class, employeeId);

	}

}
