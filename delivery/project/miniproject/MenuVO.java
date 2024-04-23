package miniproject;

public class MenuVO {

	private String name;
	private int price;
	private String category;
	private int restcode;

	public MenuVO() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getRestcode() {
		return restcode;
	}

	public void setRestcode(int restcode) {
		this.restcode = restcode;
	}
	

	@Override
	public String toString() {
		return "[이름 : " + name + " // 가격 : " + price + "원]";
	}

}
