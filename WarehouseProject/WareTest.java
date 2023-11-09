package Warehouse;
import DataStructure.*;

public class WareTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WareHouse wh = new WareHouse();
		wh.addProduct("1 lamb", 100);
		wh.addProduct("1 lamb", 2);
		wh.addProduct("2 fish", 20);
		wh.addProduct("3 pork", 50);
		wh.addProduct("4 mutton", 30);
		wh.addProduct("5 beef", 120);
		wh.addProduct("6 chicken", 80);
		wh.registerClient("1 Alice", "Alice@vub.com");
		wh.registerClient("2 Bob", "Bob@vub.com");
		wh.createOrder(2);
		wh.addToOrder(1, 110, 1);
		wh.addToOrder(3, 10, 1);
		wh.addToOrder(5, 40, 1);
		wh.addToOrder(6, 10, 1);
		wh.addToOrder(1, 60, 1);
		wh.addToOrder(1, 10, 1);
		wh.assignLocation("A", 1);
		wh.assignLocation("B", 2);
		wh.assignLocation("C", 3);
		wh.assignLocation("D", 4);
		wh.assignLocation("E", 5);
		wh.assignLocation("F", 6);
		wh.connectLocations("A", "C", 30);
		wh.connectLocations("A", "D", 10);
		wh.connectLocations("A", "E", 40);
		wh.connectLocations("B", "A", 15);
		wh.connectLocations("B", "C", 10);
		wh.connectLocations("C", "F", 20);
		wh.connectLocations("D", "E", 20);
		wh.connectLocations("E", "F", 10);		
		wh.finalizeOrder(1);
		wh.addToOrder(1, 10, 1);
		wh.finalizeOrder(1);
		wh.printShortestPath("A", "F");
		wh.searchProduct("4");
		wh.searchProduct("1 lamb");

//		wh.printOptimalPath(1);
		
	}

}
