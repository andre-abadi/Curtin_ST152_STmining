package stmining;

import java.util.Arrays;
import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sajuuk
 */
public class LinkedListTest {
  
    private LinkedList<OrePile> instance;

    public LinkedListTest() {
    }

    @Before
    public void setUp() {
      instance = new LinkedList<OrePile>();
      Ore ore = new Ore("iron","grams");
      OrePile object = new OrePile(ore,1000,50);
      ore = null;
      instance.insertFirst(object);
      Ore ore2 = new Ore("nickel","kilograms");
      OrePile object2 = new OrePile(ore2,2000,60);
      ore2 = null;
      instance.insertLast(object2);
      Ore ore3 = new Ore("nickel","kilograms");
      OrePile object3 = new OrePile(ore3,3000,70);
      ore2 = null;
      instance.insertLast(object3);
    }

    @After
    public void tearDown() {
      instance = null;
    }

  /**
   * Test of isEmpty method, of class LinkedList.
   */
  @Test
  public void testIsEmpty() {
    System.out.println("isEmpty");
    boolean expResult = false;
    boolean result = instance.isEmpty();
    assertEquals(expResult, result);
  }

  /**
   * Test of insertFirst method, of class LinkedList.
   */
  @Test
  public void testInsertFirst() {
    System.out.println("insertFirst");
    Ore ore4 = new Ore("iron","grams");
    OrePile object = new OrePile(ore4,4000,80);
    instance.insertFirst(object);
    assertEquals(object.getWeight(),
            instance.getFirst().getValue().getWeight());
  }

  /**
   * Test of insertLast method, of class LinkedList.
   */
  @Test
  public void testInsertLast() {
    System.out.println("insertLast");
    Ore ore5 = new Ore("iron","grams");
    OrePile object = new OrePile(ore5,5000,90);
    instance.insertLast(object);
    assertEquals(object.getWeight(),
            instance.getLast().getValue().getWeight());
  }

  /**
   * Test of getFirst method, of class LinkedList.
   */
  @Test
  public void testGetFirst() {
    System.out.println("getFirst");
    int expResult = 1000;
    int result = instance.getFirst().getValue().getWeight();
    assertEquals(expResult, result);
  }

  /**
   * Test of getLast method, of class LinkedList.
   */
  @Test
  public void testGetLast() {
    System.out.println("getLast");
    int expResult = 3000;
    int result = instance.getLast().getValue().getWeight();
    assertEquals(expResult, result);
  }

  /**
   * Test of deleteFirst method, of class LinkedList.
   */
  @Test
  public void testDeleteFirst() {
    System.out.println("deleteFirst");
    int expResult = 1000;
    int result = instance.deleteFirst().getValue().getWeight();
    assertEquals(expResult, result);
  }

  /**
   * Test of iterator method, of class LinkedList.
   */
  @Test
  public void testIterator() {
    System.out.println("iterator");
    //create an iterator to iterate through our test (instance) list
    Iterator<OrePile> it = instance.iterator();
    //we will construct 2 arrays, one with expected values
    //the other with the values that the iterator pulled out
    //we will then compare the arrays and below shows that we expect the
    //comparison function to return true
    boolean expResult = true;
    //an array containing the correct weights of the OrePile Links
    //that were created in setUp()
    int[] expected = new int[3];
    expected[0] = 1000;
    expected[1] = 2000;
    expected[2] = 3000;
    //creates an array of length matching the number of links
    //created in setUp()
    int[] results = new int[3];
    //counter for dumping iterated link weight values into array
    int ii = 0;
    while (it.hasNext() == true) {
      //put the weight of the next link into the array of results
      results[ii] = it.next().getWeight();
      //increment the array-dumping counter
      ii += 1;
    }
    //the array comparison function should return true and thereby match our
    //expected result of true
    //the iterator and predefine arrays should both at this point contain
    // {1000, 2000, 3000}
    assertEquals(expResult, Arrays.equals(expected, results));
  }

}