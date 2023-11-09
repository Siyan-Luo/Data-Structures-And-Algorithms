package DataStructure;

public class Dictionary {
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
		}
		
	}

	private Vector data;

	public Dictionary() {
		data = new Vector(100);
	}

	public void add(Comparable key, Comparable value) {
		int index = findPosition(key);
		if (index!=-1) {
//			already exist.
			((Dictionary.DictionaryPair) data.get(index)).setValue(value);
		}else {
			DictionaryPair dp = new DictionaryPair(key, value);
			data.addLast(dp);
		}
	}

	public int findPosition(Comparable key) {
		DictionaryPair dp = new DictionaryPair(key,0);
		for(int i=0;i<data.size();i++) {
			if (((Dictionary.DictionaryPair) data.get(i)).compareTo(dp) == 0)
				return i;
			}
		
		return -1;
	}

	public Comparable find(Comparable key) {
		int index = findPosition(key);
		if (index != -1) {
			return ((Dictionary.DictionaryPair) data.get(index)).getValue();
		}
		return null;
	}

	public void removeKey(Comparable key) {
		int index = findPosition(key);
		if (index != -1) {
			data.remove(index);
		}
	}

	public int size() {
		return data.size();
	}
	
//	public String toString() 
//	{
//		String s = "";
//		return s;
//	}
}