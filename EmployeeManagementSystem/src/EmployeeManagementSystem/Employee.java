package EmployeeManagementSystem;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Employee implements Serializable {

	//creating the fields
	
	public String empName;
	public int empID;
	public String empAddress;
	public String jobTitle;
	public double empSalary;
	
	
	public Employee(String empName, int empID, String empAddress, String jobTitle,double empSalary) {
		//super();
		this.empName = empName;
		this.empID = empID;
		this.empAddress= empAddress;				;
		this.jobTitle = jobTitle;
		this.empSalary=empSalary;
	}

//getter and setter methods
	
	public double getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}

	public String getEmpName() {
		return empName;
	}


	public void setEmpName(String empName) {
		this.empName = empName;
	}


	public int getEmpID() {
		return empID;
	}


	public void setEmpID(int empID) {
		this.empID = empID;
	}


	public String getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	public String getJobTitle() {
		return jobTitle;
	}


	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	
	@Override
	public String toString() {
		return "\nEmployee Details:- "+ 
	            "\n Employee ID:- "+ empID + 
	            "\n Employee Name:- " + empName +
	            "\n Employee Address:- "+ empAddress +
	            "\n Employee Job Title:- " + jobTitle +
	            "\n Employee Salary:- "	+ empSalary;
	}
	
	
	
}


