package com.sunilos.p4.ctl;

import com.sunilos.p4.bean.InterviewBean;
import com.sunilos.p4.model.InterviewModel;
import com.sunilos.p4.util.DataUtility;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/ctl/InterviewListCtl")
public class InterviewListCtl extends BaseListCtl<InterviewBean, InterviewModel>{

	@Override
	protected InterviewBean populateBean(HttpServletRequest request) {

		InterviewBean bean = new InterviewBean();

		bean.setCandidateName(DataUtility.getString(request.getParameter("CandidateName")));
		bean.setInterviewerName(DataUtility.getString(request.getParameter("InterviewerName")));
		bean.setResult(DataUtility.getString(request.getParameter("result")));
		bean.setFeedback(DataUtility.getString(request.getParameter("feedback")));

		populateDTO(bean, request);

		return bean;
	}

	@Override
	protected String getView() {

		return ORSView.INTERVIEW_VIEW;
	}

	@Override
	protected String getView(String op) {

		return ORSView.INTERVIEW_LIST_VIEW;
	}

	@Override
	protected InterviewModel getModel() {

		return new InterviewModel();
	}
	
}
