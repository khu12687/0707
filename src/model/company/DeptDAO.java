package model.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import commons.db.PoolManager;

public class DeptDAO {

	public void insert(Connection con) throws SQLException{

		PreparedStatement pstmt = null;

		String sql = "insert into dept(deptno,dname,loc)";
		sql += " values(50,'IT','서울')";
		
		pstmt = con.prepareStatement(sql);
		pstmt.executeUpdate();
	
	}
}
