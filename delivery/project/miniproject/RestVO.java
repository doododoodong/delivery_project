package miniproject;

public class RestVO {

	private int restcode;
	private String ownerID;
	private String category;
	private String name;
	private String address;

	public RestVO() {

	}

	public RestVO(int restcode, String ownerID, String category, String name, String address) {
		super();
		this.ownerID=ownerID;
		this.restcode=restcode;
		this.category = category;
		this.name = name;
		this.address = address;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getOwnerID() {
		return ownerID;
	}
	
	public void setOwnerID(String ownerID) {
		this.ownerID = ownerID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public int getRestcode() {
		return restcode;
	}
	
	public void setRestcode(int restcode) {
		this.restcode = restcode;
	}

	@Override
	public String toString() {
		return "[ "+name + " -  " + address + "]";
	}
	
	

}
