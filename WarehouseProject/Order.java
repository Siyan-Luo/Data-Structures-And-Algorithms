package Warehouse;
import DataStructure.*;

public class Order implements Comparable{
//	store the items of the order in a dictionary tree
//	where key stores the product name, value stores the linked list of the product
	private DictionaryTree items;
	private int ownerID;
	private int orderID;
	
	public Order(int ownerID) {
		// TODO Auto-generated constructor stub
		items = new DictionaryTree();
		this.ownerID = ownerID;
	}
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public int getOwner() {
		return this.ownerID;
	}
	
	public void setOrderId(int id) {
		this.orderID=id;
	}
	
	public DictionaryTree getItems() {
		return this.items;
	}
	
	/*
	 * Method add items to the order.
	 * @param	productName unique identifier of the product to be added
	 * @param	quantity	number of product items added to the order
	 */
	public void addItem(String productName, int quantity) {
//		first check if this kind of product item is in the order
		LinkedList item = (LinkedList) items.findKey(productName);
//		O(H)
		if (item!=null) {
//			this kind of product already exists
			for (int i=0;i<quantity;i++) {
				Product p = new Product(productName);
				item.addFirst(p);
//				O(1)
			}
//			O(n)
		}else {
//			create a new linked list to store this new type of product
			LinkedList newItem = new LinkedList();
			for (int i=0;i<quantity;i++) {
				Product p = new Product(productName);
				newItem.addFirst(p);
//				O(1)
			}
//			O(n)
			items.add(productName, newItem);
//			O(H)
		}
//		T.C = O(n)
	}	
}
