package com.tka.OrganizationSystem.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tka.OrganizationSystem.entity.Country;
import com.tka.OrganizationSystem.entity.Employee;
import com.tka.OrganizationSystem.service.MainService;
//front end to backend it cross
@CrossOrigin
@RestController
@RequestMapping("api")
public class MainController {
	@Autowired
	MainService service;

	@PostMapping("addcountry")
	public String addCountry(@RequestBody Country c) {
//		System.out.println(c);

		String msg = service.addCountry(c);
		return msg;

	}

	@PutMapping("updatecountry/{id}")
	public String updateCountry(@PathVariable int id,@RequestBody Country c) {

		String msg = service.updateRecord(id, c);
		return msg;

	}
	@DeleteMapping("deletecountry/{id}")
	public String deleteCountry(@PathVariable int id) {
		String msg = service.deleteRecord(id);
		return msg;
		
	}
	@GetMapping("getallrecord")
	public List<Country> getAllRecord() {
		List <Country> list=service.getAllRecord();
		return list;
	}
	
	@PostMapping("addemp")
	public String addEmployee(@RequestBody Employee emp) {
		String msg =service.addEmployee(emp);
	return msg;
	}
	@PutMapping("updateemp")
	public String updateEmployee(@RequestBody Employee emp) {
		
		String msg = service.updateEmployee(emp);
		return msg;
		
	}
	@DeleteMapping("deleteemp/{id}")
	public String deleteEmployee(@PathVariable int id) {
		String msg = service.deleteEmployee(id);
		return msg;
		
	}
	@GetMapping("getallrecordemp")
	public List<Employee> getAllRecordemp(){
		List<Employee>list=service.getAllRecordemp();
		return list;
		
	}
	@GetMapping("getparticularrecordemp/{id}")
	public Employee getParticularRecordemp(@PathVariable int id) {
	Employee emp = service.getParticularRecordemp(id);
	return emp;
		
	}
	
	@GetMapping("getdatabystatus/{status}")
	public List<Employee> getDatabyStatus(@PathVariable String status) {
		List<Employee> list = service.getDatabyStatus(status);
		return list;
		
	}
	
	@PostMapping("loginapi")
	public HashMap loginApi(@RequestBody Employee emp) {
		System.out.println(emp);
		
		HashMap map = service.loginApi(emp);
		return map;
		
	}
	
	
	
	
	
	
	
	

}
