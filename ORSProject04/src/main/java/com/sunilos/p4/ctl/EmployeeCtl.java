package com.sunilos.p4.ctl;

import com.sunilos.p4.bean.EmployeeBean;
import com.sunilos.p4.bean.ProductBean;
import com.sunilos.p4.model.EmployeeModel;
import com.sunilos.p4.model.ProductModel;
import com.sunilos.p4.util.DataUtility;
import com.sunilos.p4.util.DataValidator;
import com.sunilos.p4.util.PropertyReader;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/ctl/EmployeeCtl")
public class EmployeeCtl extends BaseCtl<EmployeeBean, EmployeeModel> {

	@Override
	protected boolean validate(HttpServletRequest request) {

		boolean pass = true;

		if (DataValidator.isNull(request.getParameter("EmpName"))) {
			request.setAttribute("EmpName", PropertyReader.getValue("error.require", "EmpName"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("email"))) {
			request.setAttribute("email", PropertyReader.getValue("error.require", "email"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("doj"))) {
			request.setAttribute("doj", PropertyReader.getValue("error.require", "doj"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("salary"))) {
			request.setAttribute("salary", PropertyReader.getValue("error.require", "salary"));
			pass = false;
		}

		return pass;
	}

	@Override
	protected EmployeeBean populateBean(HttpServletRequest request) {

		EmployeeBean bean = new EmployeeBean();

		bean.setEmpName(DataUtility.getString(request.getParameter("EmpName")));
		bean.setEmail(DataUtility.getString(request.getParameter("email")));
		bean.setDoj(DataUtility.getDate(request.getParameter("doj")));
		bean.setSalary(DataUtility.getLong(request.getParameter("salary")));

		populateDTO(bean, request);

		return bean;
	}

	@Override
	protected String getView() {
		return ORSView.EMPLOYEE_VIEW;
	}

	@Override
	protected String getView(String op) {

		if (OP_CANCEL.equalsIgnoreCase(op)) {
			return ORSView.EMPLOYEE_CTL;
		}
		return ORSView.EMPLOYEE_VIEW;
	}

	@Override
	protected EmployeeModel getModel() {
		return new EmployeeModel();
	}

}
