package miniproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBCon {
	
	private static Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	static {
		try {          // happydeliverymodel
			String url="jdbc:mysql://localhost:3306/dlvydb?characterEncoding=UTF-8&serverTime=UTC&useSSL=false";
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,"root","king3977");
			System.out.println("DB 연결성공!!!");
		} catch (ClassNotFoundException e) {
			System.out.println("클래스 로딩 실패!!!"+e.getMessage());
		} catch (SQLException e) {
			System.out.println("DB연결 실패!!!"+e.getMessage());
		}
	}
	
	public static Connection getInstance() {
		return con;
	}
	
	public static void close(ResultSet rs) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				
			}
		}
	}
	
	public static void close(PreparedStatement ps) {
		if(ps!=null) {
			try {
				ps.close();
			} catch (SQLException e) {
				
			}
		}
	}
	
	public static void close(Connection con) {
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				
			}
		}
	}

}
