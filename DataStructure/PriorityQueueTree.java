package DataStructure;
import java.util.Comparator;

public class PriorityQueueTree 
{       
	private class PriorityPair implements Comparable
	{
		private Comparable element;
		private Comparable priority;

		public PriorityPair(Comparable element, Comparable priority) {
			this.element = element;
			this.priority = priority;
		}

		public int compareTo(Object o) {
			PriorityPair p2 = (PriorityPair) o;
			return ((Comparable) priority).compareTo(p2.priority);
		}
		
		public Comparable getPriority() {
			return this.priority;
		}
	}

	private Tree data;

	public PriorityQueueTree()
	{
		data = new Tree();
	}

	public void push(Comparable o, int priority)
	{
		// make a pair of o and priority
		// add this pair to the sorted linked list.
		PriorityPair p = new PriorityPair(o, priority);
//		data.addSorted(p);
		data.insert(p);
	}

	public Comparable pop()
	{
		// add your code here
//		Comparable o = data.getLast();
////		Comparable o =((PriorityQueue.PriorityPair) data.getLast()).getPriority();
//		data.removeLast();
//		return o;
		
		return ((PriorityQueueTree.PriorityPair) data.findBiggestNode()).getPriority();
	} 

//	public Comparable top()
//	{
//		return data.getFirst();
//	}
}
