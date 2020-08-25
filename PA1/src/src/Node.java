package src;
//Qingtian Mei
//frankmei@brandeis.edu
//02 12, 2019
//PA1
/* This class is the object class for Node, which is used for building a doubly linked list.This class will be the most basic class that serve for the double LinkedList*/
/* Known Bugs: The constructors without parameter will create all the fields inside the node object to be null */

public class Node<T> {

	T element;
	Node<T> next;
	Node<T> prev;

/**
 * A constructor of Node object without parameter, creating everything inside to point null.
 * Time complexity: O(1)
 */
	public Node() {
		this.element = null;
		next= null;
		prev = null;
		//TODO
	}
	
/**
 * A constructor of Node object with three parameters. 
 * @param element the value of the Node
 * @param next   the next pointer of the Node
 * @param prev   the prev pointer of the Node
 * Time Complexity: O(1)
 */
	public Node(T element, Node<T> next, Node<T> prev) {
		this.element = element; 
		this.next = next;
		this.prev = prev;
		//TODO
	}
	

/**
 * This method can reset the element of a specific Node object to the input parameter
 * @param element, the value that the method want to use to replace the element of the Node.
 * Time Complexity: O(1)
 */
	public void setElement(T element) {
		this.element = element;
		//TODO
	}
	
/**
 * This method doesn't require a parameter. It returns a key of the specific Node.
 * @return T element of the node
 * Time Complexity: O(1)
 */
	public T getElement() {
		return this.element;
		//TODO
	}
/**
 * This method requires a Node parameter. It sets the calling Node's next pointing to the parameter node. 
 * @param next Node object parameter.
 * Time Complexity: O(1)
 */
	public void setNext(Node<T> next) {
		this.next = next;
		//TODO
	}

/**	
 * This method requires a Node parameter.It sets the calling Node's prev pointing to the parameter node. 
 * @param prev Node object parameter.
 * Time Complexity: O(1)
 */
	public void setPrev(Node<T> prev) {
		this.prev = prev;
		//TODO
	}

/**
 * This method return the Node that the calling Node's next pointing to.
 * @return Node Object of the next that Next pointer points to. 
 * Time Complexity: O(1)
 */
	public Node<T> getNext() {
		//TODO
		return this.next;
	}
	
/**
 * This method return the Node that the calling Node's prev pointing to.
 * @return Node Object of the prev that prev pointer points to. 
 * Time Complexity: O(1)
 */
	public Node<T> getPrev(){
		//TODO
		return this.prev;
	}
	
/**
 * This method returns a String object of the element of the Node. 
 * Time Complexity: O(1)
 */
	public String toString() {
		//TODO
		if(this.element == null) {
			return null;
		}
		String result = this.element.toString();
		return result;
	}
	
}
