/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		
	}
	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			System.out.println(emptyList.get(0));
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
			
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		
		// TODO: Add more tests here
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
        // TODO: implement this test
		MyLinkedList<Integer> newList = new MyLinkedList<Integer>();
		newList.add(12);
		shortList.add("C");
		assertEquals("shortList.get(2) ","C",shortList.get(2));
		assertEquals("shortList.get(1) ",Integer.valueOf(12),newList.get(0));
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		// TODO: implement this test
		assertEquals("shortList size" ,2,shortList.size);
		shortList.add("D");
		assertEquals("shortList size" ,3,shortList.size);
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
        // TODO: implement this test
		shortList.add(0,"Q");
		assertEquals("AddAtIndex test","Q", shortList.get(0));
		
		try {
			emptyList.add(3,12);
			fail("this should be index out of bounds exception");
		}catch(IndexOutOfBoundsException e) {}

		emptyList.add(12);
		emptyList.add(0,200);
		emptyList.add(1,13); //200,13,12
		assertEquals("emptyList add at 0",Integer.valueOf(200), emptyList.get(0));
		assertEquals("emptyList ",Integer.valueOf(13), emptyList.get(1));
		System.out.println(emptyList.size);
		assertEquals("emptyList addend 1",Integer.valueOf(12), emptyList.get(2));

		MyLinkedList<Integer> emptyTest = new MyLinkedList<Integer>();
		emptyTest.add(0,1);
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
	    // TODO: implement this test
		try {
			emptyList.set(0, null);
			fail("should be nullpointexception");
			}catch(NullPointerException e) {}
		
		emptyList.add(13);
		try {
			emptyList.set(1, 100);
			fail("should be indexoutofboundsexception");
		}catch(IndexOutOfBoundsException e) {} 
		try {
			emptyList.set(-1, 100);
			fail("should be indexoutofboundsexception");
		}catch(IndexOutOfBoundsException e) {} 
		emptyList.set(0,150);
		assertEquals("setting method testing..",Integer.valueOf(150),emptyList.get(0));
	}
	
	
	// TODO: Optionally add more test methods.
	
}
