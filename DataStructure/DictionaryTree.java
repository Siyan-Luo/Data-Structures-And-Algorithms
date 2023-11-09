package DataStructure;

public class DictionaryTree {
	
	private class DictionaryPair implements Comparable {
		private Comparable key;
		private Comparable value;

		public DictionaryPair(Comparable key, Comparable value) {
			this.key = key;
			this.value = value;
		}

		public Comparable getKey() {
			return this.key;
		}

		public void setKey(Comparable key) {
			this.key = key;
		}

		public Comparable getValue() {
			return this.value;
		}
		
		public void setValue(Comparable value) {
			this.value = value;
		}

		public int compareTo(Object o) {
			DictionaryPair p2 = (DictionaryPair) o;
				return (this.key).compareTo(p2.key);
//			return 0;
		}
		
	}

	private Tree data;

	public DictionaryTree() {
		data = new Tree();
	}

	public void add(Comparable key, Comparable value) {
//		int index = findPosition(key);
		if (findKey(key)==null) {
//			O(H)
//			already exist.
			DictionaryPair dp = new DictionaryPair(key, value);
			data.insert(dp);
//			O(H)
		}
//		O(H)
	}
	
	public Comparable findKey(Comparable key) {
		DictionaryPair dp = new DictionaryPair(key,0);
		if (data.find(dp)!=null) {
			return ((DictionaryPair) data.find(dp)).getValue();
		}
//		O(H)
//		else {
		return null; 
//		}
	}
	
//	public void addValue(Comparable key) {
//		DictionaryPair dp = new DictionaryPair(key,0);
//		((DictionaryPair) data.find(dp)).value = ((int) ((DictionaryPair) data.find(dp)).getValue())+1;
//	}
	
//	
	public String toString() {
		return data.toString();
	}
	
//	public static void main(String[] args) {
//		DictionaryTree dt = new DictionaryTree();
//		dt.add("1", "one");
//		System.out.println(dt.findKey("1"));
//	}
	

//	public comparable findPosition(Comparable key) {
//		DictionaryPair dp = new DictionaryPair(key,0);
//		for(int i=0;i<data.size();i++) {
//			if (((DictionaryTree.DictionaryPair) data.find(i)).compareTo(dp) == 0)
//				return i;
//			}
//		
//		return -1;
//	}

//	public Comparable find(Comparable key) {
//		int index = findPosition(key);
//		if (index != -1) {
//			return ((DictionaryTree.DictionaryPair) data.get(index)).getValue();
//		}
//		return null;
//	}

//	public void removeKey(Comparable key) {
//		int index = findPosition(key);
//		if (index != -1) {
//			data.remove(index);
//		}
//	}

//	public int size() {
//		return data.size();
//	}
	
//	public String toString() 
//	{
//		String s = "";
//		return s;
//	}
}