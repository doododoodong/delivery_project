package miniproject;

public class DeliveryVO {

	private int deliverycode;
	private int ordercode;
	private String memberaddress;
	private String restaddress;

	public DeliveryVO() {
		// TODO Auto-generated constructor stub
	}

	public DeliveryVO(int deliverycode, int ordercode, String memberaddress, String restaddress) {
		super();
		this.deliverycode = deliverycode;
		this.ordercode = ordercode;
		this.memberaddress = memberaddress;
		this.restaddress = restaddress;
	}

	public int getDeliverycode() {
		return deliverycode;
	}

	public void setDeliverycode(int deliverycode) {
		this.deliverycode = deliverycode;
	}

	public int getOrdercode() {
		return ordercode;
	}

	public void setOrdercode(int ordercode) {
		this.ordercode = ordercode;
	}

	public String getMemberaddress() {
		return memberaddress;
	}

	public void setMemberaddress(String memberaddress) {
		this.memberaddress = memberaddress;
	}

	public String getRestaddress() {
		return restaddress;
	}

	public void setRestaddress(String restaddress) {
		this.restaddress = restaddress;
	}

	@Override
	public String toString() {
		return "[배달코드 = " + deliverycode + ", 주문번호 = " + ordercode + ", 출발지 = " + restaddress+", 도착지 = "
				+ memberaddress+ "]";
	}
	
	

}
