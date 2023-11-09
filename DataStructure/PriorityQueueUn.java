package DataStructure;
import java.util.Comparator;

//import LinkedList.ListElement;

//import LinkedList.ListElement;
//import PriorityQueue.PriorityPair;

//public class PriorityQueueUn
//{       
//	private class PriorityPair implements Comparable {
//		private Object element;
//		private int priority;
//
//		public PriorityPair(Object element, int priority) {
//			this.element = element;
//			this.priority = priority;
//		}
//
//		public int compareTo(Object o) {
//			PriorityPair p2 = (PriorityPair) o;
//			return ((Comparable) priority).compareTo(p2.priority);
//		}
//		
//		public int getPriority() {
//			return this.priority;
//		}
//		
//		public Object getElement() {
//			return this.element;
//		}
//	}
//
//	private LinkedList data;
//
//	public PriorityQueueUn()
//	{
//		data = new LinkedList();
//	}
//
//	public void push(Object o, int priority)
//	{
//		// make a pair of o and priority
//		// add this pair to the sorted linked list.
//		PriorityPair p = new PriorityPair(o, priority);
//		data.addFirst(p);
////		O(n)=1
//	}
//
//	public Object pop()
//	{
//		// add your code here
//		PriorityPair p = new PriorityPair(data.get(0),((PriorityQueueUn.PriorityPair) data.get(0)).getPriority());
//		for (int i = 1; i < data.size(); i++) {
////			data.get(i);
//			PriorityPair pp = new PriorityPair(data.get(i),((PriorityQueueUn.PriorityPair) data.get(i)).getPriority());
//			if (p.getPriority()<pp.getPriority()) {
//				p = pp;
//			}
//		}
//		return p.getElement();
//	}
//
//	public Object top()
//	{
//		// add your code here
//		return data.getFirst();
//	}
//}


import java.util.Comparator;

public class PriorityQueueUn
{       
	private class PriorityPair implements Comparable {
		
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
		
		public Comparable getElement() {
			return this.element;
		}

//		@Override
//		public int compareTo(Object o) {
//			// TODO Auto-generated method stub
//			return 0;
//		}
	}

	private LinkedList data;

	public PriorityQueueUn()
	{
		data = new LinkedList();
	}

	public void push(Comparable o, int priority)
	{
		// make a pair of o and priority
		// add this pair to the sorted linked list.
		PriorityPair p = new PriorityPair(o, priority);
		data.addFirst(p);
	}

	public Comparable pop()
	{
		// add your code here
		Comparable c = data.get(0);
		int counter = 0;
		for (int i=1;i<data.size();i++) {
			Comparable cc = data.get(i);
			if (c.compareTo(cc) < 0) {
				c = cc;
				counter = i;
			}
//			counter++;
		}
		data.remove(counter);
		return ((PriorityQueueUn.PriorityPair) c).getElement();
	}

	public Comparable top()
	{
		// add your code here
		Comparable c = data.getFirst();
		data.removeFirst();
		return ((PriorityQueueUn.PriorityPair) c).getElement();
	}
	
	public String toString() {
		String s = "(";
//		ListElement d = head;
//		while (d != null) {
//			s += d.first().toString();
//			s += " ";
//			d = d.rest();
//		}
		for(int i=0;i<data.size();i++) {
			s += ((PriorityQueueUn.PriorityPair)data.get(i)).getElement().toString();
			s += " ";
		}
		s += ")";
		return s;
	}
}