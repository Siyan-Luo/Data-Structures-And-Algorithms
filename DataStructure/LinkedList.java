package DataStructure;

//import LinkedList.ListElement;

public class LinkedList implements Comparable{
	
	private class ListElement implements Comparable{
		private Comparable el1;
		private ListElement el2;

		public ListElement(Comparable el, ListElement nextElement) {
			el1 = el;
			el2 = nextElement;
		}

		public ListElement(Comparable el) {
			this(el, null);
		}

		public Comparable first() {
			return el1;
		}

		public ListElement rest() {
			return el2;
		}

		public void setFirst(Comparable value) {
			el1 = value;
		}

		public void setRest(ListElement value) {
			el2 = value;
		}

		@Override
		public int compareTo(Object o) {
			// TODO Auto-generated method stub
			return 0;
		}

		
	}
	
	private ListElement head;

	public LinkedList() {
		head = null;
	}

	public void addFirst(Comparable o) {
		head = new ListElement(o, head);
	}

	public Comparable getFirst() {
		return head.first();
	}

	public Comparable get(int n) {
		ListElement d = head;
		while (n > 0) {
			d = d.rest();
			n--;
		}
		return d.first();
	}
	
	public String toString() {
		String s = "(";
		ListElement d = head;
		while (d != null) {
			s += d.first().toString();
			s += " ";
			d = d.rest();
		}
		s += ")";
		return s;
	}
	
	public int size() {
		int counter = 0;
		ListElement d = head;
		while(d!=null) {
			d = d.rest();
			counter++;
		}
		return counter;
	}
	
	public void set(int n, Comparable o) {
		ListElement d = head;
		while (n > 0) {
			d = d.rest();
			n--;
		}
		d.setFirst(o);
	}
	
	public Comparable getLast() {
		ListElement d = head;
		while(d.rest()!=null) {
			d = d.rest();
		}
		return d.first();
	}
	
	public void addLast(Comparable o) {
		ListElement d = head;
		ListElement last = new ListElement(o);
		while(d.rest()!=null) {
			d = d.rest();
		}
		d.setRest(last);
	}
	
	public int findIndex(Comparable o) {
		int n = 0;
		ListElement d = head;
		while (d.first().compareTo(o)!=0) {
			d = d.rest();
			n++;
		}
		return n;
	}
	
	public boolean find(Comparable o) {
		ListElement d = head;
		while (d.rest()!=null) {
			if (d.first().compareTo(o)==0) {
				return true;
			}
			d = d.rest();
		}
		return false;
	}
	
	public void removeFirst() {
	
		if(head!=null) {
			head = head.rest();
		}
	}
	
	public void removeLast() {
		ListElement d = head;
		while(d.rest().rest()!=null) {
			d = d.rest();
		}
		d.setRest(null);
	}
	
	public void remove(Comparable o) {
		ListElement d = head;
//		int index = find(o);
		if(d.first()==o) {
			head = head.rest();
		}else {
			while (d.rest().first().compareTo(o)!= 0) {
				d = d.rest();
			}
	//		for (int i=0;i<index;i++) {
	//			d = d.rest();
	//		}
	////		O(n)
			if (d.rest().rest()!=null) {
				d.setRest(d.rest().rest());
			}else {
				d.setRest(null);
			}
		}
//		O(n)
	}
	
	public void reverse() {
		
		for (int i=0;i<this.size()/2;i++) {
			Comparable temp = this.get(i);
			this.set(i,get(this.size()-i-1));
			this.set(this.size()-i-1,temp);
		}
	}
	
	public LinkedList repeat() {
		LinkedList list = new LinkedList();
		for (int i=this.size()-1;i>=0;i--) {
			list.addFirst(this.get(i));
			list.addFirst(this.get(i));
		}
		return list;
	}
	
	public LinkedList interleave(LinkedList list2) {
		LinkedList list = new LinkedList();
		for (int i=this.size()-1;i>=0;i--) {
			list.addFirst(list2.get(i));
			list.addFirst(this.get(i));
			
		}
		return list;
	}
	
	public void fropple() {
//		int num = this.size();
//		if ((num&1)!=0) {
//			num -= 1;
//		}
//		for(int i=0;i<num;i+=2) {
//			Comparable temp = this.get(i);
//			this.set(i,this.get(i+1));
//			this.set(i+1, temp);
//		} 
		ListElement d = head;
		while(d!=null) {
			Comparable temp = d.first();
			d.setFirst(d.rest().first());
			d.rest().setFirst(temp);
			d = d.rest().rest();
		}
	}
	
	public ListElement getHead() {
		return this.head;
	}
	
	public void append(LinkedList list2) {
//		for(int i=0;i<list2.size();i++) {
//			this.addLast(list2.get(i));
//		}
		ListElement d = head;
		while(d.rest()!=null) {
			d = d.rest();
		}
		d.setRest(list2.getHead());
	}
	
	public void addSorted(Comparable o) {
		if (head == null) {
			head = new ListElement(o,null);
		}
		else if (head.first().compareTo(o) > 0){
			head = new ListElement(o,head);
		}
		else {
			ListElement d = head;
			while((d.rest() != null) && 
					(d.rest().first().compareTo(o) < 0))
			{
				d = d.rest();
			}
			ListElement next = d.rest();
			d.setRest(new ListElement(o,next));
		}
//		count ++;
	}
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
//		return this.el1.compareTo(o);
		return 0;
	}
}
