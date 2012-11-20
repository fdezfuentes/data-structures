import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import list.ArrayList;
import list.LinkedList;

public class ListMiscTest {
	private List<Integer> list;

	@Before
	public void init() {
		// list = new LinkedList<Integer>();
		list = new ArrayList<Integer>();
	}
	
	@Test
	public void emptyListtoArray() {
		assertTrue(list.isEmpty());
		assertTrue(list.toArray().length == 0);
	}
	
	@Test
	public void listToArray() {
		assertTrue(list.isEmpty());
		list.add(new Integer(1)); // list = [1]
		list.add(new Integer(2)); // list = [1, 2]
		list.add(new Integer(3)); // list = [1, 2, 3]
		list.add(new Integer(4)); // list = [1, 2, 3, 4]
		assertTrue(list.size() == 4);

		Object[] array = list.toArray();
		assertTrue(array.length == 4);
		
		for (int i = 0; i < list.size(); i++) {
			assertTrue(list.get(i).equals(array[i]));
		}
	}
	
	@After
	public void finish() {
		list = null;
	}
}