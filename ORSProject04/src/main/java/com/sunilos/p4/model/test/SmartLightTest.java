package com.sunilos.p4.model.test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


import com.sunilos.p4.bean.SmartLightBean;
import com.sunilos.p4.model.SmartLightModel;

public class SmartLightTest {

	
	public static void main(String[] args) {
		//	getAdd();
		//	getUpdate();
		//	getDelete();
			getSearch();
		//findByCode();
			
		}


		public static void findByCode() {
			
			SmartLightBean bean = new SmartLightBean();
			SmartLightModel model = new SmartLightModel();
			
			bean = model.findByCode("L001");
			
			if(bean!= null) {
				System.out.println(bean.getCode());
				System.out.println(bean.getRoomName());
				System.out.println(bean.getBrightnessLevel());
				System.out.println(bean.getStauts());
			}else {
				System.out.println("No record");
			}
			
		}


		public static void getAdd() {

			SmartLightBean bean = new SmartLightBean();
			SmartLightModel model = new SmartLightModel();
			
			bean.setCode("L001");
			bean.setRoomName("R01");
			bean.setBrightnessLevel(5);
			bean.setStauts("InPogress");
			bean.setCreatedBy("root");
			bean.setModifiedBy("root");
			bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
			bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
			long i = model.add(bean);
			System.out.println(i + "row added");
			
		}
		
		public static void getUpdate() {
			SmartLightBean bean = new SmartLightBean();
			SmartLightModel model = new SmartLightModel();
			bean.setCode("L001");
			bean.setRoomName("R01");
			bean.setBrightnessLevel(3);
			bean.setStauts("InPogress");
			
			model.update(bean);
			System.out.println("User updated successfully");
			
		}
		
		public static void getDelete() {
			SmartLightBean bean = new SmartLightBean();
			SmartLightModel model = new SmartLightModel();
			
			bean.setId(1);
			model.delete(bean);
			System.out.println("User Deleted successfully");
			
		}
	
		public static void getSearch() {
			SmartLightBean bean = new SmartLightBean();
			SmartLightModel model = new SmartLightModel();
			
			List<SmartLightBean> list = new ArrayList<SmartLightBean>();
			
		//	bean.setId(1);
		//	bean.setEmpName("D");
			
			list = model.search(bean);
			
			Iterator<SmartLightBean> it =  list.iterator();
			
			while(it.hasNext()) {
				bean = it.next();
				System.out.println(bean.getId());
				System.out.println(bean.getCode());
				System.out.println(bean.getRoomName());
				System.out.println(bean.getBrightnessLevel());
				System.out.println(bean.getStauts());
			}
			
		
}}
