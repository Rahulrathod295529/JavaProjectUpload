package com.tka.OrganizationSystem.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	String name;
	// admin, hr department
	String department;
	// active, inactive, suspend... stsus
	String status;
	String phoneno;
	double salary;

	Date createddtm;

	String createdby;

	Date updateDate;
	String updateddby;
	
	String emailid;
	
	@ManyToOne
	@JoinColumn(name = "c_id")
	Country country;
	
	
//	public Employee() {
//		
//	}
//	
//
//	public Employee(String name, String department, String status, String phoneno, double salary, Date createddtm,
//			String createdby, Date updateDate, String updateddby, String emailid, Country country) {
//		super();
//		this.name = name;
//		this.department = department;
//		this.status = status;
//		this.phoneno = phoneno;
//		this.salary = salary;
//		this.createddtm = createddtm;
//		this.createdby = createdby;
//		this.updateDate = updateDate;
//		this.updateddby = updateddby;
//		this.emailid = emailid;
//		this.country = country;
//	}
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getDepartment() {
//		return department;
//	}
//
//	public void setDepartment(String department) {
//		this.department = department;
//	}
//
//	public String getStatus() {
//		return status;
//	}
//
//	public void setStatus(String status) {
//		this.status = status;
//	}
//
//	public String getPhoneno() {
//		return phoneno;
//	}
//
//	public void setPhoneno(String phoneno) {
//		this.phoneno = phoneno;
//	}
//
//	public double getSalary() {
//		return salary;
//	}
//
//	public void setSalary(double salary) {
//		this.salary = salary;
//	}
//
//	public Date getCreateddtm() {
//		return createddtm;
//	}
//
//	public void setCreateddtm(Date createddtm) {
//		this.createddtm = createddtm;
//	}
//
//	public String getCreatedby() {
//		return createdby;
//	}
//
//	public void setCreatedby(String createdby) {
//		this.createdby = createdby;
//	}
//
//	public Date getUpdateDate() {
//		return updateDate;
//	}
//
//	public void setUpdateDate(Date updateDate) {
//		this.updateDate = updateDate;
//	}
//
//	public String getUpdateddby() {
//		return updateddby;
//	}
//
//	public void setUpdateddby(String updateddby) {
//		this.updateddby = updateddby;
//	}
//
//	public String getEmailid() {
//		return emailid;
//	}
//
//	public void setEmailid(String emailid) {
//		this.emailid = emailid;
//	}
//
//	public Country getCountry() {
//		return country;
//	}
//
//	public void setCountry(Country country) {
//		this.country = country;
//	}
//
//	@Override
//	public String toString() {
//		return "Employee [id=" + id + ", name=" + name + ", department=" + department + ", status=" + status
//				+ ", phoneno=" + phoneno + ", salary=" + salary + ", createddtm=" + createddtm + ", createdby="
//				+ createdby + ", updateDate=" + updateDate + ", updateddby=" + updateddby + ", emailid=" + emailid
//				+ ", country=" + country + "]";
//	}
	

	//use library for getter setter to string constructor
	//called Lombok ..... use annotation @Getter
//	@Setter
//	@ToString
//	@AllArgsConstructor
//	@NoArgsConstructor
	
	
	
	
	
}
