package miniproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.crypto.spec.RC2ParameterSpec;


public class MenuDAO {
	
	private static Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	ArrayList<MenuVO> mlist;
	ArrayList<RestVO> rlist;
	
	public MenuDAO() {
		con=DBCon.getInstance();
	}
	
	public int registerMenu(int restcode, String name, int price, String category) throws SQLException {
		
		String query="insert into menu (restCode, name, price, menu_category) values(?,?,?,?)";
		int result=0;
		
		try {
			ps=con.prepareStatement(query);
			ps.setInt(1, restcode);
			ps.setString(2, name);
			ps.setInt(3, price);
			ps.setString(4, category);
			result=ps.executeUpdate();
			
			return result;
			
		} finally {
			DBCon.close(ps);
		}
	}
	
//	------------------------------------------------------------------------------
	
	public ArrayList<MenuVO> getAllMenu() {

		mlist = new ArrayList<MenuVO>();
		String query = "select*from menu";
		try {
			ps = con.prepareStatement(query);
			rs = ps.executeQuery(); // 결과물을 rs에 저장
			while (rs.next()) {
				MenuVO vo = new MenuVO();
				vo.setName(rs.getString("name"));
				vo.setPrice(rs.getInt("price"));
				mlist.add(vo);
			}
		} catch (SQLException e) {
			Tool.print("예외 : " + e.getMessage());
		} finally {
			DBCon.close(rs);
			DBCon.close(ps);
		}
		return mlist;
	}
	
//	------------------------------------------------------------------------------
	
	public ArrayList<RestVO> getRestbyCategory(String category) {
		
		rlist=new ArrayList<RestVO>();
		String query="select*from restaurant where rest_category=?";
		
		try {
			ps=con.prepareStatement(query);
			ps.setString(1, category);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				RestVO vo=new RestVO();
				vo.setRestcode(rs.getInt("restCode"));
				vo.setCategory(rs.getString("rest_category"));
				vo.setName(rs.getString("rest_name"));
				vo.setAddress(rs.getString("rest_address"));
				
				rlist.add(vo);
			}
		} catch (SQLException e) {
			Tool.print("예외발생 : "+e.getMessage());
		} finally {
			DBCon.close(ps);
			DBCon.close(rs);
		}
		return rlist;
	}
	
	public ArrayList<MenuVO> getMenuByRestCode(int rest_code){
		mlist=new ArrayList<MenuVO>();
		String query="select*from menu where restCode=?";
		
		try {
			ps=con.prepareStatement(query);
			ps.setInt(1, rest_code);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				MenuVO menuVO=new MenuVO();
				
				menuVO.setName(rs.getString("name"));
				menuVO.setPrice(rs.getInt("price"));
				menuVO.setCategory(rs.getString("menu_category"));
				menuVO.setRestcode(rs.getInt("restCode"));
				
				mlist.add(menuVO);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return mlist;
	}
	
	// restcode와 메뉴 이름으로 가격찾기
	public int getMenuByName(String name, int restcode) {
		String query="select price from menu where name=? and restCode=?;";
		
		try {
			ps=con.prepareStatement(query);
			ps.setString(1, name);
			ps.setInt(2, restcode);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				return rs.getInt("price");
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DBCon.close(ps);
			DBCon.close(rs);
		}
		return 0;
	}
	
}
