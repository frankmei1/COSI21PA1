package src;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DoubleLinkedListTest {
	public static final String First= "Qingtian";
	public static final String Last = "Mei";
	@Test
	void testDoubleLinkedList() {
		DoubleLinkedList<Station> test = new DoubleLinkedList();
		assertEquals(null,test.head);
	}

	@Test
	void testDoubleLinkedListStation() {
		Station test1 = new Station(First);
		DoubleLinkedList<Station> test = new DoubleLinkedList(test1);
		assertEquals(First,test.head.element.name);
	}

	@Test
	void testGetHead() {
		Station test1 = new Station(First);
		DoubleLinkedList<Station> test = new DoubleLinkedList(test1);
		assertEquals(test.head,test.getHead());
	}

	@Test
	void testGetTail() {
		DoubleLinkedList<Station> test = new DoubleLinkedList();
		assertEquals(null,test.getTail());
	}

	@Test
	void testInsert() {
		Station test1 = new Station(First);
		Station test2 = new Station(Last);
		DoubleLinkedList<Station> test = new DoubleLinkedList(test1);
		test.insert(test2);
		assertEquals(test2,test.getTail().element);
		
	}
	@Test
	void testDelete() {
		Station test1 = new Station(First);
		DoubleLinkedList<Station> test = new DoubleLinkedList(test1);
		Station test2 = new Station(Last);
		test.insert(test2);
		test.delete(test1);
		assertEquals(test2,test2);
	}

	@Test
	void testGet() {
		Station test1 = new Station(First);
		Station test2 = new Station(Last);
		DoubleLinkedList<Station> test = new DoubleLinkedList(test1);
		test.insert(test2);
		test.insert(test2);
		assertEquals(test2,test.get(test2));
	}

	@Test
	void testLength() {
		Station test1 = new Station(First);
		Station test2 = new Station(Last);
		Station test3 = new Station (First+Last);
		DoubleLinkedList<Station> test = new DoubleLinkedList(test1);
		test.insert(test2);
		test.insert(test2);
		test.insert(test3);
		assertEquals(test.length,test.length());
	}

	@Test
	void testToString() {
		Station test1 = new Station(First);
		Station test2 = new Station(Last);
		Station test3 = new Station (First+Last);
		DoubleLinkedList<Station> test = new DoubleLinkedList(test1);
		test.insert(test2);
		test.insert(test2);
		test.insert(test3);
		Node<Station> pointer= test.head;
		String collect="";
		while(pointer.next!=null || pointer== test.head ){
			collect = collect + "\n"+pointer.element.toString();
			pointer = pointer.next;
		}
		assertEquals(collect,test.toString());
	}
}
