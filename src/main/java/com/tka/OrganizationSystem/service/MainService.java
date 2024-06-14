package com.tka.OrganizationSystem.service;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.OrganizationSystem.dao.MainDao;
import com.tka.OrganizationSystem.entity.Country;
import com.tka.OrganizationSystem.entity.Employee;

@Service
public class MainService {
	@Autowired
	MainDao dao;

	public String addCountry(Country c) {

		String msg=dao.addCountry(c);
		//lets validate msg is present or not
		
		if(Objects.isNull(msg)) {
			msg="Country is not addded";
		}
		return msg;
		
	}

	public String updateRecord(int id, Country c) {
		String msg = dao.updateRecord(id, c);
		if(Objects.isNull(msg)) {
			msg="Country is not updated";
		}
		return msg;
		
		
	}

	public String deleteRecord(int id) {
		
		String msg = dao.deleteRecord(id);
		
		return msg;
	}

	public List<Country> getAllRecord() {
		
		List<Country> list=dao.getAllRecords();


		return list;
	}

	public String addEmployee(Employee emp) {
		String msg = dao.addEmployee(emp);
		if(Objects.isNull(msg)) {
			msg ="record is not addede";
		}
		return msg;
	}

	public String updateEmployee(Employee emp) {
		String msg = dao.updateEmployee(emp);
		if(Objects.isNull(msg)) {
			msg ="record is not be updated";
		}
		return msg;
		
	}

	public String deleteEmployee(int id) {
		String msg = dao.deleteEmployee(id);
		
		if(Objects.isNull(msg)) {
			msg ="record is not deleted ";
		}
		return msg;
	}

	public List<Employee> getAllRecordemp() {
		List<Employee>list=dao.getAllRecordemp();
		return list;
	}

	public Employee getParticularRecordemp(int id) {
Employee emp = dao.getParticularRecordemp(id);
		
		
		return emp;
	}

	public List<Employee> getDatabyStatus(String status) {
		List<Employee> list = dao.getDatabyStatus(status);
		if(Objects.isNull(list)) {
			list =null;
		}
		return list;
	}

	public HashMap loginApi(Employee emp) {
		
		Employee e= dao.loginApi(emp);
		HashMap map = new HashMap();
		if(Objects.isNull(e)) {
			map.put("msg", "invalid user");
			map.put("user", e);
			
		}else {
			map.put("msg", "Valid user");
			map.put("user", e);
			
			
		}
		return map;
		
		
	}

	
	
}
