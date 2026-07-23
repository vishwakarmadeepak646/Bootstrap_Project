package com.sunilos.p4.bean;

import java.sql.ResultSet;

public class SmartLightBean extends BaseBean {
	
	
	private String code;
	private String roomName;
	private int brightnessLevel;
	private String stauts;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public int getBrightnessLevel() {
		return brightnessLevel;
	}
	public void setBrightnessLevel(int brightnessLevel) {
		this.brightnessLevel = brightnessLevel;
	}
	public String getStauts() {
		return stauts;
	}
	public void setStauts(String stauts) {
		this.stauts = stauts;
	}
	
	@Override
	public String getKey() {
		return id + "";
	}

	@Override
	public String getValue() {
		return code;
	}

	@Override
	public void setResultset(ResultSet rs) {
		
		try {
			super.setResultset(rs);
			this.setCode(rs.getString("code"));
			this.setRoomName(rs.getString("roomName"));
			this.setBrightnessLevel(rs.getInt("brightnessLevel"));
			this.setStauts(rs.getString("stauts"));
			
		} catch (Exception e) {
		e.printStackTrace();
		}
	}
	

}
