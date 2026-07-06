package com.sunilos.p4.ctl;

import com.sunilos.p4.bean.InsuranceBean;
import com.sunilos.p4.model.InsuranceModel;
import com.sunilos.p4.util.DataUtility;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/ctl/InsuranceListCtl")
public class InsuranceListCtl extends BaseListCtl<InsuranceBean, InsuranceModel> {

	@Override
	protected InsuranceBean populateBean(HttpServletRequest request) {

		InsuranceBean bean = new InsuranceBean();

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

		return ORSView.INSURANCE_LIST_VIEW;
	}

	@Override
	protected InsuranceModel getModel() {

		return new InsuranceModel();
	}

}
