package src;

//Qingtian Mei
//frankmei@brandeis.edu
//02, 12, 2019
//PA1
/* This class is a Queue Object class, containing all the method and constructor for building a Queue class. This class will be the fundanmental object class that for building a station.*/
/*Known Bugs: None */

public class Queue<T> {

	T[] q;
	int head;
	int tail;
	int length;
	int size;
/**
 * this constructor will receive a int size, which will be used to size of the array. 
 * @param size int variable that will be the size of the array
 * Time Complexity: O(1)
 */
	@SuppressWarnings("unchecked")
	public Queue(int size){
		//TODO
		this.size = size;
		this.q = (T[]) new Object [size];
		this.head = 0;
		this.tail = 0;
		this.length =0;
	}
	
/**
 * this method receive a element and put to the head of the queue.
 * @throws Exception This queue is already full.
 * Time Complexity: O(1)
 */
	public void enqueue(T element) throws Exception {
		//TODO
		if(q[head]!=null) {
			throw new Exception("this Queue is full.");
		}
		q[head] = element;
		length++;
	    if(head!=size-1) {
	    	if(head+1!=tail) {
	    		head++;
	    	}else {
	    		head++;
	    	}
	    }else {
	    	if(tail!=0) {
	    		head = 0;
	    	}else {
	    		head = 0;
	    	}
	    }
	}
	
/**
 * this element takes the element from the end of the queue, then delete the end
 * @return the end of the queue
 * Time complexity: O(1)
 * @throws Exception The queue is already empty.
 */
	public T dequeue() throws Exception{
		//TODO
		if(q[tail] == null) {
			throw new Exception("this Queue is empty.");
		}
		T result = q[tail];
		 if(tail!=size-1) {
		    	if(tail+1!=head) {
		    		tail++;
		    	}else {
		    		tail++;
		    	}
		    	length--;
		    }else {
		    	if(head!=0) {
		    		tail= 0;
		    	}else {
		    		tail= head;
		    	}
		    	length--;
		    }
		 return result;
	}
	/**
	 * this element takes the element from the end of the queue, without deleting the end
	 * @return the end of the queue
	 * Time complexity: O(1)
	 */
	public T peek() {
		//TODO
		T result;
		if(head == 0) {
			if(q[size-1]==null) {
				return null;
			}else {
				result = q[size-1];
			}
		}else {
			if(q[head-1] == null) {
				return null;
			}else {
				result = q[head-1];
			}
		}
		return result;
		
	}
	/**
	 * This program will return the length of the queue
	 * @return the int length which will be the length of array.
	 * Time complexity: O(1)
	 */
	public int length() {
		//TODO
		return this.length;
	}
	/**
	 * This method returns the answer whether the queue is empty or not.
	 * @return Boolean statement whether the answer is true or not. 
	 * Time complexity: O(1)
	 */
	public boolean isEmpty() {
		//TODO
		if(this.length==0) {
		return true;
		}
		return false;
	}
	/**
	 * This method returns a String that contains all elements from the queue object.
	 * @return this method will return the string from all the element in the queue. 
	 * O(1) or O(N) depending on whether considering the length of array, constant or N.
	 */
	public String toString() {
		//TODO
		if(this.q == null) {
			return null;
		}
		String result ="";
		for(int i = 0; i<this.q.length;i++) {
			if(q[i] != null) {
				result =q[i].toString();
			}
		}
		result = this.q.toString();
		return result;
	}
	
}
