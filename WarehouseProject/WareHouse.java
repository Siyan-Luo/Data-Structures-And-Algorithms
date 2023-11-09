package Warehouse;
import DataStructure.*;

public class WareHouse implements IWarehouse{
//	stock: store the same kind of products in a DictionaryTree
//	where key stores the product id
//	value stores a LinkedList of this product
	private DictionaryTree stock;
//	products: store the correlation of name and id in a DictionaryTree
//	value stores id, key stores name
	private DictionaryTree products;
//	idToName: store the correlation of id and name in a DictionaryTree
//	value stores name, key stores id
	private DictionaryTree idToName;
//	orders: store current orders in a dictionary
//	key stores the order id, value stores the order
	private Dictionary orders;
//	finalizedOrders: store finalized order in a DictionaryTree
//	key stores the order id, value stores the order
	private DictionaryTree finalizedOrders;
	private int productIdCounter;
	private int clientIdCounter;
	private int orderIdCounter;
//	locationMap: store the locations in a graph
	private Graph locationMap;
//	locations: store the locations in a DictionaryTree
//	key stores the product id, value stores the location name
	private DictionaryTree locations;
	private LinkedList clients;
	
	public WareHouse() {
		// TODO Auto-generated constructor stub
		stock = new DictionaryTree();
		products = new DictionaryTree();
		idToName = new DictionaryTree();
		orders = new Dictionary();
		finalizedOrders = new DictionaryTree();
		locationMap = new Graph();
		locations = new DictionaryTree();
		clients = new LinkedList();
		productIdCounter = 0;
		orderIdCounter = 0;
		clientIdCounter = 0;
	}

	/*
	 * Method registers a new product to the system and assigns (+returns) a unique id for the product
	 * 
	 *	@param	name	name of the product to be added
	 *	@param	quantity	number of product items added to the warehouse 
	 * 	@return	unique identifier of the product that was added to the warehouse
	 */
	@Override
	public int addProduct(String name, int quantity) {
		// TODO Auto-generated method stub
		if (products.findKey(name)!=null) {
//		    this kind of products exists in the stock
			int theID = (int) products.findKey(name);
			LinkedList theProducts = (LinkedList) stock.findKey(theID);
			for (int i=0;i<quantity;i++) {
				Product p = new Product(name);
				theProducts.addFirst(p);
			}
			return theID;
		}else {
//			create a new linked list for this product
			LinkedList newProducts = new LinkedList();
			for (int i=0;i<quantity;i++) {
				Product p = new Product(name);
				newProducts.addFirst(p);
			}
			productIdCounter++;
			stock.add(productIdCounter, newProducts);
			products.add(name, productIdCounter);
			idToName.add(productIdCounter, name);
		}
		return productIdCounter;
//		T.C = O(n)
	}

	/*
	 * Method removes certain quantity of a product form the system.
	 *  
	 * @param	productId	unique identifier of the product to be removed
	 * @param	quantity	number of product items removed to the warehouse
	 * @return 	success or failure to remove the products
	 */
	@Override
	public boolean removeProduct(int productId, int quantity) {
		// TODO Auto-generated method stub
		if (stock.findKey(productId)!=null) {
//			this product exists in stock
			LinkedList theProducts= (LinkedList) stock.findKey(productId);
			int number = theProducts.size();
//			O(n)
			if (number>quantity) {
				for (int i=0;i<quantity;i++) {
					theProducts.removeLast();
				}
//				O(n)
				return true;
			}
		}
		return false;
//		T.C = O(n)
	}

	/*
	 * Method registers a new client in the system and assigns (+returns) a unique id.
	 * 
	 * @param name	the first and the last name of the client that is registered in the system
	 * @param email	e-mail address of the client to be registered 
	 * @return unique identifier of the client that was registered to the system
	 */
	@Override
	public int registerClient(String name, String email) {
		// TODO Auto-generated method stub
		Client c = new Client(name, email);
		this.clientIdCounter++;
		c.setClientId(clientIdCounter);
		clients.addFirst(c);
		return this.clientIdCounter;
	}

	/*
	 * Method created an order for a client and assigns it a unique id.
	 * 
	 * @param clientId	id of the client to which the order belongs
	 * @return unique identifier of the order created in the system
	 */
	@Override
	public int createOrder(int clientId) {
		// TODO Auto-generated method stub
		if (clientId<=clientIdCounter && clientId>0) {
//			this client exists
			Order o = new Order(clientId);
			this.orderIdCounter++;
			o.setOrderId(this.orderIdCounter);
			this.orders.add(this.orderIdCounter,o);
			return this.orderIdCounter;
		}else {
			System.out.println("There is no such client");
			return 0;
		}
//		T.C = O(n)
	}

	/*
	 * Method creates an order with a unique id in the system. The order is associated with a client
	 * 
	 * @param	productId	id of the product added to the order
	 * @param	quantity	quantity of the products added to the order
	 * @param	orderId		id of the order to be created (assumes createOrder(...) method was called first)
	 */
	@Override
	public void addToOrder(int productId, int quantity, int orderId) {
		// TODO Auto-generated method stub
		if (finalizedOrders.findKey(orderId)==null && orders.find(orderId)!=null) {
//			this order exists and hasn't been finalized yet
			LinkedList theProducts = (LinkedList) stock.findKey(productId);
			if (theProducts!=null) {
	//			there's such product in stock
				String productName = (String) idToName.findKey(productId);
				if (theProducts.size()>=quantity) {
	//				there's enough in stock
					Order o = (Order) orders.find(orderId);
					o.addItem(productName, quantity);
				}else {
					System.out.println("Sorry, there's no enough quantity");
				}
			}else {
				System.out.println("Sorry, there's no such product");
			}
		}else {
			System.out.println("This order has been finalized or there's no such order.");
		}
//		T.C = O(n)
	}

	/*
	 * Method finishes the order and removes the products from the stock of the warehouse.
	 * Once the order is finalized, no product can be added or removed.
	 * Method should also print a bill for the client.
	 * 	
	 * @param  orderId	id of the order to be finalized 
	 */
	@Override
	public void finalizeOrder(int orderId) {
		// TODO Auto-generated method stub
		if (finalizedOrders.findKey(orderId)==null && orders.find(orderId)!=null) {
//			this order exists and has not be finalized yet
			Order o = (Order) orders.find(orderId);
			DictionaryTree items = o.getItems();
			System.out.println("Bill of order "+orderId);
			for (int i=1;i<=this.productIdCounter;i++) {
//				loop through all products, check if it's in the order
				String productName = (String) idToName.findKey(i);
				LinkedList item = (LinkedList) items.findKey(productName);
				if (item!=null) {
//					this kind of product exists in the order
					int quantity = item.size();
					LinkedList theProduct = (LinkedList) stock.findKey(i);
					if (theProduct.size()>=quantity) {
						for (int j=0;j<quantity;j++) {
//							remove it from the stock
							theProduct.removeFirst();
						}
						System.out.println(productName+": "+quantity);
					}else {
						System.out.println(productName+": out of stock");
					}
				}
			}
			orders.removeKey(orderId);
			finalizedOrders.add(orderId, o);
			System.out.println("The order "+orderId+" has been finalized.");
		}else {
			System.out.println("This order has been finalized or there's no such order.");
		}
//		T.C = O(n^3)
	}
	
	/*
	 * Method searches a product in the system based on the name. It prints the results of the search (name + quantity) 
	 * 
	 * @param	productName	name of the product searched in the system
	 */
	@Override
	public void searchProduct(String productName) {
		// TODO Auto-generated method stub
		Comparable id = products.findKey(productName);
		if (id!=null) {
			int quantity = ((LinkedList)stock.findKey((int)id)).size();
			System.out.println(productName+": "+quantity);
		}else {
			System.out.println("Sorry, there's no such product.");
		}
//		T.C = O(n)
	}

	
	@Override
	/*
	 * Method assigns a location to a product, meaning the the product is stored at this location 
	 * 
	 * @param	locationName name of the location in the warehouse
	 * @param	productId	id of the product stored at the location 
	 */
	public void assignLocation(String locationName, int productId) {
		// TODO Auto-generated method stub
		locations.add(productId, locationName);
		locationMap.addNode(locationName);
	}

	/*
	 * Method connects two locations at the warehouse. This means the personnel of the warehouse
	 * can walk/transfer directly between the two locations without crossing another one.  
	 * 
	 * @param	firstLocation	name of the first location to be connected
	 * @param	secondLocation	name of the second location to be connected
	 * @param	distance		distance between locations (e.g. in meters)
	 */
	@Override
	public void connectLocations(String firstLocation, String secondLocation, int distance) {
		// TODO Auto-generated method stub
		locationMap.addEdge(firstLocation, secondLocation, distance);
	}

	/* 
	 * Method prints the shortest path between two locations and the distance between them. 
	 * 
	 * @param	firstLocation	name of the starting location
	 * @param	secondLocation	name of the final location
	 */
	@Override
	public void printShortestPath(String firstLocation, String secondLocation) {
		// TODO Auto-generated method stub
		locationMap.findShortedPath(firstLocation, secondLocation);
//		T.C = O(n^3)
	}

	/*
	 * OPTIONAL:
	 * 
	 * Method prints the optimal path that the personnel need to take in the warehouse to fetch
	 * all products in a specific order.
	 * 
	 * @param	orderId	id of the order for which the optimal path will be searched.
	 */
	@Override
	public void printOptimalPath(int orderId) {
		// TODO Auto-generated method stub
//		this one failed
		DictionaryTree items = (DictionaryTree) orders.find(orderId);
		Stack locToFetch = new Stack();
		if (items!=null) {
			for (int i=1;i<=this.productIdCounter;i++) {
				if (items.findKey(i)!=null) {
					String location = (String) locations.findKey(i);
					locToFetch.push(location);
				}
			}
			int num = locToFetch.size();
			for (int i=0;i<num;i+=2) {
				String firstLoc = (String) locToFetch.pop();
				String secondLoc = (String) locToFetch.pop();
				locationMap.findShortedPath(firstLoc, secondLoc);
			}
		}
	}

}
