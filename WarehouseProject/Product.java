package Warehouse;
import DataStructure.*;

public class Product implements Comparable{
//public class Product{
	
	private String name;
	private int price;
	private int barcodeID;
	private String location;
	
	public Product(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.price = 0;
		this.barcodeID = barcodeID;
		this.location = null;
	}
	
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getPrice() {
		return this.price;
	}
	
	public void setPrice(int n) {
		this.price = n;
	}
	
	public int getBarcodeID() {
		return this.barcodeID;
	}
	
	public String getLocation() {
		return this.location;
	}
	
	public void setLocation(String s) {
		this.location = s;
	}
	
}
