package jwbook.model;

public class Product {
	private String id;
	private String name;
	private String maker;
	private int price;
	private String regdate;
	
	
	
	public Product() {
	}

	public Product(String id, String name, String maker, int price, String regdate) {
		this.id = id;
		this.name = name;
		this.maker = maker;
		this.price = price;
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", maker=" + maker + ", price=" + price + ", regdate=" + regdate
				+ "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
	
}
