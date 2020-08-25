package src;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class QueueTest {
	public static final String First= "Qingtian";
	public static final String Last = "Mei";
	@Test
	void testQueue() {
		Station test1 = new Station(First);
		Queue<Station>test = new Queue(0);
		assertEquals(0,test.size);
	}

	@Test
	void testEnqueue() throws Exception {
		Queue<Station>test = new Queue(0);
		Station test1 = new Station(First);
		test.enqueue(test1);
		assertEquals(test1,test.dequeue());
	}

	@Test
	void testDequeue() throws Exception {
		Queue<Station>test = new Queue(0);
		Station test1 = new Station(First);
		test.enqueue(test1);
		assertEquals(test1,test.dequeue());
	}

	@Test
	void testPeek() throws Exception {
		Queue<Station>test = new Queue(0);
		Station test1 = new Station(First);
		test.enqueue(test1);
		assertEquals(test1,test.peek());
	}

	@Test
	void testLength() throws Exception {
		Queue<Station>test = new Queue(0);
		Station test1 = new Station(First);
		test.enqueue(test1);
		assertEquals(2,test.length());
	}

	@Test
	void testIsEmpty() {
		Queue<Station>test = new Queue(0);
		Station test1 = new Station(First);
		assertEquals(true,test.isEmpty());
	}

	@Test
	void testToString() throws Exception {
		Queue<Station>test = new Queue(0);
		Station test1 = new Station(First);
		test.enqueue(test1);
		
		
		String result ="";
		for(int i = 0; i<test.q.length;i++) {
			if(test.q[i] != null) {
				result =test.q[i].toString();
			}
		}
		result = test.q.toString();
		assertEquals(result,test.toString());
	}


}
