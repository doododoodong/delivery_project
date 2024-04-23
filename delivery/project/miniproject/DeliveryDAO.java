package miniproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DeliveryDAO {

	private static Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	ArrayList<DeliveryVO> dlist;

	public DeliveryDAO() {
		con = DBCon.getInstance();
	}

	public ArrayList<DeliveryVO> getDeliveryList(String rideraddress) {
		dlist = new ArrayList<DeliveryVO>();
		String query = "select*from delivery where member_address like ? and rest_address like ?";

		try {
			ps = con.prepareStatement(query);
			ps.setString(1, rideraddress);
			ps.setString(2, rideraddress);
			rs = ps.executeQuery();

			while (rs.next()) {
				DeliveryVO dVO = new DeliveryVO();
				dVO.setDeliverycode(rs.getInt("del_code"));
				dVO.setOrdercode(rs.getInt("order_code"));
				dVO.setMemberaddress(rs.getString("member_address"));
				dVO.setRestaddress(rs.getString("rest_address"));
				dlist.add(dVO);
			}
		} catch (SQLException e) {
			Tool.print("예외발생 : " + e.getMessage());
		} finally {
			DBCon.close(rs);
			DBCon.close(ps);
		}
		return dlist;
	}

	// 배달리스트에서 삭제(트리거 발생)
	public int deleteList(int deliverycode) {
		String query = "delete from delivery where del_code=?";
		int result = 0;
		try {
			ps = con.prepareStatement(query);
			ps.setInt(1, deliverycode);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			Tool.print("예외발생 : " + e.getMessage());
		}
		return result;
	}

	// 배달코드로 주소지 리턴
	public ArrayList<DeliveryVO> getAddress(int deliverycode) {
		dlist = new ArrayList<DeliveryVO>();
		String query = "select*from b_delivery where del_code=?";

		try {
			ps = con.prepareStatement(query);
			ps.setInt(1, deliverycode);
			rs = ps.executeQuery();

			while (rs.next()) {
				DeliveryVO dVO = new DeliveryVO();
				dVO.setMemberaddress(rs.getString("member_address"));
				dVO.setRestaddress(rs.getString("rest_address"));
				dlist.add(dVO);
			}

		} catch (SQLException e) {
			Tool.print("예외발생 : " + e.getMessage());
		} finally {
			DBCon.close(rs);
			DBCon.close(ps);
		}
		return dlist;
	}

}
