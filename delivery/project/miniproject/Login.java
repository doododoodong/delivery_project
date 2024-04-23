package miniproject;

import java.sql.SQLException;

public class Login {

	private Screen scr;

	int selectNum = 0;

	public Login() {
		scr = new Screen();
	}

	public void selectLogin() throws SQLException {
		DeliveryService ds = new DeliveryService();

		boolean isRun2 = true;

		while (isRun2) {
			Tool.print("<< 로그인하기 >>");
			scr.showLogin();
			selectNum = Tool.selectNum("번호를 선택하세요 >> ");
			Tool.print("");

			switch (selectNum) {

			case 1:
				Tool.print("<<<  일반 로그인  >>>");
				ds.MemberLogin();
				break;

			case 2:
				Tool.print("<<<  사업자 로그인  >>>");
				ds.OwnerLogin();
				break;

			case 3:
				Tool.print("<<<  라이더 로그인  >>>");
				ds.RiderLogin();
				break;

			case 4:
				Tool.print("<< 메인 화면으로 돌아갑니다. >>");
				Tool.print("");
				ds.homeMenu();
				isRun2 = false;
				break;
			}
		}
	}

	public void selectInput() throws SQLException {
		DeliveryService ds = new DeliveryService();

		boolean isRun3 = true;

		while (isRun3) {
			scr.showInput();
			selectNum = Tool.selectNum("번호를 선택하세요 >> ");
			Tool.print("");

			switch (selectNum) {

			case 1:
				Tool.print("<<<  일반 회원가입  >>>");
				ds.inputMember();
				break;

			case 2:
				Tool.print("<<<  사업자 회원가입  >>>");
				ds.inputOwner();
				break;

			case 3:
				Tool.print("<<<  라이더 회원가입  >>>");
				ds.inputRider();
				break;

			case 4:
				Tool.print("돌아가기");
				isRun3 = false;
				break;
			}
		}
	}

	public void selectSearch() throws SQLException {
		boolean isRun4 = true;

		while (isRun4) {
			Tool.print("<< 정보 찾기 >>");
			scr.showSearch();
			selectNum = Tool.selectNum("번호를 선택하세요 >> ");
			Tool.print("");

			switch (selectNum) {

			case 1:
				selectSearchDetailM();
				break;

			case 2:
				selectSearchDetailO();
				break;

			case 3:
				selectSearchDetailR();
				break;

			case 4:
				Tool.print(" << 메인 화면으로 돌아갑니다 >>");
				Tool.print("");
				isRun4=false;
				break;

			}

		}
	}

	public void selectSearchDetailM() throws SQLException {
		DeliveryService ds = new DeliveryService();
		boolean isRun5 = true;

		while (isRun5) {
			Tool.print("<< 사용자 정보 찾기 >>");
			scr.showSearchDetail();
			selectNum = Tool.selectNum("번호를 선택하세요 >> ");
			Tool.print("");

			switch (selectNum) {

			case 1:

				ds.searchMemberID();
				break;

			case 2:
				ds.searchMemberPw();
				break;

			case 3:
				Tool.print("<< 돌아갑니다 >>");
				Tool.print("");
				isRun5 = false;
				break;
			}
		}

	}

	public void selectSearchDetailO() throws SQLException {
		DeliveryService ds = new DeliveryService();
		boolean isRun6 = true;

		while (isRun6) {
			Tool.print("<< 사업주 정보 찾기 >>");
			scr.showSearchDetail();
			selectNum = Tool.selectNum("번호를 선택하세요 >> ");
			Tool.print("");

			switch (selectNum) {

			case 1:
				ds.searchOwnerID();
				break;

			case 2:
				ds.searchOwnerPw();
				break;

			case 3:
				Tool.print("<< 돌아갑니다 >>");
				Tool.print("");
				isRun6 = false;
				break;
			}
		}

	}

	public void selectSearchDetailR() throws SQLException {
		DeliveryService ds=new DeliveryService();
		boolean isRun7 = true;

		while (isRun7) {
			Tool.print("<< 라이더 정보 찾기 >>");
			scr.showSearchDetail();
			selectNum = Tool.selectNum("번호를 선택하세요 >> ");
			Tool.print("");

			switch (selectNum) {

			case 1:
				ds.searchRiderID();
				break;

			case 2:
				ds.searchRiderPw();
				break;

			case 3:
				Tool.print("<< 돌아갑니다 >>");
				Tool.print("");
				isRun7=false;
				break;
			}
		}
	}
}
