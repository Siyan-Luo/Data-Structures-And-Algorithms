package Warehouse;
import DataStructure.*;

public class Client implements Comparable {
	
	private String clientName;
	private int clientID;
	private String email;
	
	public Client(String name, String email) {
		// TODO Auto-generated constructor stub
		this.clientName = name;
		this.email = email;
		this.clientID = 0;
	}

	public String getClientName() {
		return this.clientName;
	}
	
	public int getClientID() {
		return this.clientID;
	}
	
	public void setClientId(int id) {
		this.clientID = id;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
}