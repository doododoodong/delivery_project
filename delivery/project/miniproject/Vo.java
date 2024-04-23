package miniproject;

public class Vo {

	protected static String mcode="member";
	protected static String ocode="owner";
	protected static String rcode="rider";
	protected static String name;
	protected static String humancode;
	protected static String phonenum;
	protected static String email;
	protected static String address;
	

	public Vo() {

	}

	public Vo(String mcode, String ocode, String rcode, String name, String humancode, String phonenum, String email,
			String address) {
		super();
		this.mcode = mcode;
		this.ocode = ocode;
		this.rcode = rcode;
		this.name = name;
		this.humancode = humancode;
		this.phonenum = phonenum;
		this.email = email;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHumancode() {
		return humancode;
	}

	public void setHumancode(String humancode) {
		this.humancode = humancode;
	}

	public String getPhonenum() {
		return phonenum;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMcode() {
		return mcode;
	}

	public void setMcode(String mcode) {
		this.mcode = mcode;
	}

	public String getOcode() {
		return ocode;
	}

	public void setOcode(String ocode) {
		this.ocode = ocode;
	}

	public String getRcode() {
		return rcode;
	}

	public void setRcode(String rcode) {
		this.rcode = rcode;
	}
	
	

}
