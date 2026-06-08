package com.sunilos.p4.model.test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.sunilos.p4.bean.ProductBean;
import com.sunilos.p4.model.ProductModel;

public class TestProduct {

	public static void main(String[] args) {
		// getAdd();
		// getUpdate();
		// getDelete();
		
		// searchByPK();
		// searchByName();
		
		search();
	}

	public static void getUpdate() {
		ProductBean bean = new ProductBean();
		ProductModel model = new ProductModel();

		bean.setId(1);
		bean.setProductName("Monitor");
		bean.setProductCategory("Electonics");
		bean.setPrice(500);
		bean.setOrderDate(new Date());
		bean.setCreatedBy("Kapil");
		bean.setModifiedBy("Kapil");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		model.update(bean);
		System.out.println("Row updated Successfully...");

	}

	public static void getAdd() {

		ProductBean bean = new ProductBean();
		ProductModel model = new ProductModel();

		bean.setProductName("Mouse");
		bean.setProductCategory("Electonics");
		bean.setPrice(50000);
		bean.setOrderDate(new Date());
		bean.setCreatedBy("Deepak");
		bean.setModifiedBy("Deepak");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		long i = model.add(bean);

		System.out.println(i + "Row added");
	}

	public static void getDelete() {

		ProductBean bean = new ProductBean();
		ProductModel model = new ProductModel();
//		bean.setId(2);
//      model.delete(bean); both Methods will work as we have 2 delete method in Model one with int and one with bean
		model.delete(1);
	}
	
	public static void searchByPK() {
	
		ProductBean bean = new ProductBean();
		ProductModel model = new ProductModel();
		
		bean = model.findByPK(1);
		
		if(bean != null ) {
			System.out.println("------------------");
			System.out.println(bean.getProductName());
			System.out.println(bean.getProductCategory());
			System.out.println(bean.getPrice());
			System.out.println(bean.getOrderDate());
			System.out.println(bean.getCreatedBy());
			System.out.println(bean.getModifiedBy());
			System.out.println(bean.getCreatedDatetime());
			System.out.println(bean.getModifiedDatetime());
			
		}else {
			System.out.println("No record found");
		}
	}
	
	public static void searchByName() {
		
		ProductBean bean = new ProductBean();
		ProductModel model = new ProductModel();
		
		bean = model.findByProudctName("Mobile");
		
		if(bean != null ) {
			System.out.println("------------------");
			System.out.println(bean.getProductName());
			System.out.println(bean.getProductCategory());
			System.out.println(bean.getPrice());
			System.out.println(bean.getOrderDate());
			System.out.println(bean.getCreatedBy());
			System.out.println(bean.getModifiedBy());
			System.out.println(bean.getCreatedDatetime());
			System.out.println(bean.getModifiedDatetime());
			
		}else {
			System.out.println("No record found");
		}
	}
	
	public static void search() {

		ProductBean bean = new ProductBean();
		ProductModel model = new ProductModel();
		
		List<ProductBean> list = new ArrayList<ProductBean>();
		bean.setProductName("Mobile");
		
		list = model.search(bean);
		
		Iterator<ProductBean> it = list.iterator();
		
		while(it.hasNext()) {
			bean = it.next();
			System.out.println("------------------");
			System.out.println(bean.getProductName());
			System.out.println(bean.getProductCategory());
			System.out.println(bean.getPrice());
			System.out.println(bean.getOrderDate());
			System.out.println(bean.getCreatedBy());
			System.out.println(bean.getModifiedBy());
			System.out.println(bean.getCreatedDatetime());
			System.out.println(bean.getModifiedDatetime());
			
			
		}
		
	}
	
	 

}
