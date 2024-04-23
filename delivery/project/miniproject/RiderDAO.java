package miniproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RiderDAO {
	
	private static Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	ArrayList<RiderVO> list;
	
	public RiderDAO() {
		con=DBCon.getInstance();
	}
	
	public int registerMember(RiderVO vo) throws SQLException {
		try {
			String query = "insert into member values(?,?,?,?,?,?,?,?)";
			int result = 0;
			ps = con.prepareStatement(query);
			ps.setString(1, vo.getRcode());
			ps.setString(2, vo.getRiderid());
			ps.setString(3, vo.getPass());
			ps.setString(4, vo.getHumancode());
			ps.setString(5, vo.getPhonenum());
			ps.setString(6, vo.getAddress());
			ps.setString(7, vo.getName());
			ps.setString(8, vo.getEmail());
			result = ps.executeUpdate();

			return result;

		} finally {
			DBCon.close(ps);
		}
	}

//	---------------------------------------------------------------------------

	public int confirmID(String id) {
		
		String query="select memberID from member where memberID=?";
		int res=0;
		
		try {
			ps=con.prepareStatement(query);
			ps.setString(1, id);
			rs=ps.executeQuery();
			
			if(rs.next()) {
				return 1;
			} else {
				return 0;
			}
		} catch (SQLException e) {
			Tool.print("예외 발생 : "+e.getMessage());
		} finally {
			DBCon.close(ps);
			DBCon.close(rs);
		}
		return -1;
	}
	
//	---------------------------------------------------------------------------
	
	public int confirmAccount(String acc) {

		String query = "select account from member where account=?";
		int res = 0;

		try {
			ps = con.prepareStatement(query);
			ps.setString(1, acc);
			rs = ps.executeQuery();

			if (rs.next()) {
				return 1;
			} else {
				return 0;
			}
		} catch (SQLException e) {
			Tool.print("예외 발생 : " + e.getMessage());
		} finally {
			DBCon.close(ps);
			DBCon.close(rs);
		}
		return -1;
	}
	
//	---------------------------------------------------------------------------
	
	public ArrayList<RiderVO> getSearchID(String name, String humancode) {
		list=new ArrayList<RiderVO>();
		
		String query="select*from member where name like ? and ssn like ?";
		try {
			ps=con.prepareStatement(query);
			ps.setString(1, "%"+name+"%");
			ps.setString(2, "%"+humancode+"%");
			rs=ps.executeQuery();
			
			while(rs.next()) {
				
				RiderVO rVO=new RiderVO();
				rVO.setRiderid(rs.getString("memberID"));
				rVO.setPass(rs.getString("pass"));
				rVO.setName(rs.getString("name"));
				rVO.setEmail(rs.getString("email"));
				
				list.add(rVO);
			}
		} catch (SQLException e) {
			Tool.print("예외 : "+e.getMessage());
		}
		return list;
	}
	
//	---------------------------------------------------------------------------
	
	public ArrayList<RiderVO> SearchID(String id) {
		list=new ArrayList<RiderVO>();
		
		String query="select*from member where memberID=?";
		try {
			ps=con.prepareStatement(query);
			ps.setString(1, id);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				
				RiderVO rVO = new RiderVO();
				rVO.setRiderid(rs.getString("memberID"));
				rVO.setPass(rs.getString("pass"));
				rVO.setName(rs.getString("name"));
				rVO.setEmail(rs.getString("email"));
				rVO.setRgcode(rs.getString("membercode"));
				
				list.add(rVO);
			}
		} catch (SQLException e) {
			Tool.print("예외 : "+e.getMessage());
		}
		return list;
	}
	
//	---------------------------------------------------------------------------
	
	public int getSearchPW(String id, String humancode) {
		
		String query="select*from rmember where memberID like ? and ssn like ?";
		int res=0;
		try {
			ps=con.prepareStatement(query);
			ps.setString(1, "%"+id+"%");
			ps.setString(2, "%"+humancode+"%");
			rs=ps.executeQuery();
			
			if(rs.next()) {
				return 1;
			} else {
				return 0;
			}
		} catch (SQLException e) {
			Tool.print("예외 : "+e.getMessage());
		}
		return -1;
	}
	
	
	public boolean updateRiderPW(String pass, String id, String humancode) {
		
		String query="UPDATE member set pass=? where memberID=? and ssn=?";
		
		try {
			ps=con.prepareStatement(query);
			ps.setString(1, pass);
			ps.setString(2, id);
			ps.setString(3, humancode);
			
			ps.execute();
			return true;
		} catch (SQLException e) {
			return false;
		} finally {
			DBCon.close(ps);
		}
	}
	

}
