package model.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import commons.db.PoolManager;

public class EmpDAO {

	public void insert(Connection con) throws SQLException{
		PreparedStatement pstmt = null;
		
		String sql = "insert into emp(empnos,ename,sal,deptno)";
		sql += " values(8888,'스캇',700,'50')";
		
		pstmt = con.prepareStatement(sql);
		pstmt.executeUpdate();
	}
}
