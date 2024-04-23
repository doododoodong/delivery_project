package miniproject;

public class Screen {
	
	public void showHome() {
		Tool.print("+---------------------------------------+");
		Tool.print("| 1. 로그인 | 2. 회원가입 | 3. 찾기 | 4. 종료 |");
		Tool.print("+---------------------------------------+");
	}
	
	public void showLogin() {
		Tool.print("+--------------------------------------------------------+");
		Tool.print("| 1. 일반 로그인 | 2. 사업자 로그인 | 3. 라이더 로그인 | 4. 돌아가기 |");
		Tool.print("+--------------------------------------------------------+");
	}
	
	public void showInput() {
		Tool.print("+------------------------------------------------------------+");
		Tool.print("| 1. 일반 회원가입 | 2. 사업자 회원가입 | 3. 라이더 회원가입 | 4. 돌아가기 |");
		Tool.print("+------------------------------------------------------------+");
	}
	
	public void showSearch() {
		Tool.print("+----------------------------------------+");
		Tool.print("| 1. 일반 | 2. 사업자 | 3. 라이더 | 4. 돌아가기 |");
		Tool.print("+----------------------------------------+");
	}
	
	public void showSearchDetail() {
		Tool.print("+---------------------------------+");
		Tool.print("| 1. ID | 2. Password | 3. 돌아가기 |");
		Tool.print("+---------------------------------+");
	}
	
	public void showMemMenu() {
		Tool.print("+--------------------------------------------+");
		Tool.print("| 1. 메뉴 | 2. 메뉴 검색 | 3. 장바구니 | 4. 로그아웃 |");
		Tool.print("+--------------------------------------------+");
		
	}
	
	public void showCategory() {
		System.out.println("+-----------------+");
		System.out.println("|  MENU CATEGORY  |  <돌아가기>"); 
		System.out.println("+-----+-----+-----+");
		System.out.printf ("|%-4s|%-4s|%-4s|\n","치킨","피자","분식");
		System.out.printf ("|%-4s|%-4s|%-4s|\n","족발","보쌈","찌개");
		System.out.printf ("|%-4s|%-4s|%-4s|\n","중식","양식","일식");
		System.out.printf ("|%-4s|%-4s|%-4s|\n","버거","구이","간식");
		System.out.println("+-----+-----+-----+");
	}
	
	public void showOwnerMenu() {
		Tool.print("+------------------------------------------------+");
		Tool.print("| 1. 가게 등록 | 2. 메뉴 추가 | 3. 주문접수 | 4. 로그아웃 |");
		Tool.print("+------------------------------------------------+");
	}
	
	public void showRiderMenu() {
		Tool.print("+--------------------------------------+");
		Tool.print("| 1. 배달 목록 | 2. 배달지 확인 | 3. 로그아웃 |");
		Tool.print("+--------------------------------------+");
	}

}
