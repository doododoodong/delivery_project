package miniproject;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

public class RiderService {

	private RiderVO rVO;
	private Screen scr;
	private DeliveryDAO deliveryDAO;

	int selectNum;

	public RiderService() {
		rVO = new RiderVO();
		scr = new Screen();
		deliveryDAO = new DeliveryDAO();
	}

	public void Menu() throws SQLException {
		DeliveryService ds = new DeliveryService();

		boolean isRun = true;

		while (isRun) {
			scr.showRiderMenu();
			selectNum = Tool.selectNum("번호를 선택하세요 >> ");
			Tool.print("");

			switch (selectNum) {

			case 1:
				DeliveryList();
				break;

			case 2:
				CheckAddress();
				break;

			case 3:
				Tool.print("초기회면으로 돌아갑니다.");
				ds.homeMenu();
				break;
			}
		}
	}

	// 내 주소지 주변 배달목록 불러오기, 수락하기 ->
	public void DeliveryList() {
		String rideraddress = rVO.getAddress();
		ArrayList<DeliveryVO> list = deliveryDAO.getDeliveryList(rideraddress);
		Iterator<DeliveryVO> iterator = list.iterator();
		while (iterator.hasNext()) {
			DeliveryVO ar = iterator.next();
			Tool.print(ar.toString());
		}

		// 오더코드로 오더데이터 삭제(트리거발생)
		int deliverycode = Tool.selectNum("수락할 배달코드를 입력하세요 >> ");
		int res = deliveryDAO.deleteList(deliverycode);

		if (res > 0) {
			Tool.print("배달 수락!!!");
		} else {
			Tool.print("배달 수락 실패!!!");
		}System.out.println();
	}
	
	//배달 주소 확인
	public void CheckAddress() {
		int deliverycode=Tool.selectNum("배달코드 입력 >> ");
		ArrayList<DeliveryVO> list=deliveryDAO.getAddress(deliverycode);
		Iterator<DeliveryVO> iterator = list.iterator();
		while(iterator.hasNext()) {
			DeliveryVO ar = iterator.next();
			Tool.print("출발지 : "+ar.getRestaddress()+", 도착지 : "+ar.getMemberaddress());
		}
		Tool.print("");
	}
}
