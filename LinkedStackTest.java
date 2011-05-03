package stmining;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sajuuk
 */
public class LinkedStackTest {

    private LinkedStack<OrePile> instance;

    public LinkedStackTest() {
    }

    @Before
    public void setUp() {
      instance = new LinkedStack<OrePile>();
    }

    @After
    public void tearDown() {
      instance = null;
    }

  /**
   * Test of push method, of class LinkedStack.
   */
  @Test
  public void testPush() {
    System.out.println("push");
    Ore ore = new Ore("iron","grams");
    OrePile object = new OrePile(ore,1000,50);
    instance.push(object);
    int expResult = object.getWeight();
    int result = instance.peek().getValue().getWeight();
    assertEquals(expResult, result);
  }

  /**
   * Test of pop method, of class LinkedStack.
   */
  @Test
  public void testPop() {
    System.out.println("pop");
    //create 2 ores
    Ore ore = new Ore("iron","grams");
    Ore ore2 = new Ore("nickel","kilos");
    //use them for 2 OrePiles
    OrePile object1 = new OrePile(ore,1000,50);
    OrePile object2 = new OrePile(ore2,2000,60);
    //push them onto the stack
    instance.push(object1);
    instance.push(object2);
    //popping the top of the stack twice should give object1 (second last added)
    //and we'll use its weight as the expected result
    int expResult = object1.getWeight();
    instance.pop();
    int result = instance.pop().getValue().getWeight();
    //now we'll check whether they're equal
    assertEquals(expResult, result);
  }

  /**
   * Test of peek method, of class LinkedStack.
   */
  @Test
  public void testPeek() {
    System.out.println("peek");
    //create 2 ores
    Ore ore = new Ore("iron","grams");
    Ore ore2 = new Ore("nickel","kilos");
    //use them for 2 OrePiles
    OrePile object1 = new OrePile(ore,1000,50);
    OrePile object2 = new OrePile(ore2,2000,60);
    //push them onto the stack
    instance.push(object1);
    instance.push(object2);
    //peeking at the top of the stack should give object1 (last added)
    //and we'll use its weight as the expected result
    int expResult = object2.getWeight();
    //and peek at the top object's weight
    int result = instance.peek().getValue().getWeight();
    //now we'll check whether they're equal
    assertEquals(expResult, result);
  }

  /**
   * Test of isEmpty method, of class LinkedStack.
   */
  @Test
  public void testIsEmpty() {
    System.out.println("isEmpty");
    boolean expResult = false;
    //create 2 ores
    Ore ore = new Ore("iron","grams");
    Ore ore2 = new Ore("nickel","kilos");
    //use them for 2 OrePiles
    OrePile object1 = new OrePile(ore,1000,50);
    OrePile object2 = new OrePile(ore2,2000,60);
    //push them onto the stack
    instance.push(object1);
    instance.push(object2);
    boolean result = instance.isEmpty();
    assertEquals(expResult, result);
  }

}