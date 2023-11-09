package DataStructure;
public class DoubleLinkedList 
{
    private class DoubleLinkedListElement
    {
        private Object data;
        private DoubleLinkedListElement nextElement;
        private DoubleLinkedListElement previousElement;

        public DoubleLinkedListElement(Object v, 
        		DoubleLinkedListElement next, DoubleLinkedListElement previous)
        {
                data = v;
                nextElement = next;
                previousElement = previous;

                if(nextElement != null) nextElement.previousElement = this;
                if(previousElement != null) previousElement.nextElement = this;
        }

        public DoubleLinkedListElement(Object v)
        {
                this(v,null,null);
        }

        public DoubleLinkedListElement previous()
        {
                return previousElement;
        }

        public Object value()
        {
                return data;
                }

        public DoubleLinkedListElement next()
        {
                return nextElement;
        }

        public void setNext(DoubleLinkedListElement value)
        {
                nextElement = value;
        }

        public void setPrevious(DoubleLinkedListElement value)
        {
                previousElement = value;
        }
        
        public void setValue(Object value)
        {
        		data = value;
        }
}

    private int count;
    private DoubleLinkedListElement head;
    private DoubleLinkedListElement tail;

    public DoubleLinkedList()
    {
            head = null;
            tail = null;
            count = 0;
    }

    public Object getFirst()
    {
            return head.value();
    }

    public Object getLast()
    {
            return tail.value();
    }

    public int size()
    {
            return count;
    }

    public void AddFirst(Object value)
    {
            head = new DoubleLinkedListElement(value,head,null);
            if(tail == null) tail = head;
            count++;
    }

    public void AddLast(Object value)
    {
            tail = new DoubleLinkedListElement(value,null,tail);
            if(head == null) head = tail;
            count++;
    }

    public String toString()
    {
            String s = "(";
        DoubleLinkedListElement d = head;
        while(d != null)
        {
                s += d.value().toString();
                s += " ";
                d = d.next();
        }
        s += ")";
            return s;

    }
    
    public void printReverse() 
    {
    	DoubleLinkedList reversed = new DoubleLinkedList();
    	DoubleLinkedListElement d = head;
    	while (d != null) 
    	{
    		reversed.AddFirst(d.value());
    		d = d.next();
    	}
    	System.out.println(reversed);
    	
    }
    
    public void removeFirst()
    {
    	head = head.next();
    	if (head == null) 
    	{
    		tail = null;
    	}else
    	{
    		head.setPrevious(null);
    		count--;
    	}
    }
    
    public void removeLast()
    {
    	tail = tail.previous();
    	if (tail == null)
    	{
    		tail = null;
    	}else
    	{
    		tail.setNext(null);
    		count--;
    	}
    }
    
    public void reverse()
    {
    	DoubleLinkedListElement h = head;
    	DoubleLinkedListElement t = tail;
//    	int i = 0;
//    	while (t != null && h != null)
    	for (int i=0;i<this.size()/2;i++)
    	{
//    		DoubleLinkedListElement temp1 = t;
//    		DoubleLinkedListElement temp2 = h;
//    		h.next().setPrevious(temp1);
//    		t.previous().setNext(temp2);
//    		Object temp1 = h.value();
    		Object temp = t.value();
    		t.setValue(h.value());
    		h.setValue(temp);
    		h = h.next();
    		t = t.previous();
//    		i++;
//    		System.out.println(i);
    	}
    }
 
}