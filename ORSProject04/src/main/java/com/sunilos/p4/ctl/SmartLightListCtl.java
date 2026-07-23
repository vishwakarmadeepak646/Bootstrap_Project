package com.sunilos.p4.ctl;


import com.sunilos.p4.bean.SmartLightBean;
import com.sunilos.p4.model.SmartLightModel;
import com.sunilos.p4.util.DataUtility;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
@WebServlet("/ctl/SmartLightListCtl")
public class SmartLightListCtl extends BaseListCtl<SmartLightBean, SmartLightModel>  {


	@Override
	protected SmartLightBean populateBean(HttpServletRequest request) {

		SmartLightBean bean = new SmartLightBean();

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

		return ORSView.SMARTLIGHT_LIST_VIEW;
	}

	@Override
	protected SmartLightModel getModel() {

		return new SmartLightModel();
	}
}
