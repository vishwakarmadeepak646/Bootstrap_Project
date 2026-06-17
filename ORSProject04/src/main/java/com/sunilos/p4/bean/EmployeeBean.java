package com.sunilos.p4.bean;

import java.sql.ResultSet;
import java.util.Date;

public class EmployeeBean extends BaseBean {

	private String EmpName;
	private String email;
	private long salary;
	private Date doj;

	public String getEmpName() {
		return EmpName;
	}

	public void setEmpName(String empName) {
		EmpName = empName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return EmpName;
	}

	@Override
	public String getValue() {
		
		return EmpName;
	}
	
	@Override
	public void setResultset(ResultSet rs) {
			
		try {
			super.setResultset(rs);
			this.setId(rs.getLong(1));
			this.setEmpName(rs.getString(2));
			this.setEmail(rs.getString(3));
			this.setSalary(rs.getLong(4));
			this.setDoj(rs.getDate(5));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}

}
