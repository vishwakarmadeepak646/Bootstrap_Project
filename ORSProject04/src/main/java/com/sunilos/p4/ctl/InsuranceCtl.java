package com.sunilos.p4.ctl;

import com.sunilos.p4.bean.CollegeBean;
import com.sunilos.p4.bean.InsuranceBean;
import com.sunilos.p4.bean.ProductBean;
import com.sunilos.p4.model.CollegeModel;
import com.sunilos.p4.model.InsuranceModel;
import com.sunilos.p4.util.DataUtility;
import com.sunilos.p4.util.DataValidator;
import com.sunilos.p4.util.PropertyReader;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/ctl/InsuranceCtl")
public class InsuranceCtl extends BaseCtl<InsuranceBean, InsuranceModel>{

	@Override
	protected boolean validate(HttpServletRequest request) {
		
		boolean pass = true;

		if (DataValidator.isNull(request.getParameter("customerName"))) {
			request.setAttribute("customerName", PropertyReader.getValue("error.require", "customerName"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("policyType"))) {
			request.setAttribute("policyType", PropertyReader.getValue("error.require", "policyType"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("premiumAmt"))) {
			request.setAttribute("premiumAmt", PropertyReader.getValue("error.require", "premiumAmt"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("claimStatus"))) {
			request.setAttribute("claimStatus", PropertyReader.getValue("error.require", "claimStatus"));
			pass = false;
		}

		return pass;
	}
	
	@Override
	protected InsuranceBean populateBean(HttpServletRequest request) {
	
		InsuranceBean bean = new InsuranceBean();
		
		bean.setId(DataUtility.getInt(request.getParameter("id")));
		bean.setCustomer_name(DataUtility.getString(request.getParameter("customerName")));
		bean.setPolicy_type(DataUtility.getString(request.getParameter("policyType")));
		bean.setPremium_amt(DataUtility.getLong(request.getParameter("premiumAmt")));
		bean.setClaim_status(DataUtility.getString(request.getParameter("claimStatus")));

		populateDTO(bean, request);

		return bean;
		
	}
	
	@Override
	protected String getView() {
		return ORSView.INSURANCE_VIEW;
	}

	@Override
	protected String getView(String op) {
		if (OP_CANCEL.equalsIgnoreCase(op)) {
			return ORSView.INSURANCE_CTL;
		}
		return ORSView.INTERVIEW_VIEW;
	}

	@Override
	protected InsuranceModel getModel() {
		// TODO Auto-generated method stub
		return new InsuranceModel();
	}

}
