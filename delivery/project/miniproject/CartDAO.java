package miniproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CartDAO {
	
	private static Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	ArrayList<CartVO> cartlist;
	
	public CartDAO() {
		con=DBCon.getInstance();
	}
	
	// 카트에 음식 담기
	public int addCartList(String memberid, String memberaddress, String restname, String restaddress, String menuname, int price, int rscode) {
		MemberVO mVO=new MemberVO();
		RestVO restVO=new RestVO();
		
		String query="insert into cart (member_id, member_address, rest_name, rest_address, menu_name, price, rest_code) values(?,?,?,?,?,?,?)";
		int result=0;
		try {
			ps=con.prepareStatement(query);
			ps.setString(1, memberid);
			ps.setString(2, memberaddress);
			ps.setString(3, restname);
			ps.setString(4, restaddress);
			ps.setString(5, menuname);
			ps.setInt(6, price);
			ps.setInt(7, rscode);
			result=ps.executeUpdate();
			
			return result;
		} catch(SQLException e) {
			Tool.print("예외발생 : "+e.getMessage());
			return 0;
		} finally {
			DBCon.close(ps);
		}
	}
	
	// 나의 카트 정보 불러오기
	public ArrayList getAllMyCartList(String member_id) {
		cartlist=new ArrayList<CartVO>();
		
		String query="select*from cart where member_id=?";
		
		try {
			ps=con.prepareStatement(query);
			ps.setString(1, member_id);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				CartVO cartVO=new CartVO();
				cartVO.setCartcode(rs.getInt("cart_code"));
				cartVO.setMemberid(rs.getString("member_id"));
				cartVO.setMemberaddress(rs.getString("member_address"));
				cartVO.setRestname(rs.getString("rest_name"));
				cartVO.setRestaddress(rs.getString("rest_address"));
				cartVO.setMenuname(rs.getString("menu_name"));
				cartVO.setPrice(rs.getInt("price"));
				cartVO.setRestcode(rs.getInt("rest_code"));
				
				cartlist.add(cartVO);
			}
		} catch (SQLException e) {
			Tool.print("예외발생 : "+e.getMessage());
		} finally {
			DBCon.close(ps);
			DBCon.close(rs);
		}
		return cartlist;
	}
	
	// 장바구니 주문하기
	public int deleteCart(String member_id) {
		String query="delete from cart where member_id=?";
		int result=0;
		
		try {
			ps=con.prepareStatement(query);
			ps.setString(1, member_id);
			result=ps.executeUpdate();
			
		} catch (SQLException e) {
			Tool.print("예외발생 : "+e.getMessage());
		} finally {
			DBCon.close(ps);
		} return result;
	}

}
