package DataStructure;
import java.util.ArrayList;
import java.util.Collections;
import java.io.*;

public class Vector
	{
		private Object data[];
		private int count;
		
		public Vector(int capacity)
		{
			data = new Object[capacity];
//		The variable count will store the number of elements in the vector
			count = 0;
		}
		
		public int capacity()
		{
			return data.length;
		}
	
		public int size()
		{
			return count;
		}
	 
		public boolean isEmpty()
		{
			return size() == 0;
		}
	
		public Object get(int index)
		{
			return data[index];
		}
	
		public void set(int index, Object obj)
		{
			data[index] = obj;
		}
	
		public boolean contains(Object obj)
		{
			for(int i=0;i<count;i++)
			{
				if(data[i] == obj) return true;
			}
			return false;
		}
		
		public void addFirst(Object item)
		{
			for (int i=1;i<this.count;i++) {
				data[i] = data[i-1];
			}
			data[0] = item;
			this.count++;
		}
	
		public void addLast(Object o)
		{
			try {
			     data[count] = o;
			     count++;
			} 
			catch (Exception e) {
			      System.out.println("The vector is full.");
			    }
		}
		
		/*
		public boolean binarySearch(Object key)
		{
		int start = 0;
		int end = count - 1;
		while(start <= end)
		{
			int middle = (start + end + 1) / 2;
			if(key < data[middle]) end = middle -1;
			else if(key > data[middle]) start = middle + 1;
			else return true;
		}
		return false;
		}
		*/
	
		public Object getFirst()
		{
			return get(0);
		}
	
		public Object getLast()
		{
			return get(size()-1);
		}
	
		public void removeLast()
		{
			data[count-1]=null;
			this.count--;
		} 
	
		public void removeFirst()
		{
			for (int i=0;i<this.count-1;i++) {
				data[i] = data[i+1];
				
			}
			this.count--;
		}
		
		public void remove(int num) 
		{
			if (num==this.count-1) {
				data[count-1]=null;
			}
			else {
				for (int i=num;i<this.count-1;i++) {
					data[i] = data[i+1];
				}
			}
			this.count--;
		}
		
		public String toString()
		{
			String str = "[ ";
			for (int i=0;i<size();i++) {
				str += get(i) + " ";
			}
			str += "]";
			return str;
		}
		
		public void reverse() 
		{
//			ArrayList<Object> temp = new ArrayList<Object>(this.count);
//			for (int i=0;i<this.count;i++) {
//				temp.add(get(i));
//			}
//			for (int i=0;i<this.count;i++) {
//				set(i,temp.get(this.count-i-1));
//			}
			for (int i=0;i<this.count/2;i++) {
				Object temp = get(i);
				set(i,get(this.count-i-1));
				set(this.count-i-1,temp);
			}
		}
		
		public Vector repeat() 
		{
			Vector newvc = new Vector(this.count*2);
			for (int i=0,j=0;j<size();i+=2,j++) {
//				newvc.addFirst(newvc);
				newvc.set(i, get(j));
				newvc.set(i+1, get(j));
				newvc.count+=2;
			}
			return newvc;
		}
		
		public Vector interleave(Vector v2)
		{
			Vector newvc = new Vector(v2.count*2);
			for (int i=0,j=0;j<size();i+=2,j++) {
				newvc.set(i, get(j));
				newvc.set(i+1, v2.get(j));
				newvc.count+=2;
			}
			return newvc;
		}
		
		private void extendCapacity()
		{
			Object[] data2 = new Object[data.length*2];
			for (int i=0;i<data.length;i++) {
				data2[i] = data[i];
			}
			this.data = data2;
		}
		
//		public static void main(String[] args) 
//		{
////			1
//			Vector vc = new Vector(100);
//			for (int i=0;i<100;i++) {
//				Object ob = i+1;
//				vc.set(i, ob);
//				vc.count++;
//			}
////			System.out.println(vc.size());
//			Object ob6 = 6;
////			Object ob101 = 101;
////			System.out.println(vc.contains(ob6));
////			System.out.println(vc.contains(ob101));
//////			2
////			System.out.println(vc.getFirst());
////			System.out.println(vc.getLast());
//////			3
////			System.out.println(vc);
//////			4
////			vc.addFirst(ob6);
////			System.out.println(vc.getFirst());
////			System.out.println(vc.size());
////			5
////			vc.removeFirst();
////			System.out.println(vc.size());
////			System.out.println(vc);
////			System.out.println(vc.getFirst());
////			vc.removeLast();
////			System.out.println(vc);
////			System.out.println(vc.getLast());
////			System.out.println(vc.size());
//////			6
//			vc.reverse();
//			System.out.println(vc);
//////			7
////			System.out.println(vc.repeat());
//////			8
////			Vector vcOne = new Vector(3);
////			for (int i=0;i<3;i++) {
////				Object ob = i+1;
////				vcOne.set(i, ob);
////				vcOne.count++;
////			}
////			Vector vcTwo = new Vector(3);
////			for (int i=0;i<3;i++) {
////				Object ob = i+4;
////				vcTwo.set(i, ob);
////				vcTwo.count++;
////			}
////			System.out.println(vcOne.interleave(vcTwo));
////			9
////			vc.addLast(ob6);
////			vc.extendCapacity();
////			vc.addLast(ob6);
////			System.out.println(vc);
//		}
	}