package com.sunilos.p4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.sunilos.p4.bean.InsuranceBean;
import com.sunilos.p4.bean.ProductBean;
import com.sunilos.p4.exception.ApplicationException;
import com.sunilos.p4.exception.DuplicateRecordException;
import com.sunilos.p4.util.JDBCDataSource;

public class InsuranceModel extends BaseModel<InsuranceBean> {

	@Override
	public long add(InsuranceBean bean) throws ApplicationException, DuplicateRecordException {

		log.debug("Model add Started");
		Connection conn = null;
		int pk = 0;

		InsuranceBean existbean = findByCustomerName(bean.getCustomer_name());

		if (existbean != null && !(existbean.getId() == bean.getId()))  {
			throw new DuplicateRecordException("Customer Name already exists");
		}

		try {
			conn = JDBCDataSource.getConnection();
			pk = nextPK();
			// Get auto-generated next primary key
			System.out.println(pk + " in ModelJDBC");
			conn.setAutoCommit(false); // Begin transaction
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO " + getTable() + " VALUES(?,?,?,?,?,?,?,?,?)");
			pstmt.setInt(1, pk);
			pstmt.setString(2, bean.getCustomer_name());
			pstmt.setString(3, bean.getPolicy_type());
			pstmt.setLong(4, bean.getPremium_amt());
			pstmt.setString(5, bean.getClaim_status());
			pstmt.setString(6, bean.getCreatedBy());
			pstmt.setString(7, bean.getModifiedBy());
			pstmt.setTimestamp(8, bean.getCreatedDatetime());
			pstmt.setTimestamp(9, bean.getModifiedDatetime());
			pstmt.executeUpdate();
			conn.commit(); // End transaction
			pstmt.close();
		} catch (Exception e) {
			log.error("Database Exception..", e);
			try {
				conn.rollback();
			} catch (Exception ex) {
				ex.printStackTrace();
				throw new ApplicationException("Exception : add rollback exception " + ex.getMessage());
			}
			throw new ApplicationException("Exception : Exception in add User");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		log.debug("Model add End");
		return pk;

	}

	@Override
	public void update(InsuranceBean bean) throws ApplicationException, DuplicateRecordException {

		log.debug("Model add Started");
		Connection conn = null;

		InsuranceBean existbean = findByCustomerName(bean.getCustomer_name());

		if (existbean != null && !(existbean.getId() == bean.getId())) {
			throw new DuplicateRecordException("Customer Name already exists");
		}

		try {
			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false); // Begin transaction
			PreparedStatement pstmt = conn.prepareStatement("UPDATE " + getTable()
					+ " SET customer_name = ? , policy_type = ? , premium_amt=? , claim_status= ? WHERE ID = ?");

			pstmt.setString(1, bean.getCustomer_name());
			pstmt.setString(2, bean.getPolicy_type());
			pstmt.setLong(3, bean.getPremium_amt());
			pstmt.setString(4, bean.getClaim_status());
			pstmt.setLong(5, bean.getId());

			pstmt.executeUpdate();
			conn.commit(); // End transaction
			pstmt.close();
		} catch (Exception e) {
			log.error("Database Exception..", e);
			try {
				conn.rollback();
			} catch (Exception ex) {
				ex.printStackTrace();
				throw new ApplicationException("Exception : update rollback exception " + ex.getMessage());
			}
			throw new ApplicationException("Exception : Exception in update User");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		log.debug("Model update End");

	}

	public InsuranceBean findByCustomerName(String customerName) {
		return findByUniqueColumn("customer_name", customerName);
	}

	@Override
	public String getWhereClause(InsuranceBean bean) {
		StringBuffer sql = new StringBuffer();

		if (bean != null) {

			if (bean.getId() > 0) {
				sql.append(" AND ID = " + bean.getId());
			}
			if (bean.getCustomer_name() != null && bean.getCustomer_name().length() > 0) {
				sql.append(" AND Customer_Name like '" + bean.getCustomer_name() + "%'");
			}
			if (bean.getPolicy_type() != null && bean.getPolicy_type().length() > 0) {
				sql.append(" AND Policy_type like '" + bean.getPolicy_type() + "%'");
			}
			if (bean.getClaim_status() != null && bean.getClaim_status().length() > 0) {
				sql.append(" AND claim_status like '" + bean.getClaim_status() + "%'");
			}
		}
		return sql.toString();
	}

	@Override
	public String getTable() {

		return "st_insurance";
	}

	@Override
	public InsuranceBean getBean() {
		return new InsuranceBean();
	}

}
