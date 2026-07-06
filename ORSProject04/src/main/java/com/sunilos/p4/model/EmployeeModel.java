package com.sunilos.p4.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import com.sunilos.p4.bean.EmployeeBean;
import com.sunilos.p4.bean.ProductBean;
import com.sunilos.p4.exception.ApplicationException;
import com.sunilos.p4.exception.DuplicateRecordException;
import com.sunilos.p4.util.JDBCDataSource;

public class EmployeeModel extends BaseModel<EmployeeBean> {

	@Override
	public long add(EmployeeBean bean) throws ApplicationException, DuplicateRecordException {

		Connection conn = null;
		int pk = 0;

		EmployeeBean existbean = findByEmpName(bean.getEmpName());
		if (existbean != null && existbean.getId() != bean.getId()) {
			throw new DuplicateRecordException("Employee Name already exists");
		}

		try {
			conn = JDBCDataSource.getConnection();
			pk = nextPK();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("insert into " + getTable() + " values(?,?,?,?,?,?,?,?,?)");
			pstmt.setInt(1, pk);
			pstmt.setString(2, bean.getEmpName());
			pstmt.setString(3, bean.getEmail());
			pstmt.setLong(4, bean.getSalary());
			pstmt.setDate(5, new java.sql.Date(bean.getDoj().getTime()));
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
	public void update(EmployeeBean bean) throws ApplicationException, DuplicateRecordException {

		Connection conn = null;
		int pk = 0;

		EmployeeBean existbean = findByEmpName(bean.getEmpName());
		if (existbean != null && existbean.getId() != bean.getId()) {
			throw new DuplicateRecordException("Employee Name already exists");
		}

		try {
			conn = JDBCDataSource.getConnection();
			pk = nextPK();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("update " + getTable()
					+ " set EmpName =? , email=? , salary=? , doj = ? , created_By=?, Modified_By=?, created_Datetime=?, Modified_Datetime=? where id = ?");

			pstmt.setString(1, bean.getEmpName());
			pstmt.setString(2, bean.getEmail());
			pstmt.setLong(3, bean.getSalary());
			pstmt.setDate(4, new java.sql.Date(bean.getDoj().getTime()));
			pstmt.setString(5, bean.getCreatedBy());
			pstmt.setString(6, bean.getModifiedBy());
			pstmt.setTimestamp(7, bean.getCreatedDatetime());
			pstmt.setTimestamp(8, bean.getModifiedDatetime());
			pstmt.setLong(9, bean.getId());
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
			throw new ApplicationException("Exception : Exception in update User" + e.getMessage());
		} finally {
			JDBCDataSource.closeConnection(conn);
		}

	}

	public EmployeeBean findByEmpName(String EmpName) {
		return findByUniqueColumn("EmpName", EmpName);
	}

	@Override
	public String getWhereClause(EmployeeBean bean) {

		StringBuffer sql = new StringBuffer();

		if (bean != null) {
			if (bean.getId() > 0) {
				sql.append(" and id = " + bean.getId());
			}
			if (bean.getEmpName() != null && bean.getEmpName().length() > 0) {
				sql.append(" and EmpName like'" + bean.getEmpName() + "%'");
			}
		}
		return sql.toString();
	}

	@Override
	public String getTable() {

		return "st_employee";
	}

	@Override
	public EmployeeBean getBean() {
		return new EmployeeBean();
	}

}
