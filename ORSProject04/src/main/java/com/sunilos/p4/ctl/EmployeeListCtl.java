package com.sunilos.p4.ctl;

import com.sunilos.p4.bean.EmployeeBean;
import com.sunilos.p4.model.EmployeeModel;
import com.sunilos.p4.util.DataUtility;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/ctl/EmployeeListCtl")
public class EmployeeListCtl extends BaseListCtl<EmployeeBean, EmployeeModel> {

	@Override
	protected EmployeeBean populateBean(HttpServletRequest request) {

		EmployeeBean bean = new EmployeeBean();

		bean.setEmpName(DataUtility.getString(request.getParameter("EmpName")));
		bean.setEmail(DataUtility.getString(request.getParameter("email")));
		bean.setDoj(DataUtility.getDate(request.getParameter("doj")));
		bean.setSalary(DataUtility.getInt(request.getParameter("salary")));

		populateDTO(bean, request);

		return bean;
	}

	@Override
	protected String getView() {

		return ORSView.EMPLOYEE_VIEW;
	}

	@Override
	protected String getView(String op) {

		return ORSView.EMPLOYEE_LIST_VIEW;
	}

	@Override
	protected EmployeeModel getModel() {

		return new EmployeeModel();
	}

}
