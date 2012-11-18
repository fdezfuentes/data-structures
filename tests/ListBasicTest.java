import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import list.LinkedList;

public class ListBasicTest {
	private List<Integer> list;

	@Before
	public void init() {
		list = new LinkedList<Integer>();
	}

	@Test
	public void initialTest() {
		assertEquals(list.size(), 0);
		assertTrue(list.isEmpty());
	}
	
	@Test (expected = IndexOutOfBoundsException.class)
	public void getFromEmptyList() {
		list.get(0);
	}
	
	@Test (expected = IndexOutOfBoundsException.class)
	public void setInEmptyList() {
		list.set(0, 1);
	}
	
	@Test (expected = IndexOutOfBoundsException.class)
	public void removeFromEmptyList() {
		assertTrue(list.isEmpty());
		list.remove(0);
	}
	
	@Test
	public void addingAndGetting() {
		assertTrue(list.isEmpty());
		list.add(9); // list = [9]
		assertTrue(!list.isEmpty());
		assertTrue(list.size() == 1);
		assertTrue(list.get(0) == 9);
		
		list.add(10); // list = [9, 10]
		list.add(11); // list = [9, 10, 11]
		list.add(12); // list = [9, 10, 11, 12]
		assertTrue(list.size() == 4);
		assertTrue(list.get(list.size() - 1) == 12);
		assertTrue(list.get(list.size() - 2) == 11);
	}
	
	@Test (expected = IndexOutOfBoundsException.class)
	public void removeOutOfRange() {
		list.add(1); // list = [1]
		list.add(2); // list = [1, 2]
		assertTrue(list.size() == 2);
		list.remove(3);
	}
	
	@Test
	public void removing() {
		assertTrue(list.isEmpty());
		list.add(1); // list = [1]
		list.add(2); // list = [1, 2]
		list.add(3); // list = [1, 2, 3]
		list.add(4); // list = [1, 2, 3, 4]
		assertTrue(list.size() == 4);
		
		list.remove(1); // list = [1,3,4]
		assertTrue(list.size() == 3);
		assertTrue(list.get(0) == 1);
		assertTrue(list.get(1) == 3);
		assertTrue(list.get(2) == 4);
				
		list.remove(0); // list = [3,4]
		assertTrue(list.size() == 2);
		assertTrue(list.get(0) == 3);
		assertTrue(list.get(1) == 4);
		
		list.remove(1); // list = [3]
		assertTrue(list.size() == 1);
		assertTrue(list.get(0) == 3);
	}
		
	@Test
	public void setting() {
		assertTrue(list.isEmpty());
		list.add(3); // list = [3]
		assertTrue(!list.isEmpty());
		assertTrue(list.size() == 1);
		assertTrue(list.get(0) == 3);
		
		list.add(4); // list = [3, 4]
		list.add(5); // list = [3, 4, 5]
		assertTrue(list.size() == 3);
		assertTrue(list.get(list.size() - 1) == 5);
		assertTrue(list.get(list.size() - 2) == 4);
		
		list.set(2, 99); // list = [3, 4, 99]
		assertTrue(list.get(list.size() - 1) == 99);
		
		list.add(6); // list = [3, 4, 99, 6]
		assertTrue(list.get(list.size() - 1) == 6);
		
		list.set((list.size() - 1), 100); // list = [3, 4, 99, 100]
		assertTrue(list.get(list.size() - 1) == 100);
	}
		 
	
	@After
	public void finish() {
		list = null;
	}
}