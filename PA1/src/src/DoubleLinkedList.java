package src;
//Qingtian Mei
//frankmei@brandeis.edu
//02, 12, 2019
//PA1
/* This class is a DoubleLinkedList Object class, containing all the method and constructor for building a double linkedlist  */
/* Known Bugs: the constructor without a parameter will create null head and null tails */


public class DoubleLinkedList<T> {
	Node<T> head;
	Node<T> tail;
	int length;
	/**
	 * this is a constructor without parameter, that will declare all the fields to null or 0;
	 * Time complexity:O(1)
	 */
	public DoubleLinkedList (){
		//TODO
		 this.head = null;
		 this.tail = null;
		 this.length = 0;
	}
	
	/**
	 * This constructor has one Station parameter, which will be the element of the head of the double linked list; 
	 * @param element the element to create the head;
	 * Time complexity:O(1)
	 */
	public DoubleLinkedList(Station element ) {
		this.head = new Node<T>();
		this.head.element = (T) element;
		this.head.next = null;
		this.head.prev = null;
		this.length = 1;
	}
	
	/**
	 * This method will get the head of the element;
	 * @return the head of the double linked list;
	 * Time complexity:O(1)
	 */
	public Node<T> getHead(){
		//TODO
		return this.head;
	}
	
	/**
	 * This method will get the tail of the element;
	 * @return the tail of the double linked list;
	 * Time complexity:O(1)
	 */
	public Node<T> getTail(){
		//TODO
		return this.tail;
	}
	
	/**
	 * The parameter takes in a key, create a node and then insert the node to the end of the double linkedlist. Return the key, which is inside of the list;
	 * @param key  T element that will be inserted into node and insert to the end of list.
	 * @return the T element as the tail of the list;
	 * Time complexity:O(1)
	 */
	public Node<T> insert(T key) {
		//TODO
		Node<T>z = new Node<T> (key,null,null);
		if (head == null) {
			head = z;
			length++;
			return head;
		}
		else if(tail== null||tail==head) {
			tail = z;
			z.next = null;
			head.next = tail;
			tail.prev = head;
			length++;
		}else {
		z.next= null;
		z.prev = tail;
		tail.next = z;
		tail = z;
		length++;
		}
		return tail;
		
	}
	
	/**
	 * This method receives a key and finds the Node that stores key then delete it. 
	 * @param key that will be compare with the keys that being stored in the list;
	 * Time Complexity: O(1) or O(N) depending on whether considering the length of array, constant or N.
	 */
	public void delete(T key) {
		Node<T> pointer = head;
		if(pointer == null) {
			System.out.println("there is no such key");
			return;
		}
		while(pointer.next!=null || pointer==head){
			if(pointer.element ==key  ) {
				if(length ==1) {
					this.head = null;
					pointer.next = null;
					pointer.prev = null;
					length--;
				}else if (pointer == tail) {
					head.next= null;
					tail = head;
					pointer.next = null;
					pointer.prev = null;
					length--;
				}
				else {
				pointer.prev.next= pointer.next;
				pointer.next.prev = pointer.prev;
				pointer.next = null;
				pointer.prev = null;
				length--;
				return;
				}
			}
			pointer = pointer.next;
		}
		System.out.println("there is no such key");
		//TODO
	}
	
	/**
	 * This method receives a key and finds the Node that stores then, key then return the node. 
	 * @param key that will be compare with the keys that being stored in the list;
	 * @return the node that contains the key;
	 * Time Complexity: O(1) or O(N) depending on whether considering the length of array, constant or N.
	 */
	public T get(T key){
		//TODO
		Node<T> pointer = this.head;
		if(pointer == null) {
			System.out.println("there is no such key");
			return null;
		}
		while(pointer!=null || pointer==head){
			Station check = (Station) pointer.element;
			Station find = (Station) key;
			if(check.stationName().equals(find.stationName())){
				return pointer.element;
			}
			pointer = pointer.next;
		}
		System.out.println("there is no such key");
		return null;
	}
	/**
	 * This method returns the length of the double linked list;
	 * @return integer the length of the double linked list.
	 * Time Complexity: O(1) 
	 */
	public int length() {
		//TODO
		return this.length;
	}
	
	
	/**
	 * This method return a string that is the sum of all the element inside the list;
	 * @return a string that consisted of all the element in the linked list.
	 * Time Complexity: O(1) or O(N) depending on whether considering the length of array, constant or N.
	 */
	public String toString() {
		//TODO
		String collect="";
		Node<T> pointer= head;
		while(pointer.next!=null || pointer==head ){
			collect = collect + "\n"+pointer.element.toString();
			pointer = pointer.next;
		}
		return collect;
	}
	
}
