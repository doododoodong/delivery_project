package miniproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDAO {
	
	private static Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	ArrayList<OrderVO> olist;
	
	public OrderDAO() {
		con=DBCon.getInstance();
	}
	
	// DAO를통해 리스트를 가져온다
	public ArrayList<OrderVO> getListByRestCode(int restcode) {
		olist=new ArrayList<OrderVO>();
		String query="select*from `order` where rest_code=?";
		
		try {
			ps=con.prepareStatement(query);
			ps.setInt(1, restcode);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				OrderVO oVO=new OrderVO();
				oVO.setOrdercode(rs.getInt("order_code"));
				oVO.setCartcode(rs.getInt("cart_code"));
				oVO.setMemberid(rs.getString("member_id"));
				oVO.setMemberaddress(rs.getString("member_address"));
				oVO.setRestname(rs.getString("rest_name"));
				oVO.setRestaddress(rs.getString("rest_address"));
				oVO.setMenuname(rs.getString("menu_name"));
				oVO.setPrice(rs.getInt("price"));
				oVO.setRestcode(rs.getInt("rest_code"));
				olist.add(oVO);
			}
		} catch (SQLException e) {
			Tool.print("예외발생 : "+e.getMessage());
		} finally {
			DBCon.close(rs);
			DBCon.close(ps);
		}
		return olist;
	}
	
	//전달받은 오더코드로 리스트 삭제
	public int deleteList(int ordercode) {
		String query="delete from `order` where order_code=?";
		int result=0;
		try {
			ps=con.prepareStatement(query);
			ps.setInt(1, ordercode);
			result=ps.executeUpdate();
		} catch (SQLException e) {
			Tool.print("예외발생 : "+e.getMessage());
		}
		return result;
	}

}
