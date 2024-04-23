package miniproject;

public class CartVO {

	private int cartcode;
	private String memberid;
	private String memberaddress;
	private String restname;
	private String restaddress;
	private String menuname;
	private int price;
	private int restcode;
	
	public CartVO() {
	}

	public CartVO(int cartcode, String memberid, String memberaddress, String restname, String restaddress, String menuname,
			int price, int restcode) {
		super();
		this.cartcode = cartcode;
		this.memberid = memberid;
		this.memberaddress = memberaddress;
		this.restname=restname;
		this.restaddress = restaddress;
		this.menuname = menuname;
		this.price=price;
		this.restcode = restcode;
	}

	public int getCartcode() {
		return cartcode;
	}

	public void setCartcode(int cartcode) {
		this.cartcode = cartcode;
	}

	public String getMemberid() {
		return memberid;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}

	public String getMemberaddress() {
		return memberaddress;
	}

	public void setMemberaddress(String memberaddress) {
		this.memberaddress = memberaddress;
	}
	
	public String getRestname() {
		return restname;
	}
	
	public void setRestname(String restname) {
		this.restname = restname;
	}

	public String getRestaddress() {
		return restaddress;
	}

	public void setRestaddress(String restaddress) {
		this.restaddress = restaddress;
	}

	public String getMenuname() {
		return menuname;
	}

	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	

	public int getRestcode() {
		return restcode;
	}

	public void setRestcode(int restcode) {
		this.restcode = restcode;
	}

	@Override
	public String toString() {
		return "[가게이름 : "+restname+", 메뉴이름 : "+menuname+", 가격 : "+price+"원]";
	}

	

	
	
	

}
