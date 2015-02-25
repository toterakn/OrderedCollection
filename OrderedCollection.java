# OrderedCollection


/**
 * OrderedCollection stores a collection of Comparables (in an array), along with 
 * the current size of the collection.
 * 
 * Elements ordered in ascending order according to the Comparable stored
 * 
 * Data stored in a singly-linked list with head and tail pointers (that are empty nodes)
 * 
 * insert method is given by professor
 * 
 * @author Kristina Totera
 * February 9, 2015
 */
public class OrderedCollection<T extends Comparable<? super T>> {
    
    /******** an inner class  **********************
     * The node type for a linked list OrderedCollection
     */
    private static class Node<T> {
        
        public Node(T x) {
            data = x; next = null;           
        }
        
        public T data;
        public OrderedCollection.Node<T> next;
    }
    /**********************************************************/
    
    // The OrderedCollection data - its instance variables
    
    private OrderedCollection.Node<T> front; // front marker
    private OrderedCollection.Node<T> tail; // tail marker
    private int actualSize; // how many elements currently stored
    private int maxSize; // not relevant to linked list
    /**
     * Constructor allocates array and initializes size
     * @param size the number of elements stored
     */
    public OrderedCollection (int capacity) {
        
        maxSize = capacity;
        actualSize = 0; 
        front = null;  // When list is empty, front is null
    }
    
    /**
     * 
     * @return a String representation of the list
     */
    public String toString(){
        OrderedCollection.Node walker = front;
        String returnString = "";
        while (walker != null){
            returnString += walker.data + "\n";
            walker = walker.next;
        }  
        return returnString;
    }

    /**
     * isEmpty determines if collection has no elements
     * @return true if collection empty, false otherwise
     */
    
    public boolean isEmpty(){
        return front == null;
    }
    
    /**
     * makeEmpty resets the collection to be empty, and sets size to 0
     */ 
    public void makeEmpty(){
        actualSize = 0;
        front = null;
    }
       
    /**
     * insert value x in collection, maintaining ascending order of elements. 
     *    actualSize incremented
     * if collection already at capacity (maxSize), collection unchanged
     * does not insert duplicates
     * @param x the element to add to the collection
     * insert Method given by professor.
     */
   
    public void insert(T x) {
        
        // Insert in order
    	
        //if (actualSize < maxSize){
    	if(contains(x)){
    		//do no inert
    	}else{
            // make a new Node
            OrderedCollection.Node newNode = new OrderedCollection.Node<>(x);
             
            // Figure out where new node goes
            // Is list empty? If not, does it go first? 
            //    the actions are the same in either case
            if (front == null || (front.data).compareTo(x) > 0){ // yes, node goes first
                newNode.next = front;
                front = newNode;
            }
            else{ // must find location to place new node, and keep track of
                 // previous node as well - requires an extra "walker"
                OrderedCollection.Node<T> current = front.next; // place being considered
                OrderedCollection.Node<T> previous = front;  // one postion behind
                while (current != null && current.data.compareTo(x) < 0){
                   previous = current;
                   current = current.next;
                }
                // Place node after "previous"
                previous.next = newNode;
                newNode.next = current;
            }              
            actualSize++;
        }             
    }
    
    /**
     * ~~~additional method~~~
     * private method, checks to see if x is contained in the list
     * @param x, the element being searched for
     * @return true if x is in list. false if x is not.
     */
    private boolean contains(T x){
    	OrderedCollection.Node<T> current = front;
        while (current != null){
        	if (current.data.equals(x)){
        		return true;
        	}
        	current = current.next;
        }
        return false;
    }
    
    /**
     * remove the specified element from the collection
     *    if the element is not in the list, the method does
     *    nothing
     * @param the element to remove
     */
    public void remove (T x) throws ItemNotFoundException{
    	
    	OrderedCollection.Node<T> current = front;
        OrderedCollection.Node<T> previous = null;
        
        if (contains(x)){
        	//x is in the list
        	while(!current.data.equals(x)){
            	if(current.next == null){
            		break;
            	}else{
            		previous = current;
            		current = current.next;
            	}
            }
            if (current == front){
            	front = front.next;
            }else{
            	previous.next = current.next;
            }
            actualSize--;
        }else{
        	//do nothing because x is not in the list
        	String message = String.format( "Item not found");
			throw new ItemNotFoundException( message );
        }
    }
    
    /**
     * findMin returns a reference the minimum element in the collection
     * 
     * @return the reference of the minimum element or 
     * null if the collection is empty
     *
     */
 
    public T findMin( ){
        return front.data;
    }

    
    /**
     * findMax returns a reference to the maximum element in the collection
     * 
     * @return the reference the the maximum element in the collection or 
     * null if the collection is empty
     */
 
    public T findMax( ){

    	OrderedCollection.Node<T> current = front;
    	OrderedCollection.Node<T> previous = null;
        while (current != null){
        	previous = current;
        	current = current.next;
        }
        return previous.data;
    }   

    
     
    public static void main(String[] args){
    	try{
    		OrderedCollection<Integer> o = new OrderedCollection<>(10);
            o.insert(2);
            o.insert(30);
            o.insert(20);
            o.insert(7);
            o.insert(20);
            System.out.println(o.toString());
            System.out.print("The min value is: ");
            System.out.println(o.findMin());
            System.out.print("The max value is: ");
            System.out.println(o.findMax());
            System.out.print("The list is empty. ");
            System.out.println(o.isEmpty());
            
            o.remove(2);
            o.remove(30);
            //o.remove(5);
            
            System.out.println(o.toString());
            
            o.makeEmpty();
            System.out.println(o.toString());
            System.out.print("The list is empty. ");
            System.out.println(o.isEmpty());
            
            o.insert(5);
            o.insert(22);
            o.insert(76);
            o.insert(27);
            o.insert(100);
            System.out.println(o.toString());
            System.out.print("The min value is: ");
            System.out.println(o.findMin());
            System.out.print("The max value is: ");
            System.out.println(o.findMax());
            
            o.insert(100);
            o.remove(1);
            System.out.println(o.toString());
            
          
    	}catch(ItemNotFoundException e){
    		System.out.println(e);		
    	}
   
     } 
}// end class OrderedCollection2
