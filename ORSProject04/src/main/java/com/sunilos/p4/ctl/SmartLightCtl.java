package com.sunilos.p4.ctl;

import com.sunilos.p4.bean.BaseBean;
import com.sunilos.p4.bean.SmartLightBean;
import com.sunilos.p4.model.SmartLightModel;
import com.sunilos.p4.util.DataUtility;
import com.sunilos.p4.util.DataValidator;
import com.sunilos.p4.util.PropertyReader;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/ctl/SmartLightCtl")
public class SmartLightCtl extends BaseCtl  {

	@Override
	protected boolean validate(HttpServletRequest request) {
		
		boolean pass = true;

		if (DataValidator.isNull(request.getParameter("code"))) {
			request.setAttribute("code", PropertyReader.getValue("error.require", "code"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("roomName"))) {
			request.setAttribute("roomName", PropertyReader.getValue("error.require", "roomName"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("brightnessLevel"))) {
			request.setAttribute("brightnessLevel", PropertyReader.getValue("error.require", "brightnessLevel"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("stauts"))) {
			request.setAttribute("stauts", PropertyReader.getValue("error.require", "stauts"));
			pass = false;
		}

		return pass;
	}
	
	@Override
	protected SmartLightBean populateBean(HttpServletRequest request) {
	
		SmartLightBean bean = new SmartLightBean();
		
		bean.setId(DataUtility.getInt(request.getParameter("id")));
		bean.setCode(DataUtility.getString(request.getParameter("code")));
		bean.setRoomName(DataUtility.getString(request.getParameter("roomName")));
		bean.setBrightnessLevel(DataUtility.getInt(request.getParameter("brightnessLevel")));
		bean.setStauts(DataUtility.getString(request.getParameter("stauts")));

		populateDTO(bean, request);

		return bean;
		
	}
	
	@Override
	protected String getView() {
		return ORSView.SMARTLIGHT_VIEW;
	}

	@Override
	protected String getView(String op) {
		if (OP_CANCEL.equalsIgnoreCase(op)) {
			return ORSView.SMARTLIGHT_LIST_CTL;
		}
		return ORSView.SMARTLIGHT_VIEW;
	}

	@Override
	protected SmartLightModel getModel() {
	
		return new SmartLightModel();
	}

}
