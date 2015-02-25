# OrderedCollection
#Used in Ordered Collection class


/**
 * 
 * @author Kristina Totera
 * Program Assignment 3
 * @date February 5, 2015
 * 
 * ItemNotFoundException Class, inherits from Exception
 * creates the ItemNotFoundException that is used in the OrderedCollection.java
 * for the linked list one
 * 
 */

public class ItemNotFoundException extends Exception{
	/**
	 * public constructor that calls super class constructor
	 * to set the message variable
	 * @param message
	 */
	public ItemNotFoundException(String message){
		super(message);
	}

}
