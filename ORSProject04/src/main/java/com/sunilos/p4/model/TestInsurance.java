package com.sunilos.p4.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.sunilos.p4.bean.InsuranceBean;
import com.sunilos.p4.bean.ProductBean;

public class TestInsurance {

	public static void main(String[] args) {
	//	getAdd();
	//	getUpdate();
	//	getDelete();
//		searchByPK(); 
//		searchByName();
		search();

	}

	private static void getAdd() {
		
		InsuranceBean bean = new InsuranceBean();
		InsuranceModel model = new InsuranceModel();
		
		bean.setCustomer_name("Radhe");
		bean.setPolicy_type("LIC");
		bean.setPremium_amt(50000);
		bean.setClaim_status("approved");
		bean.setCreatedBy("Deepak");
		bean.setModifiedBy("Deepak");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		long i = model.add(bean);

		System.out.println(i + "Row added");
		
	}
	
	private static void getUpdate() {
		InsuranceBean bean = new InsuranceBean();
		InsuranceModel model = new InsuranceModel();
		
		bean.setId(1);
		bean.setCustomer_name("Krishna");
		bean.setPolicy_type("LIC");
		bean.setPremium_amt(60000);
		bean.setClaim_status("approved");
		bean.setCreatedBy("Deepak");
		bean.setModifiedBy("Deepak");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		
		model.update(bean);

		System.out.println("Row updated");
		
	}
	
	public static void getDelete() {

		InsuranceBean bean = new InsuranceBean();
		InsuranceModel model = new InsuranceModel();
//		bean.setId(2);
//      model.delete(bean); both Methods will work as we have 2 delete method in Model one with int and one with bean
		model.delete(1);
	}
	
	public static void searchByPK() {
		
		InsuranceBean bean = new InsuranceBean();
		InsuranceModel model = new InsuranceModel();
		
		bean = model.findByPK(1);
		
		if(bean != null ) {
			System.out.println("------------------");
			System.out.println(bean.getCustomer_name());
			System.out.println(bean.getPolicy_type());
			System.out.println(bean.getPremium_amt());
			System.out.println(bean.getClaim_status());
			System.out.println(bean.getCreatedBy());
			System.out.println(bean.getModifiedBy());
			System.out.println(bean.getCreatedDatetime());
			System.out.println(bean.getModifiedDatetime());
			
		}else {
			System.out.println("No record found");
		}
	}
	
public static void searchByName() {
		
	InsuranceBean bean = new InsuranceBean();
	InsuranceModel model = new InsuranceModel();
	
	bean = model.findByCustomerName("Radhe");
	
	if(bean != null ) {
		System.out.println("------------------");
		System.out.println(bean.getCustomer_name());
		System.out.println(bean.getPolicy_type());
		System.out.println(bean.getPremium_amt());
		System.out.println(bean.getClaim_status());
		System.out.println(bean.getCreatedBy());
		System.out.println(bean.getModifiedBy());
		System.out.println(bean.getCreatedDatetime());
		System.out.println(bean.getModifiedDatetime());
		
	}else {
		System.out.println("No record found");
	}
	}

public static void search() {

	InsuranceBean bean = new InsuranceBean();
	InsuranceModel model = new InsuranceModel();
	
	List<InsuranceBean> list = new ArrayList<InsuranceBean>();
	bean.setCustomer_name("Radhe");
	
	list = model.search(bean);
	
	Iterator<InsuranceBean> it = list.iterator();
	
	while(it.hasNext()) {
		bean = it.next();
		System.out.println("------------------");
		System.out.println(bean.getCustomer_name());
		System.out.println(bean.getPolicy_type());
		System.out.println(bean.getPremium_amt());
		System.out.println(bean.getClaim_status());
		System.out.println(bean.getCreatedBy());
		System.out.println(bean.getModifiedBy());
		System.out.println(bean.getCreatedDatetime());
		System.out.println(bean.getModifiedDatetime());
		
		
	}
	
}


}
