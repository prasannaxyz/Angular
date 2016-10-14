package com.practice.tutorialpractice;

public class EmployeeVO {
	
	private int empNo;
	private String name;
	private String gender;
	private String city;
	private Double salary;
	
	public EmployeeVO()
	{
		
	}
	public EmployeeVO(int empNo,String name, String gender, String city, Double salary) {
		super();
		this.setEmpNo(empNo);
		this.name = name;
		this.gender = gender;
		this.city = city;
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	
	
	
	
    
	
}
