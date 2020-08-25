package src;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NodeTest {
	 public static final String First= "Qingtian";
	 public static final String Last = "Mei";
	 void testConstructor() {
		Node test = new Node(First,null,null);
		assertEquals(First,test.element);
		Node test2 = new Node();
		assertEquals(null,test2.element);
	 }
	@Test
	void testSetElement() {
		Node test = new Node(First,null,null);
		test.setElement(Last);
		assertEquals(Last,test.element);
		test.setElement(null);
		assertEquals(null,test.element);
	}

	@Test
	void testGetElement() {
		Node test = new Node(First,null,null);
		assertEquals(First,test.getElement());
		Node test2 = new Node();
		assertEquals(null,test2.element);
	}

	@Test
	void testSetNext() {
		Node test = new Node(First,null,null);
		Node test2 = new Node();
		test.setNext(test2);
		assertEquals(test2,test.getNext());
	}

	@Test
	void testSetPrev() {
		Node test = new Node(First,null,null);
		Node test2 = new Node();
		test.setPrev(test2);
		assertEquals(test2,test.getPrev());
	}

	@Test
	void testGetNext() {
		Node test = new Node(First,null,null);
		Node test2 = new Node();
		test.setNext(test2);
		assertEquals(test.next,test.getNext());
	}

	@Test
	void testGetPrev() {
		Node test = new Node(First,null,null);
		Node test2 = new Node();
		test.setPrev(test2);
		assertEquals(test.prev,test.getPrev());
	}

	@Test
	void testToString() {
		Node test = new Node(First,null,null);
		assertEquals(test.element.toString(),test.toString());
	}


}
