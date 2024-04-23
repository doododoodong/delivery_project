package miniproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Test extends Vo {
	
	private static Connection con;
	private static PreparedStatement ps;
	private static ResultSet rs;
	ArrayList<MemberVO> mlist;
	

	public static void main(String[] args) throws SQLException {
		con = DBCon.getInstance();
		RestVO restVO=new RestVO();
		ArrayList<RestVO> rlist=new ArrayList<RestVO>();

		String query = "select*from restaurant where ownerID=?";
		String id="asd";
		try {
			ps=con.prepareStatement(query);
			ps.setString(1, id);
			rs=ps.executeQuery();

			while (rs.next()) {
				RestVO rVO=new RestVO();
				restVO.setRestcode(rs.getInt("restCode"));
				rlist.add(restVO);
				int res = restVO.getRestcode();
				System.out.println(res);
			}

		} catch (SQLException e) {
			Tool.print("예외발생 : " + e.getMessage());
		}
	}
		
}
