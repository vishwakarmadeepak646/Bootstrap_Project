package com.sunilos.p4.ctl;

import java.util.List;

import com.sunilos.p4.bean.InsuranceBean;
import com.sunilos.p4.model.InsuranceModel;

import jakarta.servlet.annotation.WebServlet;

@WebServlet("/ctl/InsuranceReportCtl")
public class InsuranceReportCtl extends BaseReportCtl<InsuranceBean>{

	@Override
	public String getView() {
		return ORSView.INSURANCE_REPORT_VIEW;
	}

	@Override
	public String getCompiledReportKey() {
	return "INSURANCE_LIST_COMPILED_REPORT";
	}

	@Override
	public List<InsuranceBean> getList() {
		InsuranceModel model = new InsuranceModel();
		@SuppressWarnings("unchecked")
		List<InsuranceBean> insurance = model.list();
		return insurance;
	}

}
