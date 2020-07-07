package commons.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

//접속이 없더라도, 미리 접속을 확보해놓은 커넥션풀을 이용하되,
//이미 톰켓이 구현해놓았으므로, JNDI로 검색해서 풀을 이용하자!!
public class PoolManager {
	private static PoolManager instance;
	InitialContext context; //검색 객체
	DataSource ds; //커넥션풀 본체
	private  PoolManager() {
		try {
			context = new InitialContext();
			ds = (DataSource)context.lookup("java:comp/env/jdbc/oracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	public static PoolManager getInstance() {
		if(instance ==null) {
			instance=new PoolManager();
		}
		return instance;
	}
	
	//접속 객체 빌려오기!!
	public Connection getConnection() {
		Connection con = null;
		try {
			con=ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public void freeConnection(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void freeConnection(Connection con,PreparedStatement pstmt) {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void freeConnection(Connection con,PreparedStatement pstmt,ResultSet rs) {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
