package com.sunilos.p4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.sunilos.p4.bean.SmartLightBean;
import com.sunilos.p4.exception.ApplicationException;
import com.sunilos.p4.exception.DuplicateRecordException;
import com.sunilos.p4.util.JDBCDataSource;

public class SmartLightModel extends BaseModel<SmartLightBean>  {

	@Override
	public long add(SmartLightBean bean) throws ApplicationException, DuplicateRecordException {

		log.debug("Model add Started");
		Connection conn = null;
		int pk = 0;

		SmartLightBean existbean = findByCode(bean.getCode());

		if (existbean != null && !(existbean.getId() == bean.getId())) {
			throw new DuplicateRecordException("Code already exists");
		}

		try {
			conn = JDBCDataSource.getConnection();
			pk = nextPK();
			// Get auto-generated next primary key
			System.out.println(pk + " in ModelJDBC");
			conn.setAutoCommit(false); // Begin transaction
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO " + getTable() + " VALUES(?,?,?,?,?,?,?,?,?)");
			pstmt.setInt(1, pk);
			pstmt.setString(2, bean.getCode());
			pstmt.setString(3, bean.getRoomName());
			pstmt.setLong(4, bean.getBrightnessLevel());
			pstmt.setString(5, bean.getStauts());
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
	public void update(SmartLightBean bean) throws ApplicationException, DuplicateRecordException {

		log.debug("Model add Started");
		Connection conn = null;

		SmartLightBean existbean = findByCode(bean.getCode());

		if (existbean != null && !(existbean.getId() == bean.getId())) {
			throw new DuplicateRecordException("Code already exists");
		}

		try {
			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false); // Begin transaction
			PreparedStatement pstmt = conn.prepareStatement("UPDATE " + getTable()
					+ " SET code = ? , roomName = ? , brightnessLevel=? , stauts= ? WHERE ID = ?");

			pstmt.setString(1, bean.getCode());
			pstmt.setString(2, bean.getRoomName());
			pstmt.setLong(3, bean.getBrightnessLevel());
			pstmt.setString(4, bean.getStauts());
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

	public SmartLightBean findByCode(String code) {
		return findByUniqueColumn("code", code);
	}

	@Override
	public String getWhereClause(SmartLightBean bean) {
		StringBuffer sql = new StringBuffer();

		if (bean != null) {

			if (bean.getId() > 0) {
				sql.append(" AND ID = " + bean.getId());
			}
			if (bean.getCode() != null && bean.getCode().length() > 0) {
				sql.append(" AND code like '" + bean.getCode() + "%'");
			}
			if (bean.getRoomName() != null && bean.getRoomName().length() > 0) {
				sql.append(" AND roomName like '" + bean.getRoomName() + "%'");
			}
			if (bean.getStauts() != null && bean.getStauts().length() > 0) {
				sql.append(" AND status like '" + bean.getStauts() + "%'");
			}
		}
		return sql.toString();
	}

	@Override
	public String getTable() {

		return "st_light";
	}

	@Override
	public SmartLightBean getBean() {
		return new SmartLightBean();
	}

}
