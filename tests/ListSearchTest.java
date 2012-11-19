import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import list.ArrayList;
import list.LinkedList;

public class ListSearchTest {
	private List<Integer> list;

	@Before
	public void init() {
		// list = new LinkedList<Integer>();
		list = new ArrayList<Integer>();
	}
	
	@Test
	public void containsInEmptyList() {
		assertTrue(list.isEmpty());
		assertTrue(!list.contains(new Integer(1)));
	}
	
	@Test
	public void contains() {
		assertTrue(list.isEmpty());
		list.add(new Integer(1)); // list = [1]
		list.add(new Integer(2)); // list = [1, 2]
		list.add(new Integer(3)); // list = [1, 2, 3]
		list.add(new Integer(4)); // list = [1, 2, 3, 4]
		assertTrue(list.size() == 4);
		assertTrue(list.contains(new Integer(1)));
		assertTrue(list.contains(new Integer(3)));
		assertTrue(list.contains(new Integer(4)));
		assertTrue(!list.contains(new Integer(5)));
	}
	
	@Test
	public void IndexOfOnEmptyList() {
		assertTrue(list.isEmpty());
		assertTrue(list.indexOf(new Integer(1)) == -1);
	}
	
	@Test
	public void IndexOfAnUnexistingElement() {
		assertTrue(list.isEmpty());
		list.add(new Integer(1)); // list = [1]
		list.add(new Integer(2)); // list = [1, 2]
		list.add(new Integer(3)); // list = [1, 2, 3]
		list.add(new Integer(4)); // list = [1, 2, 3, 4]
		assertTrue(list.size() == 4);
		assertTrue(list.indexOf(new Integer(5)) == -1);
	}
	
	@Test
	public void IndexOfAnExistingElement() {
		assertTrue(list.isEmpty());
		list.add(new Integer(1)); // list = [1]
		list.add(new Integer(2)); // list = [1, 2]
		list.add(new Integer(3)); // list = [1, 2, 3]
		list.add(new Integer(4)); // list = [1, 2, 3, 4]
		assertTrue(list.size() == 4);
		assertTrue(list.indexOf(new Integer(4)) == 3);
		assertTrue(list.indexOf(new Integer(3)) == 2);
		assertTrue(list.indexOf(new Integer(2)) == 1);
		assertTrue(list.indexOf(new Integer(1)) == 0);
	}
	
	@Test
	public void lastIndexOfAnUnexistingElement() {
		assertTrue(list.isEmpty());
		assertTrue(list.lastIndexOf(new Integer(9)) == -1);
		
		list.add(new Integer(1)); // list = [1]
		list.add(new Integer(2)); // list = [1, 2]
		list.add(new Integer(3)); // list = [1, 2, 3]
		list.add(new Integer(4)); // list = [1, 2, 3, 4]
		assertTrue(list.size() == 4);
		assertTrue(list.lastIndexOf(new Integer(9)) == -1);
	}
	
	@Test
	public void lastIndexOfAnExistingElement() {
		assertTrue(list.isEmpty());
		list.add(new Integer(1)); // list = [1]
		list.add(new Integer(3)); // list = [1, 3]
		list.add(new Integer(2)); // list = [1, 3, 2]
		list.add(new Integer(3)); // list = [1, 3, 2, 3]
		list.add(new Integer(4)); // list = [1, 3, 2, 3, 4]
		list.add(new Integer(4)); // list = [1, 3, 2, 3, 4, 4]
		assertTrue(list.size() == 6);
		assertTrue(list.lastIndexOf(new Integer(4)) == 5);
		assertTrue(list.lastIndexOf(new Integer(3)) == 3);
		assertTrue(list.lastIndexOf(new Integer(2)) == 2);
		assertTrue(list.lastIndexOf(new Integer(1)) == 0);
	}
	
	@After
	public void finish() {
		list = null;
	}
}