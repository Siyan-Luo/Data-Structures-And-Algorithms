package Warehouse;
//  ___   ___  _  _ _ _____    ___ _  _   _   _  _  ___ ___ _ _ _ 
// |   \ / _ \| \| ( )_   _|  / __| || | /_\ | \| |/ __| __| | | |
// | |) | (_) | .` |/  | |   | (__| __ |/ _ \| .` | (_ | _||_|_|_|
// |___/ \___/|_|\_|   |_|    \___|_||_/_/ \_\_|\_|\___|___(_|_|_)
//

public interface IWarehouse {
	
	/*
	 * Method registers a new product to the system and assigns (+returns) a unique id for the product
	 * 
	 *	@param	name	name of the product to be added
	 *	@param	quantity	number of product items added to the warehouse 
	 * 	@return	unique identifier of the product that was added to the warehouse
	 */
	public int addProduct(String name, int quantity);
	
	/*
	 * Method removes certain quantity of a product form the system.
	 *  
	 * @param	productId	unique identifier of the product to be removed
	 * @param	quantity	number of product items removed to the warehouse
	 * @return 	success or failure to remove the products
	 */
	public boolean removeProduct(int productId, int quantity);
	
	/*
	 * Method registers a new client in the system and assigns (+returns) a unique id.
	 * 
	 * @param name	the fisrt and the last name of the client that is registered in the system
	 * @param email	e-mail address of the client to be registered 
	 * @return unique identifier of the client that was registered to the system
	 */
	public int registerClient(String name, String email);
	
	/*
	 * Method created an order for a client and assigns it a unique id.
	 * 
	 * @param clientId	id of the client to which the order belongs
	 * @return unique identifier of the order created in the system
	 */
	public int createOrder(int clientId);
	
	/*
	 * Method creates an order with a unique id in the system. The order is associated with a client
	 * 
	 * @param	productId	id of the product added to the order
	 * @param	quantity	quantity of the products added to the order
	 * @param	orderId		id of the orded to be created (assumes createOrder(...) method was called first)
	 */
	public void addToOrder(int productId, int quantity, int orderId);
	
	/*
	 * Method finishes the order and removes the products from the stock of the warehouse.
	 * Once the order is finalized, no product can be added or removed.
	 * Method should also print a bill for the client.
	 * 	
	 * @param  orderId	id of the order to be finalized 
	 */
	public void finalizeOrder(int orderId);
	
	/*
	 * Method searches a product in the system based on the name. It prints the results of the search (name + quantity) 
	 * 
	 * @param	productName	name of the product searched in the system
	 */
	public void searchProduct(String productName);
	
	/*
	 * Method assigns a location to a product, meaning the the product is stored at this location 
	 * 
	 * @param	locationName name of the location in the warehouse
	 * @param	productId	id of the product stored at the location 
	 */
	public void assignLocation(String locationName, int productId);
	
	/*
	 * Method connects two locations at the warehouse. This means the personnel of the warehouse
	 * can walk/transfer directly between the two locations without crossing another one.  
	 * 
	 * @param	firstLocation	name of the first location to be connected
	 * @param	secondLocation	name of the second location to be connected
	 * @param	distance		distance between locations (e.g. in meters)
	 */
	public void connectLocations(String firstLocation, String secondLocation, int distance);
	
	/* 
	 * Method prints the shortest path between two locations and the distance between them. 
	 * 
	 * @param	firstLocation	name of the starting location
	 * @param	secondLocation	name of the final location
	 */
	public void printShortestPath(String firstLocation, String secondLocation);
	
	/*
	 * OPTIONAL:
	 * 
	 * Method prints the optimal path that the personnel need to take in the warehouse to fetch
	 * all products in a specific order.
	 * 
	 * @param	orderId	id of the order for which the optimal path will be searched.
	 */
	public void printOptimalPath(int orderId);
	
}
