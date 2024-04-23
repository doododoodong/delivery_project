package miniproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RestDAO {

	private static Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	ArrayList<RestVO> list;

	public RestDAO() {
		con = DBCon.getInstance();
	}
	
	// restInfo를 전달받아 restTable에 추가
	public int registRest(String ownerid, String restaddress, String restname, String category) {
		
		String query="insert into restaurant (ownerID, rest_address, rest_name, rest_category) values(?,?,?,?)";
		int result=0;
		
		try {
			ps=con.prepareStatement(query);
			ps.setString(1, ownerid);
			ps.setString(2, restaddress);
			ps.setString(3, restname);
			ps.setString(4, category);
			result=ps.executeUpdate();
			
			return result;
		} catch (SQLException e) {
			Tool.print("예외발생 : "+e.getMessage());
			return 0;
		} finally {
			DBCon.close(ps);
		}
		
		
		
		
	}
// 	가게이름으로 가게코드 찾기.
	public int getRestCodeByName(String name) {
		RestVO restVO=new RestVO();

		String query = "select*from restaurant where rest_name =?";

		try {
			ps = con.prepareStatement(query);
			ps.setString(1, name);
			rs = ps.executeQuery();
			

			while (rs.next()) {
				restVO.setRestcode(rs.getInt("restCode"));
				restVO.setAddress(rs.getString("rest_address"));
				restVO.setName(rs.getString("rest_name"));
				restVO.setCategory(rs.getString("rest_category"));
				int res = restVO.getRestcode();
				return res;
			}

		} catch (SQLException e) {
			Tool.print("예외발생 : " + e.getMessage());
		}
		return 0;

	}
	
	public int getRestCodeById(String ownerid) {
		RestVO restVO=new RestVO();

		String query = "select*from restaurant where ownerID =?";

		try {
			ps = con.prepareStatement(query);
			ps.setString(1, ownerid);
			rs = ps.executeQuery();
			

			while (rs.next()) {
				restVO.setRestcode(rs.getInt("restCode"));
				restVO.setAddress(rs.getString("rest_address"));
				restVO.setName(rs.getString("rest_name"));
				restVO.setCategory(rs.getString("rest_category"));
				int res = restVO.getRestcode();
				return res;
			}

		} catch (SQLException e) {
			Tool.print("예외발생 : " + e.getMessage());
		}
		return 0;

	}
	
	public ArrayList<RestVO> getRestByRestCode(int code) {
		RestVO restVO=new RestVO();
		
		list=new ArrayList<RestVO>();

		String query = "select*from restaurant where restCode=?";

		try {
			ps = con.prepareStatement(query);
			ps.setInt(1, code);
			rs = ps.executeQuery();
			

			while (rs.next()) {
				
				restVO.setRestcode(rs.getInt("restCode"));
				restVO.setAddress(rs.getString("rest_address"));
				restVO.setName(rs.getString("rest_name"));
				restVO.setCategory(rs.getString("rest_category"));
				restVO.setOwnerID(rs.getString("ownerID"));
				
				list.add(restVO);
			}

		} catch (SQLException e) {
			Tool.print("예외발생 : " + e.getMessage());
		}
		return list;

	}

}
