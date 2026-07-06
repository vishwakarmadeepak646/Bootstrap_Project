package com.sunilos.p4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.sunilos.p4.bean.EmployeeBean;
import com.sunilos.p4.bean.FacultyBean;
import com.sunilos.p4.bean.InterviewBean;
import com.sunilos.p4.exception.ApplicationException;
import com.sunilos.p4.exception.DuplicateRecordException;
import com.sunilos.p4.util.JDBCDataSource;

public class InterviewModel extends BaseModel<InterviewBean> {

	public InterviewBean findByCandidateName(String name) {
		return findByUniqueColumn("candidateName", name);
	}
	
	@Override
	public long add(InterviewBean bean) throws ApplicationException, DuplicateRecordException {
		Connection conn = null;
		int pk = 0;
		
		 
		InterviewBean existbean = findByCandidateName(bean.getCandidateName());
		if (existbean != null && existbean.getId() != bean.getId()) {
			throw new DuplicateRecordException("Interviewer Name already exists");
		}

		try {
			conn = JDBCDataSource.getConnection();
			pk = nextPK();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("insert into " + getTable() + " values(?,?,?,?,?,?,?,?,?)");
			pstmt.setInt(1, pk);
			pstmt.setString(2, bean.getCandidateName());
			pstmt.setString(3, bean.getInterviewerName());
			pstmt.setString(4, bean.getResult());
			pstmt.setString(5, bean.getFeedback());
			pstmt.setString(6, bean.getCreatedBy());
			pstmt.setString(7, bean.getModifiedBy());
			pstmt.setTimestamp(8, bean.getCreatedDatetime());
			pstmt.setTimestamp(9, bean.getModifiedDatetime());
			pstmt.executeUpdate();
			conn.commit();
			pstmt.close();

		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (Exception ex) {
				ex.printStackTrace();
				throw new ApplicationException("Exception : add rollback exception " + ex.getMessage());
			}
			throw new ApplicationException("Exception : Exception in add User" + e.getMessage());
		} finally {
			JDBCDataSource.closeConnection(conn);
		}

		return pk;
	}

	@Override
	public void update(InterviewBean bean) throws ApplicationException, DuplicateRecordException {

		Connection conn = null;
		int pk = 0;

		 
		InterviewBean existbean = findByCandidateName(bean.getCandidateName());
		if (existbean != null && existbean.getId() != bean.getId()) {
			throw new DuplicateRecordException("Interviewer Name already exists");
		}

		try {
			conn = JDBCDataSource.getConnection();
			pk = nextPK();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("update " + getTable()
					+ " set CandidateName =? , InterviewerName =? , result=? , feedback = ? , created_By=?, Modified_By=?, created_Datetime=?, Modified_Datetime=? where id = ?");

			pstmt.setString(1, bean.getCandidateName());
			pstmt.setString(2, bean.getInterviewerName());
			pstmt.setString(3, bean.getResult());
			pstmt.setString(4, bean.getFeedback());
			pstmt.setString(5, bean.getCreatedBy());
			pstmt.setString(6, bean.getModifiedBy());
			pstmt.setTimestamp(7, bean.getCreatedDatetime());
			pstmt.setTimestamp(8, bean.getModifiedDatetime());
			pstmt.setInt(9, pk);

			pstmt.executeUpdate();
			conn.commit();
			pstmt.close();

		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (Exception ex) {
				ex.printStackTrace();
				throw new ApplicationException("Exception : update rollback exception " + ex.getMessage());
			}
			throw new ApplicationException("Exception : Exception in update" + e.getMessage());
		} finally {
			JDBCDataSource.closeConnection(conn);
		}

	}

	@Override
	public String getWhereClause(InterviewBean bean) {
		StringBuffer sql = new StringBuffer();

		if (bean != null) {

			if (bean.getId() > 0) {
				sql.append(" and id = " + bean.getId());
			}

			if (bean.getCandidateName() != null && bean.getCandidateName().length() > 0) {
				sql.append(" and like '" + bean.getCandidateName() + "%'");
			}
		}

		return sql.toString();
	}

	

	@Override
	public String getTable() {

		return "st_interview";
	}

	@Override
	public InterviewBean getBean() {
		return new InterviewBean();
	}

}
