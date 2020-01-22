package com.bridgelabz.jdbcstatement.model;

public class Employee {
	int eid;
	String ename;
	String department;
	String phoneNumber;
	String emailId;

	public Employee(int eid, String ename, String department, String phoneNumber, String emailId) {

		this.eid = eid;
		this.ename = ename;
		this.department = department;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

}
