package com.sunilos.p4.model.test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.sunilos.p4.bean.EmployeeBean;
import com.sunilos.p4.model.EmployeeModel;
import com.sunilos.p4.util.DataUtility;

public class EmployeeTest {

	public static void main(String[] args) {
	//	getAdd();
	//	getUpdate();
	//	getDelete();
	//	getSearch();
	//	findByEmail();
		
	}


	public static void findByEmail() {
		EmployeeBean bean = new EmployeeBean();
		EmployeeModel model = new EmployeeModel();
		
		bean = model.findByEmpName("Rahul");
		
		if(bean!= null) {
			System.out.println(bean.getEmpName());
			System.out.println(bean.getSalary());
			System.out.println(bean.getDoj());
		}else {
			System.out.println("No record");
		}
		
	}


	public static void getAdd() {

		EmployeeBean bean = new EmployeeBean();
		EmployeeModel model = new EmployeeModel();
		
		bean.setEmpName("Kapil");
		bean.setEmail("kapil@gmail.com");
		bean.setDoj(DataUtility.getDate("10/10/2000"));;	
		bean.setSalary(78000);
		bean.setCreatedBy("root");
		bean.setModifiedBy("root");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		long i = model.add(bean);
		System.out.println(i + "row added");
		
	}
	
	public static void getUpdate() {
		EmployeeBean bean = new EmployeeBean();
		EmployeeModel model = new EmployeeModel();
		
		bean.setId(1);
		bean.setEmpName("Rahul");
		bean.setEmail("rahul@gmail.com");
		bean.setDoj(DataUtility.getDate("10/10/2000"));;	
		bean.setSalary(78000);
		bean.setCreatedBy("root");
		bean.setModifiedBy("root");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		model.update(bean);
		System.out.println("User updated successfully");
		
	}
	
	public static void getDelete() {
		EmployeeBean bean = new EmployeeBean();
		EmployeeModel model = new EmployeeModel();
		
		bean.setId(3);
		model.delete(bean);
		System.out.println("User Deleted successfully");
		
	}
	
	
	
	public static void getSearch() {
		EmployeeBean bean = new EmployeeBean();
		EmployeeModel model = new EmployeeModel();
		List<EmployeeBean> list = new ArrayList<EmployeeBean>();
		
	//	bean.setId(1);
	//	bean.setEmpName("D");
		
		list = model.search(bean);
		
		Iterator<EmployeeBean> it =  list.iterator();
		
		while(it.hasNext()) {
			bean = it.next();
			System.out.println(bean.getId());
			System.out.println(bean.getEmpName());
			System.out.println(bean.getEmail());
			System.out.println(bean.getSalary());
			System.out.println(bean.getDoj());
		}
		
	}
	
	
	
}
