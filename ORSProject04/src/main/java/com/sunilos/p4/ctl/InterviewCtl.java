package com.sunilos.p4.ctl;

import com.sunilos.p4.bean.InterviewBean;
import com.sunilos.p4.model.InterviewModel;
import com.sunilos.p4.util.DataUtility;
import com.sunilos.p4.util.DataValidator;
import com.sunilos.p4.util.PropertyReader;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/ctl/InterviewCtl")
public class InterviewCtl extends BaseCtl<InterviewBean, InterviewModel>{


	@Override
	protected boolean validate(HttpServletRequest request) {

		boolean pass = true;

		if (DataValidator.isNull(request.getParameter("CandidateName"))) {
			request.setAttribute("candidateName", PropertyReader.getValue("error.require", "candidateName"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("InterviewerName"))) {
			request.setAttribute("InterviewerName", PropertyReader.getValue("error.require", "InterviewerName"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("result"))) {
			request.setAttribute("result", PropertyReader.getValue("error.require", "result"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("feedback"))) {
			request.setAttribute("feedback", PropertyReader.getValue("error.require", "feedback"));
			pass = false;
		}

		return pass;
	}

	@Override
	protected InterviewBean populateBean(HttpServletRequest request) {

		InterviewBean bean = new InterviewBean();

		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setCandidateName(DataUtility.getString(request.getParameter("candidateName")));
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

		if (OP_CANCEL.equalsIgnoreCase(op)) {
			return ORSView.INTERVIEW_CTL;
		}
		return ORSView.INTERVIEW_VIEW;
	}

	@Override
	protected InterviewModel getModel() {
		return new InterviewModel();
	}

}
