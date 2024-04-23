package miniproject;

public class MemberVO extends Vo {

	private static String mgcode;
	private static String userid;
	private static String pass;

	public MemberVO() {

	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public String getMgcode() {
		return mgcode;
	}
	
	public void setMgcode(String mgcode) {
		this.mgcode = mgcode;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return super.getName();
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		super.setName(name);
	}

	@Override
	public String getHumancode() {
		// TODO Auto-generated method stub
		return super.getHumancode();
	}

	@Override
	public void setHumancode(String humancode) {
		// TODO Auto-generated method stub
		super.setHumancode(humancode);
	}

	@Override
	public String getPhonenum() {
		// TODO Auto-generated method stub
		return super.getPhonenum();
	}

	@Override
	public void setPhonenum(String phonenum) {
		// TODO Auto-generated method stub
		super.setPhonenum(phonenum);
	}

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return super.getEmail();
	}

	@Override
	public void setEmail(String email) {
		// TODO Auto-generated method stub
		super.setEmail(email);
	}

	@Override
	public String getAddress() {
		// TODO Auto-generated method stub
		return super.getAddress();
	}

	@Override
	public void setAddress(String address) {
		// TODO Auto-generated method stub
		super.setAddress(address);
	}

	@Override
	public String getMcode() {
		// TODO Auto-generated method stub
		return super.getMcode();
	}

	public MemberVO(String mgcode, String userid, String pass) {
		super();
		this.mgcode = mgcode;
		this.userid = userid;
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "MemberVO [mgcode=" + mgcode + ", userid=" + userid + ", pass=" + pass + "]";
	}

	

	

}
