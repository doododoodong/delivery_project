package miniproject;

public class OwnerVO extends Vo {

	private static String ogcode;
	private static String ownerid;
	private static String pass;

	public OwnerVO() {

	}

	public OwnerVO(String ogcode, String ownerid, String pass) {
		super();
		this.ogcode = ogcode;
		this.ownerid = ownerid;
		this.pass = pass;
	}

	public String getOwnerid() {
		return ownerid;
	}

	public void setOwnerid(String ownerid) {
		this.ownerid = ownerid;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getOgcode() {
		return ogcode;
	}

	public void setOgcode(String ogcode) {
		this.ogcode = ogcode;
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
	public String getOcode() {
		// TODO Auto-generated method stub
		return super.getOcode();
	}

}