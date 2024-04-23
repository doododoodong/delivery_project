package miniproject;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

public class OwnerService {
	
	private MemberDAO mDAO;
	private MemberVO mVO;
	private OwnerDAO oDAO;
	private OwnerVO oVO;
	private RiderDAO rDAO;
	private RiderVO rVO;
	private Screen scr;
	private Login log;
	private MenuVO menuVO;
	private MenuDAO menuDAO;
	private RestVO restVO;
	private RestDAO restDAO;
	private OrderDAO orderDAO;
	private OrderVO orderVO;

	int selectNum;
	
	public OwnerService() {
		mDAO = new MemberDAO();
		mVO = new MemberVO();
		oDAO = new OwnerDAO();
		oVO = new OwnerVO();
		rDAO = new RiderDAO();
		rVO = new RiderVO();
		scr = new Screen();
		log = new Login();
		menuDAO=new MenuDAO();
		menuVO=new MenuVO();
		restVO=new RestVO();
		restDAO=new RestDAO();
		orderDAO=new OrderDAO();
		orderVO=new OrderVO();
	}
	
	// 사장님의 메뉴를 보여주고 선택
	public void Menu() throws SQLException {
		DeliveryService ds=new DeliveryService();
		boolean isRun=true;
		
		while (isRun) {
			scr.showOwnerMenu();
			selectNum=Tool.selectNum("번호를 선택하세요 >> ");
			Tool.print("");
			
			switch(selectNum) {
			
			case 1:
				Tool.print("<< 가게를 등록합니다!!>>");
				inputRestInfo();
				break;
				
			case 2:
				Tool.print("<< 메뉴를 등록합니다!! >>");
				inputMenuInfo();
				break;
				
			case 3:
				Tool.print("주문을 확인합니다!!");
				CheckOrder();
				break;
				
			case 4:
				Tool.print("초기 화면으로 돌아갑니다.");
				ds.homeMenu();
				isRun=false;
				break;
			}
		}
	}
	
	// 등록할 가게 정보 입력, 확인 -> restDAO로 전달.
	public void inputRestInfo() {
		
		String ownerid=oVO.getOwnerid();
		String restaddress=Tool.selectIdL("주소 : ");
		Tool.print("");
		String restname=Tool.selectId("상호명 : ");
		Tool.print("");
		String category=Tool.selectId("카테고리 : ");
		
		int result=restDAO.registRest(ownerid, restaddress, restname, category);
		if(result > 0) {
			Tool.print("가게 등록 성공!!");
		} else {
			Tool.print("가게 등록 실패!!");
		}
	}
	
	// 등록할 메뉴 정보를 입력, 확인 -> menuDAO로 전달
	public void inputMenuInfo() throws SQLException {
		
		int restcode=restDAO.getRestCodeById(oVO.getOwnerid());
		String name=Tool.selectId("메뉴 이름 : ");
		int price=Tool.selectNum("메뉴 가격 : ");
		String category=Tool.selectId("카테고리 : ");
		
		int result=menuDAO.registerMenu(restcode, name, price, category);
		if(result > 0) {
			Tool.print("메뉴 등록 성공!!");
		} else {
			Tool.print("메뉴 등록 실패!!");
		}
	}
	
	// 가게의 정보로 나의 나게의 오더를 확인하고 수락
	public void CheckOrder() {
		//사장ID로 가게코드 가져오기
		String ownerid=oVO.getOwnerid();
		int restcode=restDAO.getRestCodeById(ownerid);
		
		//order테이블에서 가게코드와 같은 결과물 가져오기
		ArrayList<OrderVO> list=orderDAO.getListByRestCode(restcode);
		Iterator<OrderVO> iterator=list.iterator();
		while(iterator.hasNext()) {
			OrderVO ar=iterator.next();
			Tool.print(ar.toString());
		}
		
		//오더코드로 오더데이터 삭제(트리거발생)
		int ordercode=Tool.selectNum("수락할 오더번호를 입력하세요 >> ");
		int res=orderDAO.deleteList(ordercode);
		
		if(res > 0) {
			Tool.print("주문 접수!!!");
		} else {
			Tool.print("주문 접수 실패!!!");
		}
	}

}
