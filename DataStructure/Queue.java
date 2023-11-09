package DataStructure;

public class Queue {

	private LinkedList data;
	
	public Queue() {
		data = new LinkedList();
	}

	public void push(Comparable o) {
		data.addLast(o);
//		O(n)
	}

	public Comparable pop() {
		Comparable o = data.getFirst();
		data.removeFirst();
		return o;
//		O(1)
		
	}

	public Comparable top() {
		return data.getFirst();
	}

	public int size() {
		return data.size();
	}

	public boolean empty() {
		if (data.size()==0) {
			return true;
		}
		return false;
	}
}
