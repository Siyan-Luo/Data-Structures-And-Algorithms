package DataStructure;

public class CircularVector 
{
//	private Vector data;
	private Object[] data;
	private int first;
	private int count;

	public CircularVector(int capacity)
	{
		count = 0;
		first = 0;
//		data = new Vector(5);
		data = new Object[capacity];
	}

	public int size()
	{
		return count;
	}

	public int capacity()
	{
		return data.length;
	}
	
	public Object get(int index)
	{
		return data[index];
	}
	
	public void addFirst(Object element)
	{
		// add your code here
//		if (count<data.capacity()) {
//			first = (first+data.capacity()-1)%data.capacity();
//			data.set(first,element);
//			count++;
//		}
		if (count<this.capacity()) {
			first = (first+this.capacity()-1)%this.capacity();
//			for (int i=first;i<this.count;i++) {
//				data[i] = data[i-1];
//			}
			data[first] = element;
			this.count++;
		}
	}

	public void addLast(Object element)
	{
		// add your code here
//		if (count<data.capacity()) {
//			data.set((first+count)%data.capacity(),element);
//			count++;
//		}
		
		try {
		     data[(first+count)%this.capacity()] = element;
		     this.count++;
		} 
		catch (Exception e) {
		      System.out.println("The vector is full.");
		    }
	}

	public Object getFirst()
	{
		// add your code
		return get(first);
		
	}

	public Object getLast()
	{
		// add your code
//		if (first+count<this.capacity()) 
//		{
		return get((first+count-1)%this.capacity());
//			return get(first+count-1);
//		}
//		return get(count-1);
	}

	public void removeFirst()
	{
		if(count > 0)
		{
			data[first] = null;
			first = (first+1)%this.capacity();
			count--;
		}
		
	}

	public void removeLast()
	{
		// add your code
		if(count > 0)
		{
//			if (first+count<this.capacity()) {
//				data[first+count-1]=null;
//			}
//			data[count-1]=null;
			data[(first+count-1)%this.capacity()]=null;
			count--;	
		}
	}
	
	private void extendCapacity()
	{
		Object[] data2 = new Object[data.length*2];
		for (int i=0;i<data.length;i++) {
			data2[i] = data[i];
		}
		this.data = data2;
	}

	public String toString()
	{
    String s = "[";
		for(int i=0;i<count;i++)
		{
			int index = (first + i) % capacity();
			s += get(index).toString();
			s += " ";
		}
    s += "]";
    return s;
	}
}