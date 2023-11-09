package DataStructure;

public class Stack implements Comparable{
	
	private LinkedList data;
	
	public Stack() {
		data = new LinkedList();
	}
	
	public void push(Comparable o) {
		data.addFirst(o);
//		O(1)
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

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
