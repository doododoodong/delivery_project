package miniproject;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;


public class DeliveryService {

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
	private MemberMenu mm;
	private MenuService ms;
	private OwnerService os;
	private RiderService rs;

	int selectNum;

	public DeliveryService() {
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
		mm = new MemberMenu();
		ms=new MenuService();
		os=new OwnerService();
		rs=new RiderService();
	}

	public void homeMenu() throws SQLException {
		boolean isRun1 = true;

		while (isRun1) {
			scr.showHome();
			selectNum = Tool.selectNum("번호를 선택하세요 >> ");
			Tool.print("");

			switch (selectNum) {

			case 1:
				log.selectLogin();
				break;

			case 2:
				log.selectInput();
				break;

			case 3:
				log.selectSearch();
				break;

			case 4:
				Tool.print("<<< Program END >>>");
				isRun1 = false;
				System.exit(0);
				break;
			}
		}

	}

//	====input==================================================================

	public void inputMember() throws SQLException {

		boolean flag = false;

		do {
			try {

				String id = Tool.selectId("ID : ");
				int res = mDAO.confirmID(id);

				if (res == 1) {
					Tool.print("이미 등록된 아이디입니다.");
					flag = true;
				} else {
					Tool.print("사용 가능한 아이디입니다.");
					mVO.setUserid(id);
					flag = false;
				}

			} catch (InputMismatchException e) {
				Tool.print("예외발생 : " + e.getMessage());
			}
		} while (flag);

		do {
			mVO.setPass(Tool.selectId("Password : "));

			if (mVO.getPass().length() < 8) {
				Tool.print("Password는 8자리 이상만 가능합니다.");
			}
		} while (mVO.getPass().length() < 8);

		do {
			try {
				String name = Tool.selectId("이름 : ");

				if (name.matches("[a-zA-Z]+")) {
					mVO.setName(name);
					flag = false;
				} else {
					throw new InputMismatchException("이름은 문자로만 입력 가능합니다.");
				}
			} catch (InputMismatchException e) {
				Tool.print("예외 발생 : " + e.getMessage());
				flag = true;
			}
		} while (flag);

		do {
			mVO.setHumancode(Tool.selectId("주민등록번호 : "));

			if (mVO.getHumancode().length() != 13) {
				Tool.print("주민등록번호는 13자리 입니다.");
			}
		} while (mVO.getHumancode().length() != 13);

		do {
			Tool.print("010을 제외한 나머지 숫자를 입력해주세요.");
			mVO.setPhonenum(Tool.selectId("휴대폰번호 : "));

			if (mVO.getPhonenum().length() != 8) {
				Tool.print("휴대폰번호는 8자리 입니다.");
			}
		} while (mVO.getPhonenum().length() != 8);

//		do {
//			try {
//				String account = Tool.selectId("계좌번호 : ");
//				int res = mDAO.confirmAccount(account);
//
//				if (res == 1) {
//					Tool.print("이미 등록된 계좌번호 입니다.");
//					flag = true;
//				} else {
//					mVO.setAccount(account);
//					Tool.print("등록 가능한 계좌번호 입니다.");
//					flag = false;
//				}
//			} catch (InputMismatchException e) {
//				Tool.print("예외발생 : " + e.getMessage());
//			}
//		} while (flag);

		mVO.setAddress(Tool.selectId("주소 : "));

		mVO.setEmail(Tool.selectId("email : "));

		int res = mDAO.registerMember(mVO);

		if (res > 0) {
			Tool.print("회원가입 성공!!!");
			Tool.print("");
		} else {
			Tool.print("회원가입 실패!!!");
			Tool.print("");
		}

	}

//	--------------------------------------------------------------------------

	public void inputOwner() throws SQLException {

		boolean flag = false;

		do {
			try {
				String id = Tool.selectId("ID : ");
				int res = oDAO.confirmID(id);

				if (res == 1) {
					Tool.print("이미 등록된 아이디입니다.");
					flag = true;
				} else {
					Tool.print("사용 가능한 아이디입니다.");
					oVO.setOwnerid(id);
					flag = false;
				}
			} catch (InputMismatchException e) {
				Tool.print("예외발생 : " + e.getMessage());
			}
		} while (flag);

		do {
			oVO.setPass(Tool.selectId("Password : "));

			if (oVO.getPass().length() < 8) {
				Tool.print("Password는 8자리 이상만 가능합니.");
			}
		} while (oVO.getPass().length() < 8);

		do {
			try {
				String name = Tool.selectId("이름 : ");

				if (name.matches("[a-zA-Z]+")) {
					oVO.setName(name);
					flag = false;
				} else {
					throw new InputMismatchException("이름은 문자로만 입력 가능합니다.");
				}
			} catch (InputMismatchException e) {
				Tool.print("예외발생 : " + e.getMessage());
				flag = true;
			}
		} while (flag);

		do {
			oVO.setHumancode(Tool.selectId("주민등록번호 : "));

			if (oVO.getHumancode().length() != 13) {
				Tool.print("주민등록번호는 13자리 입니다.");
			}
		} while (oVO.getHumancode().length() != 13);

		do {
			Tool.print("010을 제외한 나머지 숫자를 입력해주세요.");
			oVO.setPhonenum(Tool.selectId("휴대폰번호 : "));

			if (oVO.getPhonenum().length() != 8) {
				Tool.print("휴대폰번호는 8자리 입니다.");
			}
		} while (oVO.getPhonenum().length() != 8);

//		do {
//			try {
//				String account = Tool.selectId("계좌번호 : ");
//				int res = oDAO.confirmAccount(account);
//
//				if (res == 1) {
//					Tool.print("이미 등록된 계좌번호 입니다.");
//					flag = true;
//				} else {
//					oVO.setAccount(account);
//					Tool.print("등록 가능한 계좌번호 입니다.");
//					flag = false;
//				}
//			} catch (InputMismatchException e) {
//				Tool.print("예외발생 : " + e.getMessage());
//			}
//		} while (flag);
		oVO.setAddress(Tool.selectId("주소 : "));

		oVO.setEmail(Tool.selectId("email : "));

		int res = oDAO.registerMember(oVO);

		if (res > 0) {
			Tool.print("회원가입 성공!!!");
			Tool.print("");
		} else {
			Tool.print("회원가입 실패!!!");
			Tool.print("");
		}
	}

//	--------------------------------------------------------------------------

	public void inputRider() throws SQLException {

		boolean flag = false;

		do {
			try {
				String id = Tool.selectId("ID : ");
				int res = rDAO.confirmID(id);

				if (res == 1) {
					Tool.print("이미 등록된 아이디입니다.");
					flag = true;
				} else {
					Tool.print("사용 가능한 아이디입니다.");
					rVO.setRiderid(id);
					flag = false;
				}
			} catch (InputMismatchException e) {
				Tool.print("예외발생 : " + e.getMessage());
			}
		} while (flag);

		do {
			rVO.setPass(Tool.selectId("Password : "));

			if (rVO.getPass().length() < 8) {
				Tool.print("Password는 8자리 이상만 가능합니.");
			}
		} while (rVO.getPass().length() < 8);

		do {
			try {
				String name = Tool.selectId("이름 : ");

				if (name.matches("[a-zA-Z]+")) {
					rVO.setName(name);
					flag = false;
				} else {
					throw new InputMismatchException("이름은 문자로만 입력 가능합니다.");
				}
			} catch (InputMismatchException e) {
				Tool.print("예외발생 : " + e.getMessage());
				flag = true;
			}
		} while (flag);

		do {
			rVO.setHumancode(Tool.selectId("주민등록번호 : "));

			if (rVO.getHumancode().length() != 13) {
				Tool.print("주민등록번호는 13자리 입니다.");
			}
		} while (rVO.getHumancode().length() != 13);

		do {
			Tool.print("010을 제외한 나머지 숫자를 입력해주세요.");
			rVO.setPhonenum(Tool.selectId("휴대폰번호 : "));

			if (rVO.getPhonenum().length() != 8) {
				Tool.print("휴대폰번호는 8자리 입니다.");
			}
		} while (rVO.getPhonenum().length() != 8);

//		do {
//			try {
//				String account = Tool.selectId("계좌번호 : ");
//				int res = rDAO.confirmAccount(account);
//
//				if (res == 1) {
//					Tool.print("이미 등록된 계좌번호 입니다.");
//					flag = true;
//				} else {
//					rVO.setAccount(account);
//					Tool.print("등록 가능한 계좌번호 입니다.");
//					flag = false;
//				}
//			} catch (InputMismatchException e) {
//				Tool.print("예외발생 : " + e.getMessage());
//			}
//		} while (flag);
		rVO.setAddress(Tool.selectId("주소 : "));

		rVO.setEmail(Tool.selectId("email : "));

		int res = rDAO.registerMember(rVO);

		if (res > 0) {
			Tool.print("회원가입 성공!!!");
			Tool.print("");
		} else {
			Tool.print("회원가입 실패!!!");
			Tool.print("");
		}

	}

//	==========================================================================
//	====search id=============================================================

	public void searchMemberID() {

		String name = Tool.selectId("이름 : ");
		String humancode = Tool.selectId("주민등록번호 : ");

		ArrayList<MemberVO> list = mDAO.getSearchID(name, humancode);

		Iterator<MemberVO> iterator = list.iterator();

		while (iterator.hasNext()) {
			MemberVO ar = iterator.next();
			Tool.print("아이디 : " + ar.getUserid());
		}
		Tool.print("");
	}

//	--------------------------------------------------------------------------

	public void searchOwnerID() {

		String name = Tool.selectId("이름 : ");
		String humancode = Tool.selectId("주민등록번호 : ");

		ArrayList<OwnerVO> list = oDAO.getSearchID(name, humancode);

		Iterator<OwnerVO> iterator = list.iterator();

		while (iterator.hasNext()) {
			OwnerVO ar = iterator.next();
			Tool.print(ar.getOwnerid());
		}
		Tool.print("");
	}

//	--------------------------------------------------------------------------

	public void searchRiderID() {

		String name = Tool.selectId("이름 : ");
		String humancode = Tool.selectId("주민등록번호 : ");

		ArrayList<RiderVO> list = rDAO.getSearchID(name, humancode);

		Iterator<RiderVO> iterator = list.iterator();

		while (iterator.hasNext()) {
			RiderVO ar = iterator.next();
			Tool.print(ar.getRiderid());
		}
		Tool.print("");

	}

//	===========================================================================
//	====search PW==============================================================

	public void searchMemberPw() throws SQLException {

		String id = Tool.selectId("아이디 : ");
		String humancode = Tool.selectId("주민등록번호 : ");

		int res = mDAO.getSearchPW(id, humancode);

		Tool.print("변경할 비밀번호를 입력하세요.");
		String pass;

		if (res == 1) {
			do {
				pass = Tool.selectId("비밀번호 : ");
				mVO.setPass(pass);
				if (mVO.getPass().length() < 8) {
					Tool.print("비밀번호는 8자 이상만 가능합니다.");
				}
			} while (mVO.getPass().length() < 8);

			boolean bool = mDAO.updateMemberPW(pass, id, humancode);

			if (bool) {
				Tool.print("변경 성공");
			} else {
				Tool.print("변경 실패");
			}

		} else {
			Tool.print("등록된 정보가 없습니다.");

			homeMenu();
		}

	}

//	---------------------------------------------------------------------------

	public void searchOwnerPw() throws SQLException {

		String id = Tool.selectId("아이디 : ");
		String humancode = Tool.selectId("주민등록번호 : ");

		int res = oDAO.getSearchPW(id, humancode);

		Tool.print("변경할 비밀번호를 입력하세요.");
		String pass;

		if (res == 1) {
			do {
				pass = Tool.selectId("비밀번호 : ");
				oVO.setPass(pass);
				if (oVO.getPass().length() < 8) {
					Tool.print("비밀번호는 8자 이상만 가능합니다.");
				}
			} while (oVO.getPass().length() < 8);

			boolean bool = oDAO.updateOwnerPW(pass, id, humancode);

			if (bool) {
				Tool.print("변경 성공");
			} else {
				Tool.print("변경 실패");
			}

		} else {
			Tool.print("등록된 정보가 없습니다.");

			homeMenu();
		}
	}

//	---------------------------------------------------------------------------

	public void searchRiderPw() throws SQLException {

		String id = Tool.selectId("아이디 : ");
		String humancode = Tool.selectId("주민등록번호 : ");

		int res = rDAO.getSearchPW(id, humancode);

		Tool.print("변경할 비밀번호를 입력하세요.");
		String pass;

		if (res == 1) {
			do {
				pass = Tool.selectId("비밀번호 : ");
				rVO.setPass(pass);
				if (rVO.getPass().length() < 8) {
					Tool.print("비밀번호는 8자 이상만 가능합니다.");
				}
			} while (rVO.getPass().length() < 8);

			boolean bool = rDAO.updateRiderPW(pass, id, humancode);

			if (bool) {
				Tool.print("변경 성공");
			} else {
				Tool.print("변경 실패");
			}

		} else {
			Tool.print("등록된 정보가 없습니다.");

			homeMenu();
		}

	}

//	===========================================================================
//  ====Login==================================================================

	public void MemberLogin() throws SQLException {

		boolean flag = false;
		int count = 1;

		do {
			String id = Tool.selectId("ID : ");
			String pass = Tool.selectId("PassWord : ");

			ArrayList<MemberVO> lists = mDAO.SearchID(id);
			Iterator<MemberVO> iterator = lists.iterator();

			MemberVO ar = null;
			while (iterator.hasNext()) {
				ar = iterator.next();
			}
			if (count == 3) {
				Tool.print("연속 3회 로그인에 실패하여 초기화면으로 돌아갑니다.");
				Tool.print("");
				homeMenu();
				flag = false;
			} else {

				if (ar != null) {
					if (ar.getUserid().equals(id) && ar.getMgcode().equals(mVO.getMcode())) {
						if (ar.getPass().equals(pass)) {
							Tool.print("로그인 성공!!!");
							Tool.print("");
							ms.Menu();
							flag = false;
						} else {
							Tool.print("비밀번호가 틀립니다!!");
							Tool.print("");
							count += 1;
							flag = true;
						}
					}

				} else {
					Tool.print("등록된 ID가 없습니다.");
					Tool.print("");
					count += 1;
					flag = true;
				}
			}
		} while (flag);

	}

//	---------------------------------------------------------------------------

	public void OwnerLogin() throws SQLException {

		boolean flag = false;
		int count = 1;

		do {
			String id = Tool.selectId("ID : ");
			String pass = Tool.selectId("PassWord : ");

			ArrayList<OwnerVO> lists = oDAO.SearchID(id);
			Iterator<OwnerVO> iterator = lists.iterator();

			OwnerVO ar = null;
			while (iterator.hasNext()) {
				ar = iterator.next();
			}
			if (count == 3) {
				Tool.print("연속 3회 로그인에 실패하여 초기화면으로 돌아갑니다.");
				Tool.print("");
				homeMenu();
				flag = false;
			} else {

				if (ar != null) {
					if (ar.getOwnerid().equals(id) && ar.getOgcode().equals(oVO.getOcode())) {
						if (ar.getPass().equals(pass)) {
							Tool.print("로그인 성공!!!");
							Tool.print("");
							os.Menu();
							flag = false;
						} else {
							Tool.print("비밀번호가 틀립니다!!");
							Tool.print("");
							count += 1;
							flag = true;
						}
					}

				} else {
					Tool.print("등록된 ID가 없습니다.");
					Tool.print("");
					count += 1;
					flag = true;
				}
			}
		} while (flag);

	}

//	---------------------------------------------------------------------------

	public void RiderLogin() throws SQLException {

		boolean flag = false;
		int count = 1;

		do {
			String id = Tool.selectId("ID : ");
			String pass = Tool.selectId("PassWord : ");

			ArrayList<RiderVO> lists = rDAO.SearchID(id);
			Iterator<RiderVO> iterator = lists.iterator();

			RiderVO ar = null;
			while (iterator.hasNext()) {
				ar = iterator.next();
			}
			if (count == 3) {
				Tool.print("연속 3회 로그인에 실패하여 초기화면으로 돌아갑니다.");
				Tool.print("");
				homeMenu();
				flag = false;
			} else {

				if (ar != null) {
					if (ar.getRiderid().equals(id) && ar.getRgcode().equals(mVO.getRcode())) {
						if (ar.getPass().equals(pass)) {
							Tool.print("로그인 성공!!!");
							Tool.print("");
							rs.Menu();
							flag = false;
						} else {
							Tool.print("비밀번호가 틀립니다!!");
							Tool.print("");
							count += 1;
							flag = true;
						}
					}

				} else {
					Tool.print("등록된 ID가 없습니다.");
					Tool.print("");
					count += 1;
					flag = true;
				}
			}
		} while (flag);
	}

//	==============================================================================
//	==== Menu ====================================================================
	
	public void listAllMenu () {
		
		ArrayList<MenuVO> list = menuDAO.getAllMenu();
		Tool.print("MemberVO의 내용 출력");

		Iterator<MenuVO> iterator = list.iterator();

		while (iterator.hasNext()) {
			MenuVO ar = iterator.next();
			Tool.print(ar.toString());
		}
		
	}
	
//	-----------------------------------------------------------------------------
	
	
}
