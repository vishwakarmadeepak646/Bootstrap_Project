package com.sunilos.p4.bean;

import java.sql.ResultSet;

public class InterviewBean extends BaseBean {
	
	private String candidateName;
	private String interviewerName;
	private String result;
	private String feedback;

	public String getCandidateName() {
		return candidateName;
	}

	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}

	public String getInterviewerName() {
		return interviewerName;
	}

	public void setInterviewerName(String interviewerName) {
		this.interviewerName = interviewerName;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	@Override
	public String getKey() {
		return id + "";
	}

	@Override
	public String getValue() {
		return candidateName;
	}
	
	@Override
	public void setResultset(ResultSet rs) {
		try {
			super.setResultset(rs);
			this.setCandidateName(rs.getString(2));
			this.setInterviewerName(rs.getString(3));
			this.setResult(rs.getString(4));
			this.setFeedback(rs.getString(5));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
