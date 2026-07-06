package com.sunilos.p4.bean;

import java.sql.ResultSet;

public class InsuranceBean extends BaseBean{
	
	private String customer_name;
	private String policy_type;
	private long premium_amt;
	private String claim_status;

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getPolicy_type() {
		return policy_type;
	}

	public void setPolicy_type(String policy_type) {
		this.policy_type = policy_type;
	}

	public long getPremium_amt() {
		return premium_amt;
	}

	public void setPremium_amt(long premium_amt) {
		this.premium_amt = premium_amt;
	}

	public String getClaim_status() {
		return claim_status;
	}

	public void setClaim_status(String claim_status) {
		this.claim_status = claim_status;
	}

	@Override
	public String getKey() {
		return id + "";
	}

	@Override
	public String getValue() {
		return customer_name;
	}

	@Override
	public void setResultset(ResultSet rs) {
		
		try {
			super.setResultset(rs);
			this.setCustomer_name(rs.getString("customer_name"));
			this.setPolicy_type(rs.getString("policy_type"));
			this.setPremium_amt(rs.getLong("premium_amt"));
			this.setClaim_status(rs.getString("claim_status"));
			
		} catch (Exception e) {
		e.printStackTrace();
		}
	}
	
}