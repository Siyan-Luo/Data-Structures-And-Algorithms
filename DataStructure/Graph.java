package DataStructure;
//import java.util.Stack;

public class Graph
{
    public class Node implements Comparable
    {
        private Comparable info;
        private Vector edges;
        private boolean visited;
        private int distance;
        private Node previousNode;
        
        public Node(Comparable label)
        {
            info = label;
            edges = new Vector(100);
            visited = false;
        }
        
        public void addEdge(Edge e)
        {
            edges.addLast(e);
        }
        
        public Vector getEdges() 
        {
        	return edges;
        }
        public int compareTo(Object o)
        {
            // two nodes are equal if they have the same label
            Node n = (Node)o;
            return n.info.compareTo(info);
        }
        
        public Comparable getLabel()
        {
            return info;
        }
        
        public int getDistance()
        {
        	return distance;
        }
        
        public void setDistance(int d)
        {
        	distance = d;
        }
        
        public void setPreviousNode(Node n)
        {
        	previousNode = n;
        }
        
        public Node getPreviousNode()
        {
        	return previousNode;
        
        }
    }
    
    private class Edge implements Comparable
    {
        private Node toNode;
        private Comparable weight;
        
        public Edge(Node to, Comparable w)
        {
            toNode = to;
            weight = w;
        }
        
        public int compareTo(Object o)
        {
            // two edges are equal if they point
            // to the same node.
            // this assumes that the edges are
            // starting from the same node !!!
            Edge n = (Edge)o;
            return n.toNode.compareTo(toNode);
        }
        
        public Comparable getWeight()
        {
        	return weight;
        }
    }
    
    private Vector nodes;
//    private Vector allEdges;
    
    public Graph()
    {
        nodes = new Vector(100);
//        allEdges = new Vector(100);
    }
    
    public void addNode(Comparable label)
    {
        nodes.addLast(new Node(label));
    }
    
    private Node findNode(Comparable nodeLabel)
    {
        Node res = null;
        for (int i=0; i<nodes.size(); i++)
        {
            Node n = (Node)nodes.get(i);
            if(n.getLabel() == nodeLabel)
            {
                res = n;
                break;
            }
        }
        return res;
    }
    public void addEdge(Comparable nodeLabel1,
			            Comparable nodeLabel2,
			            Comparable weight)
	{
		Node n1 = findNode(nodeLabel1);
		Node n2 = findNode(nodeLabel2);
		n1.addEdge(new Edge(n2, weight));
	}
    
    public boolean findPath(Comparable nodeLabel1,
    						Comparable nodeLabel2) {
    	Node startState = findNode(nodeLabel1);
    	Node endState = findNode(nodeLabel2);
    	Stack toDoList = new Stack();
    	toDoList.push(startState);
    	while(!toDoList.empty())
    	{
    		Node current = (Node)toDoList.pop();
    		if(current == endState) {
    			return true;
    		}else {
    			for(int i=0;i<current.edges.size();i++)
    			{
    				Edge e = (Edge)current.edges.get(i);
    				toDoList.push(e.toNode);
    			}
    		}
    	}
    	return false;
    }
    
    private void relax(Node start, Node end, Comparable weight)
    {
    	if (end.getDistance()>(start.getDistance()+(int)weight)) {
    		end.setDistance(start.getDistance()+(int)weight);
    		end.setPreviousNode(start);
    	}
    }
    
    private void relaxFromNode(Node sourceNode) 
    {
    	for (int i=0;i<sourceNode.getEdges().size();i++) {
			Edge e = (Edge) sourceNode.getEdges().get(i);
			Node endNode = e.toNode;
			Comparable weight = e.getWeight();
			if (endNode!=null) {
				relax(sourceNode, endNode, weight);
				relaxFromNode(endNode);
			}
    	}
    }
    
	public void findShortedPath(Comparable startNode, Comparable endNode) 
	{
//		initialize distances to infinity, here it's indicated in a large number
		for (int i=0;i<nodes.size();i++) {
			((Node) nodes.get(i)).setDistance(100000);
		}
		Node start = findNode(startNode);
		Node end = findNode(endNode);
		start.setDistance(0);
		for (int i=1;i<nodes.size();i++) {
//			relax nodes.size()-1 times
			relaxFromNode(start);
		}
//		push nodes on the path to the stack, from destination to start		
		Stack pathNode = new Stack();
		pathNode.push(endNode);
		Node n = end.getPreviousNode();
		while (n.compareTo(start)!=0) {
			pathNode.push(n.getLabel());
			n = n.getPreviousNode();
		}
		pathNode.push(startNode);
		int num = pathNode.size();
//		pop the nodes
		System.out.print("The shortest path is: "+pathNode.pop());
		for (int i=1;i<num-1;i++) {
			System.out.print("--->");
			System.out.print(pathNode.pop());
		}
		System.out.print("--->");
		System.out.println(pathNode.pop());
		System.out.println("The distance is: " + end.getDistance());
	}
}