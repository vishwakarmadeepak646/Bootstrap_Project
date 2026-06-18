package com.sunilos.p4.model.test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.sunilos.p4.bean.EmployeeBean;
import com.sunilos.p4.bean.InterviewBean;
import com.sunilos.p4.model.EmployeeModel;
import com.sunilos.p4.model.InterviewModel;
import com.sunilos.p4.util.DataUtility;

public class InterviewTest {

	public static void main(String[] args) {
	//	getAdd();
	//	getUpdate();
	//	getDelete();
		getSearch();
	//	findByCandidateName();
		
	}


	public static void findByCandidateName() {
		
		InterviewBean bean = new InterviewBean();
		InterviewModel model = new InterviewModel();
		
		bean = model.findByCandidateName("Kapil");
		
		if(bean!= null) {
			System.out.println(bean.getCandidateName());
			System.out.println(bean.getInterviewerName());
			System.out.println(bean.getResult());
			System.out.println(bean.getFeedback());
		}else {
			System.out.println("No record");
		}
		
	}


	public static void getAdd() {

		InterviewBean bean = new InterviewBean();
		InterviewModel model = new InterviewModel();
		
		bean.setCandidateName("Kapil");
		bean.setInterviewerName("Rakesh Jain");
		bean.setResult("Pass");	
		bean.setFeedback("Good");
		bean.setCreatedBy("root");
		bean.setModifiedBy("root");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		long i = model.add(bean);
		System.out.println(i + "row added");
		
	}
	
	public static void getUpdate() {
		InterviewBean bean = new InterviewBean();
		InterviewModel model = new InterviewModel();
		bean.setId(2);
		bean.setCandidateName("Kanika");
		bean.setInterviewerName("Ramesh Jain");
		bean.setResult("Pass");	
		bean.setFeedback("Good");
		bean.setCreatedBy("root");
		bean.setModifiedBy("root");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		model.update(bean);
		System.out.println("User updated successfully");
		
	}
	
	public static void getDelete() {
		InterviewBean bean = new InterviewBean();
		InterviewModel model = new InterviewModel();
		
		bean.setId(2);
		model.delete(bean);
		System.out.println("User Deleted successfully");
		
	}
	
	
	
	public static void getSearch() {
		InterviewBean bean = new InterviewBean();
		InterviewModel model = new InterviewModel();
		
		List<InterviewBean> list = new ArrayList<InterviewBean>();
		
	//	bean.setId(1);
	//	bean.setEmpName("D");
		
		list = model.search(bean);
		
		Iterator<InterviewBean> it =  list.iterator();
		
		while(it.hasNext()) {
			bean = it.next();
			System.out.println(bean.getId());
			System.out.println(bean.getCandidateName());
			System.out.println(bean.getInterviewerName());
			System.out.println(bean.getResult());
			System.out.println(bean.getFeedback());
		}
		
	}
	
	
}
