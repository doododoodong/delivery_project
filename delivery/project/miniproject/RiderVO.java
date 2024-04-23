package miniproject;

public class RiderVO extends Vo {

	private static String rgcode;
	private static String riderid;
	private static String pass;
	private static String vehicle;

	public RiderVO() {

	}

	public RiderVO(String rgcode, String riderid, String pass, String vehicle) {
		super();
		this.rgcode = rgcode;
		this.riderid = riderid;
		this.pass = pass;
		this.vehicle = vehicle;
	}

	public String getRiderid() {
		return riderid;
	}

	public void setRiderid(String riderid) {
		this.riderid = riderid;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getVehicle() {
		return vehicle;
	}

	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}

	public String getRgcode() {
		return rgcode;
	}

	public void setRgcode(String rgcode) {
		this.rgcode = rgcode;
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
	public String getRcode() {
		// TODO Auto-generated method stub
		return super.getRcode();
	}

}