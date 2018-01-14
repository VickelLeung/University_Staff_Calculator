//==========================================================================================
// Assignment #4
// Part: 1
// Written by: Vickel Leung, 40005344
//==========================================================================================

package A;

//linklist with inner class(Node)
public class listOfLinks <T>{
	
	// attributes
	private Node <T> head;
	
	
	// create an empty list
	public listOfLinks(){
		head = null;
	}
	
	// This method will iterate throught the entire linkedList and return the total string
	public String iteration(){
		
		Node <T> t = head;
		
		String s = "";
	
		// keep going to next node till t is null
		while(t!= null){
			
			T str = t.object;
			s += str + "\n";
			
			t= t.next;
		}
		
		return s;
		
	}
	
	// this method find a specific value and print it
	public void findAndPrint(int i)
	{
		Node t = head;
		while( t != null )
		{
			// check if the value is the same as the given
			if ( ((fullTimeFaculty) t.object).getSalary() == i)
			{
				// print object if it is the same
				System.out.println(t.object);
			}
			t = t.next;	// move pointer to next node
		}
		
		return;
	}
	
	// add node to linklist
	public void addNode(T x){
		if(head == null)
			head = new Node<T>(x, head);
		
		else
		{
			Node <T> t = head;
			while(t.next!=null)
				t = t.next;
			
			t.next = new Node(x, null);
		}
	}
	
	// will print at specific index
	public String printNode(int index){
		String str = null;
		
		Node t = head;
		
		int ctr =0;
		
		while(t!=null){
			
			if(index == ctr )
			{
				str = t.object.toString();
			}
			
			ctr++;
			t = t.next;
		}
		
		
		return str;
	}
	
	// display the linkedList
	public void display(){
		Node<T> t = head;
		
		if(t == null)
			System.out.println("it's empty");
		
		while(t.next!=null){
			System.out.print(t.object+" ->\n");
			t=t.next;
		}
		System.out.println(t.object);
	}
	
	// iterate throught the entired linkList and add them
	public double sumAllNode(){
		
		Node <T> t = head;
		
		if(head == null)
			return 0;
		
		double total = 0;
		
		while(t!= null)
		{
			total += (double) t.object;
			
			t = t.next;
		}
		
		return total;
		
	}
	
	// get the size of the linkedList
	public int sizeNode(){
		
		//starting point
		Node <T> t = head;
		
		int ctr =1;
		
		// if head = null then return 0
		if(head == null)
			return 0;
		
		while(t.next != null)
		{
			t = t.next;
			ctr++;
		}
		
		return ctr;
		
	}
	
	//find highest in a linkedList
	public int highestNode(){
		
		Node <T> t = head;
		
		if(head == null)
			return 0;
		
		int temp = (int) t.object;
		
		while(t!= null)
		{
			if(temp < (int)t.object)
			temp = (int)t.object;
				
			t = t.next;
		}
		
		return temp;
	}
	
	//find lowest in a linkedList
	public int lowestNode(){
		Node<T> t = head;
		
		if(head == null)
			return 0;
		
		int temp = (int) t.object;
		while(t != null){
			if(temp > (int)t.object)
				temp = (int)t.object;
			t = t.next;
		}
		
		return temp;	
	}
	
	
	// inner class node, so we don't need to use getters
      class Node <T>{
       
       private Node <T> next;
       private T object;
    
       		// Default constructors 
    		public Node()
    		{
    			object = null;
    			next = null;
    		}
    		
    		
    		// Parameterized constructor 
    		public Node(T y, Node<T> x)
    		{
    			object = y;		
    			next = x;
    		}    		
    		
    		public void setX(T y)
    		{
    			object = y;		
    		}
    		
    		public void setNext(Node<T> x)
    		{
    			next = x;
    		}
    		
    		
    		public T getObject()
    		{
    			return object;	
    		}
    		
    		
    		public Node<T> getNext()
    		{
    			return next;
    		}
      
     }
}