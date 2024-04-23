package miniproject;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MenuService {

	private MemberVO mVO;
	private MenuDAO menuDAO;
	private MenuVO menuVO;
	private RestDAO restDAO;
	private RestVO restVO;
	private CartDAO cartDAO;
	private MemberMenu mm;
	private Screen scr;

	int selectNum = 0;

	public MenuService() {
		mVO = new MemberVO();
		menuDAO = new MenuDAO();
		menuVO = new MenuVO();
		restDAO = new RestDAO();
		restVO = new RestVO();
		cartDAO = new CartDAO();
		mm = new MemberMenu();
		scr = new Screen();
	}

	public void Menu() throws SQLException {
		DeliveryService ds = new DeliveryService();

		boolean isRun = true;

		while (isRun) {
			scr.showMemMenu();
			selectNum = Tool.selectNum("번호를 선택하세요 >> ");
			Tool.print("");

			switch (selectNum) {

			case 1:
				Tool.print("<< 메뉴 카테고리 >>");
				mm.selectCategory();
				break;

			case 2:
				Tool.print("<< 메뉴 검색 >>");
				mm.searchingMenu();
				break;

			case 3:
				Tool.print("<< 내 장바구니 >>");
				mm.cart();
				break;
			case 4:
				Tool.print("처음 화면으로 돌아갑니다.");
				ds.homeMenu();
				isRun = false;
				break;
			}
		}
	}

//	------------------------------------------------------------------------------
//	==== Call Restaurant by Category =============================================

	public void getRest(String category) throws SQLException {
		ArrayList<RestVO> list = menuDAO.getRestbyCategory(category);
		Iterator<RestVO> iterator = list.iterator();

		while (iterator.hasNext()) {
			RestVO ar = iterator.next();
			Tool.print(ar.toString());

		}
		String name = Tool.selectId("가게 이름 : ");
		Tool.print("");

		getMenuInRest(restDAO.getRestCodeByName(name));
//		System.out.println(restDAO.getRestCode(name));

	}

	public void getMenuInRest(int restcode) throws SQLException {

		ArrayList<MenuVO> menulist = menuDAO.getMenuByRestCode(restcode);

		Iterator<MenuVO> menuiterator = menulist.iterator();
		MenuVO menuar = null;
		while (menuiterator.hasNext()) {
			menuar = menuiterator.next();
			Tool.print(menuar.toString());
		}
		String menuname = Tool.selectId("메뉴 이름 >> ");
		String memberid = mVO.getUserid();
		String memberaddress = mVO.getAddress();

		int price = menuDAO.getMenuByName(menuname, restcode);

		ArrayList<RestVO> restlist = restDAO.getRestByRestCode(restcode);
		Iterator<RestVO> restiterator = restlist.iterator();
		RestVO restar = null;

		while (restiterator.hasNext()) {
			restar = restiterator.next();
		}
		String restname = restar.getName();
		String restaddress = restar.getAddress();

		int rscode = restar.getRestcode();

		Tool.print("1. 카트에 담기 2. 뒤로가기");
		selectNum = Tool.selectNum("번호 >> ");
		if (selectNum == 1) {
			int result = cartDAO.addCartList(memberid, memberaddress, restname, restaddress, menuname, price, rscode);
			if (result > 0) {
				Tool.print("메뉴가 카트에 담겼습니다.");
				Menu();
			} else {
				Tool.print("카트에 담기 실패");
			}
		} else if (selectNum == 2) {
			Menu();
		}
	}
}
