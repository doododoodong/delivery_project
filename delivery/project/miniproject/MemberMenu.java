package miniproject;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

public class MemberMenu {

	private Screen scr;
	private MemberVO mVO;
	private MenuDAO menuDAO;
	private RestDAO restDAO;
	private CartDAO cartDAO;
	private CartVO cartVO;

	int selectNum = 0;
	String selectID = "";

	public MemberMenu() {
		scr = new Screen();
		mVO = new MemberVO();
		menuDAO = new MenuDAO();
		restDAO = new RestDAO();
		cartDAO = new CartDAO();
		cartVO = new CartVO();
	}

	public void selectCategory() throws SQLException {
		MenuService ms = new MenuService();

		boolean isRun = true;

		while (isRun) {
			scr.showCategory();
			selectID = Tool.selectId("카테고리를 입력하세요 >> ");
			Tool.print("");

			if (selectID.equals("돌아가기")) {
				isRun = false;
			} else {
				ms.getRest(selectID);
			}

		}
	}

	// 메뉴를 검색한다.
	public void searchingMenu() throws SQLException {
		MenuService ms = new MenuService();
		String keyword = Tool.selectId("찾기 : ");
		ArrayList<RestVO> list = menuDAO.getRestbyCategory(keyword);
		Iterator<RestVO> iterator = list.iterator();

		while (iterator.hasNext()) {
			RestVO ar = iterator.next();
			Tool.print(ar.toString());

		}
		String name = Tool.selectId("가게 이름 : ");
		Tool.print("");

		ms.getMenuInRest(restDAO.getRestCodeByName(name));
	}

	// 로그인한 사람의 카트정보를 불러온다
	
	public void cart() throws SQLException {
		MenuService ms = new MenuService();
		ArrayList<CartVO> list = cartDAO.getAllMyCartList(mVO.getUserid());

		Iterator<CartVO> iterator = list.iterator();

		CartVO cart = null;
		while (iterator.hasNext()) {
			cart = iterator.next();
			Tool.print(cart.toString());
		}

		Tool.print("");

		Tool.print("장바구니를 주문하시겠습니까?");
		Tool.print("1. 주문 2. 뒤로가기 ");
		selectNum = Tool.selectNum("번호를 선택하세요 >> ");

		if (selectNum == 1) {

			int res = cartDAO.deleteCart(mVO.getUserid());
			if (res > 0) {
				Tool.print("주문 완료!!!");
				Tool.print("");
			} else {
				Tool.print("주문 실패");
				ms.Menu();
			}

		} else if (selectNum == 2) {
			ms.Menu();
		}

	}

}
