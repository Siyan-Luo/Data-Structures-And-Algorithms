package DataStructure;
import java.util.Comparator;

public class PriorityQueue 
{       
	private class PriorityPair implements Comparable
	{
		private Object element;
		private Object priority;

		public PriorityPair(Object element, Object priority) {
			this.element = element;
			this.priority = priority;
		}

		public int compareTo(Object o) {
			PriorityPair p2 = (PriorityPair) o;
			return ((Comparable) priority).compareTo(p2.priority);
		}
		
		public Object getPriority() {
			return this.priority;
		}
	}

	private LinkedList data;

	public PriorityQueue()
	{
		data = new LinkedList();
	}

	public void push(Object o, int priority)
	{
		// make a pair of o and priority
		// add this pair to the sorted linked list.
		PriorityPair p = new PriorityPair(o, priority);
		data.addSorted(p);
	}

	public Object pop()
	{
		// add your code here
		Object o = data.getLast();
//		Object o =((PriorityQueue.PriorityPair) data.getLast()).getPriority();
		data.removeLast();
		return o;
	}

	public Object top()
	{
		return data.getFirst();
	}
}
