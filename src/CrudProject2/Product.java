package CrudProject2;

import java.text.DecimalFormat;

public class Product {

	//필드
	private int pno;
	private String pname;
	private int stock;
	private int price;
	DecimalFormat df = new DecimalFormat("###,###");

	
	//getter, setter
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
}
