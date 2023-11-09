package DataStructure;
import java.util.Comparator;


public class Tree {
	/*
	private class NaturalComparator implements Comparator
	{
		public int compare(Object a, Object b)
		{
			return ((Comparable)a).compareTo(b);
		}
	}
	*/
	// the class for implementing a node in the tree.
	// contains a value, a pointer to the left child and a pointer to the right child
	
	public class TreeNode implements Comparable
	{
	 private Comparable value;
	 private TreeNode leftNode;
	 private TreeNode rightNode;
	 private TreeNode parentNode;
	 public TreeNode(Comparable v)
	 {
		 value = v;
		 leftNode = null;
		 rightNode = null;
		 parentNode = null;
	 }
	  
	 public TreeNode(Comparable v, TreeNode left, TreeNode right, TreeNode parent)
	 {
		 value = v;
		 leftNode = left;
		 rightNode = right;
		 parentNode = parent;
	 }
	 
	 public TreeNode getLeftTree()
	 {
		 return leftNode;
	 }
	 
	 public void setLeftTree(TreeNode node)
	 {
		 this.leftNode = node;
	 }
	 
	 public TreeNode getRightTree()
	 {
		 return rightNode;
	 }
	 
	 public void setRightTree(TreeNode node)
	 {
		 this.rightNode = node;
	 }
	 
//	 public TreeNode getParentNode()
//	 {
//		 return parentNode;
//	 }
//	 
//	 public void setParentNode(TreeNode node)
//	 {
//		 this.parentNode = node;
//	 }
	 
	 public Comparable getValue()
	 {
		 return value;
	 }
	 

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		TreeNode n2 = (TreeNode) o;
		return (this.value).compareTo(n2.value);
	}
	 

	}
	
//	public abstract class TreeAction
//	{
//		public abstract void run(Tree.TreeNode n);
//	}		
	
//	public class TreePrinter extends TreeAction
//	{
//		public void run(TreeNode n)
//		{
//			System.out.println(n.value);
//		}
//	
//	}
	// start of the actual tree class
	
	// the root of our tree
	protected TreeNode root;
	
	
	
	public Tree()
	{
		root = null;
	}
	
	
	public void traverse(TreeAction action)
	{
//		QueueVector t = new QueueVector();
		Queue t = new Queue();
		//Stack t = new Stack();
		t.push(root);
		while(!t.empty())
		{
			TreeNode n = (TreeNode)t.pop();
//			if(n!=null) {
				action.run(n);
				 
				if(n.getLeftTree() != null) t.push(n.getLeftTree());
				if(n.getRightTree() != null) t.push(n.getRightTree());
//			}
		}
	}
	
	public void traverseNode(TreeNode n,TreeAction action)
	{
		if(n != null)
		{
			if(n.getLeftTree() != null) traverseNode(n.getLeftTree(),action); 
			action.run(n);
			if(n.getRightTree() != null) traverseNode(n.getRightTree(),action);
		}
	}
	
	public void traverseInOrder(TreeAction action)
	{
		traverseNode(root,action);
	} 
	
	public void insert(Comparable element)
	{
		insertAtNode(element,root,null);
	}	
	
	// we traverse the tree.
	// Current holds the pointer to the TreeNode we are currently checking
	// Parent holds the pointer to the parent of the current TreeNode
	private void insertAtNode(Comparable element,TreeNode current,TreeNode parent)
	{
		// if the node we check is empty
		if(current == null)
		{
			TreeNode newNode = new TreeNode(element);
			// the current node is empty, but we have a parent
			if(parent != null)
			{
				// do we add it to the left?
				if(element.compareTo(parent.value) < 0)
				{
					parent.leftNode = newNode;
				}
				// or do we add it to the right?
				else
				{
					parent.rightNode = newNode;
				}
			}
			// the current node is empty and it has no parent, we actually have an empty tree
			else root = newNode;
		}
		else if(element.compareTo(current.value) == 0)
		{
			// if the element is already in the tree, what to do?
		}
		// if the element is smaller than current, go left
		else if(element.compareTo(current.value) < 0)
		{
			insertAtNode(element,current.getLeftTree(),current);
		}
		// if the element is bigger than current, go right
		else insertAtNode(element,current.getRightTree(),current);
	}
	
//	public String toString ()
//	{
//		String s = "";
//		Stack t = new Stack ();
//		t . push ( root );
//		while (! t . empty ())
//		{
//			TreeNode n = ( TreeNode ) t . pop ();
//			s += n . value . toString ();
//			if( n . getRightTree () != null )
//				t . push ( n . getRightTree ());
//			if( n . getLeftTree () != null )
//				t . push ( n . getLeftTree ());
//				s += "\n";
//		}
//		return s ;
//	}
	
//	public String toString ()
//	{
//		String s = "";
//		Queue q = new Queue();
//		q.push(root);
//		while (! q.empty())
//		{
//			TreeNode n = (TreeNode)q.pop();
//			s += n.value.toString();
//			if (n.getRightTree()!=null)
//				q.push(n.getRightTree());
//			if( n . getLeftTree () != null )
//				q.push(n.getLeftTree());
//				s += "\n";
//		}
//		return s;
//	}
	
	public String toString()
	{
		String s = " ";
		traverse(new TreeAction()
		{
			public void run(TreeNode n)
			{
				System.out.println(n.value);
			}
		});
		return s;
	}
	
	public int depthCounter()
	{
		return depthCounterAtNode(root);
	}
	
	private int depthCounterAtNode(TreeNode current)
	{	
		if (current == null) {
			return 0;
		}
		int leftHeight = depthCounterAtNode(current.getLeftTree());
		int rightHeight = depthCounterAtNode(current.getRightTree());
		return Math.max(leftHeight,rightHeight)+1;
	}
	
	public Comparable findBiggestNode() 
	{
		TreeNode current = root;
		while (current.rightNode != null) {
			current = current.rightNode;
		}
		return current.getValue();
	}
	
	public Comparable find(Comparable element)
	{
		return findNode(element,root);
	}
	
	private Comparable findNode(Comparable element, TreeNode current)
	{
		if (current == null) {
			return null;
		}else if(element.compareTo(current.value)==0) {
			return current.getValue();
		}else if(element.compareTo(current.value)<0) {
			return findNode(element, current.leftNode);
		}else {
			return findNode(element, current.rightNode);
		}
	}
//	O(H)
	private void transplant(TreeNode oldNode, TreeNode newNode) 
	{
		if (oldNode.parentNode == null) {
//			oldNode is the root
			root = newNode;
		}else if(oldNode.parentNode.getLeftTree() == oldNode) {
//			oldNode is on the left, replace it with newNode
			oldNode.parentNode.leftNode = newNode;
		}else {
//			oldNode is on the right, replace it with newNode
			oldNode.parentNode.rightNode = newNode;
		}
		if (newNode != null) {
			newNode.parentNode = oldNode.parentNode;
		}
	}
	
	public TreeNode minNode(TreeNode current)
	{
		if(current == null) {
			return null;
		}else if(current.getLeftTree()==null) {
			return current;
		}else {
			return minNode(current.getLeftTree());
		}
	}
	
	public void remove(Comparable element)
	{
		removeNode(element, root);
	}
	
	private void removeNode(Comparable element, TreeNode current)
	{
		if(current == null) {
			return;
		}else if(element.compareTo(current.value) == 0 && current.parentNode != null) {
//			found the node
			if (current.leftNode == null && current.rightNode!=null) {
				transplant(current, current.rightNode);
			}else if (current.rightNode == null && current.leftNode!=null) {
				transplant(current, current.leftNode);
			}else if (current.rightNode==null && current.leftNode==null) {
//				The node is the leave one to remove
//				if (current.parentNode != null) {
					if (current.parentNode.leftNode == current) {
						current.parentNode.leftNode = null;
					}else {
						current.parentNode.rightNode = null;
					}
//				}else {
////					It's the root
//					TreeNode y = minNode(current.rightNode);
//					if (y!=null) {
//						if (y.parentNode!=current)
//						{
//							transplant(y,y.rightNode);
//							y.rightNode = current.rightNode;
//							y.rightNode.parentNode = y;
//						}
//						transplant(current,y);
//						if (current.leftNode != null) {
//							y.leftNode = current.leftNode;
//							y.leftNode.parentNode = y;
//						}
//					}
//				}
			}else {
				TreeNode y = minNode(current.rightNode);
				if (y.parentNode!=current)
				{
					transplant(y,y.rightNode);
					y.rightNode = current.rightNode;
					y.rightNode.parentNode = y;
				}
				transplant(current,y);
				if (current.leftNode != null) {
					y.leftNode = current.leftNode;
					y.leftNode.parentNode = y;
				}
			}
		}else if(element.compareTo(current.value)<0) {
			removeNode(element,current.getLeftTree());
		}else {
			removeNode(element,current.getRightTree());
		}
	}
	
//	public void remove(Comparable v) 
//	{
//		removeNode(v,root,null);
//	}
//	
//	private void removeNode(Comparable v,TreeNode current,TreeNode parent) 
//	{
//		if (current != null) {
//			if (v.compareTo(current.getValue())<0) {
//				removeNode(v,current.leftNode,current);
//			}else if (v.compareTo(current.getValue())>0){
//				removeNode(v,current.rightNode,current);
//			}else {
//				parent.setLeftTree(current.leftNode);
//				parent.setRightTree(current.rightNode);
//			}
//		}
//	}
	
	public void swapTree() {
		swapTreeAtNode(root);
	}
	
	private void swapTreeAtNode(TreeNode current) {
		if(current.rightNode != null 
				&& current.leftNode != null) {
			TreeNode temp = current.leftNode;
			current.setLeftTree(current.rightNode);
			current.setRightTree(temp);
			swapTreeAtNode(current.leftNode);
			swapTreeAtNode(current.rightNode);
		}
	}
	
	public int  average() {
		return averageNode(root,(int) root.getValue())/(int) depthCounter();
	}
	
	private int averageNode(TreeNode current, int total) {
		if (current.rightNode!=null) {
			total+=(int)current.leftNode.getValue()+(int) current.rightNode.getValue();
			averageNode(current.leftNode, total);
			averageNode(current.rightNode, total);
			
		}
		return total;
	}
	
	
	public Comparable median() 
	{
		return root.getValue();
	}
	
	public Comparable minimum()
	{
		TreeNode current = root;
		while (current.leftNode!=null) {
			current = current.leftNode;
		}
		return current.getValue();
	}
	
//	public Comparable average()
//	{
//		TreeNode current = root;
//		if (current!=null) {
//			int depth = 1;
//			int  leftTotal = (int) current.getValue();
//			while(current.leftNode!=null) {
//				leftTotal += (int) current.leftNode.getValue()+(int) current.rightNode.getValue();
//				current = current.leftNode;
//				depth++;
//				
//			}
//			int rightTotal = 0;
//			while(current.rightNode!=null) {
//				rightTotal += (int) current.leftNode.getValue()+(int) current.rightNode.getValue();
//				current = current.rightNode;
//			}
//		return (leftTotal+rightTotal)/(Math.pow(2,depth)-1);
//		}
//		return 0;
//	}
	
	
}
