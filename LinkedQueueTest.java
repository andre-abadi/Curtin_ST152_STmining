package stmining;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sajuuk
 */
public class LinkedQueueTest {

    private LinkedQueue<OrePile> instance;

    public LinkedQueueTest() {
    }

    @Before
    public void setUp() {
      instance = new LinkedQueue<OrePile>();
    }

    @After
    public void tearDown() {
      instance = null;
    }

  /**
   * Test of enqueue method, of class LinkedQueue.
   */
  @Test
  public void testEnqueue() {
    System.out.println("enqueue");
    Ore ore = new Ore("iron","grams");
    OrePile object = new OrePile(ore,1000,50);
    instance.enqueue(object);
    assertEquals(object.getWeight(),
            instance.peek().getValue().getWeight());
  }

  /**
   * Test of dequeue method, of class LinkedQueue.
   */
  @Test
  public void testDequeue() {
    System.out.println("dequeue");
    //create 2 ores
    Ore ore = new Ore("iron","grams");
    Ore ore2 = new Ore("nickel","kilos");
    //use them for 2 OrePiles
    OrePile object1 = new OrePile(ore,1000,50);
    OrePile object2 = new OrePile(ore2,2000,60);
    //enqueue them
    instance.enqueue(object1);
    instance.enqueue(object2);
    //object2 is at back of queue, hence dequeued last
    //therefore object2's weight is expected result
    int expResult = object2.getWeight();
    //and we are looking at the second dequeued object's weight
    instance.dequeue();
    int result = instance.dequeue().getValue().getWeight();
    assertEquals(expResult, result);
  }

  /**
   * Test of peek method, of class LinkedQueue.
   */
  @Test
  public void testPeek() {
    System.out.println("peek");
    Ore ore = new Ore("iron","grams");
    Ore ore2 = new Ore("nickel","kilos");
    //use them for 2 OrePiles
    OrePile object1 = new OrePile(ore,1000,50);
    OrePile object2 = new OrePile(ore2,2000,60);
    instance.enqueue(object1);
    instance.enqueue(object2);
    //object1 was the first item enqueued therefore is at front of queue
    int expResult = object1.getWeight();
    //peeking should pull weight of front-most item, which should match this
    int result = instance.peek().getValue().getWeight();
    assertEquals(expResult, result);
  }

  /**
   * Test of isEmpty method, of class LinkedQueue.
   */
  @Test
  public void testIsEmpty() {
    System.out.println("isEmpty");
    boolean expResult = false;
    //enqueue an item
      Ore ore = new Ore("iron","grams");
      OrePile object1 = new OrePile(ore,1000,50);
      instance.enqueue(object1);
    boolean result = instance.isEmpty();
    assertEquals(expResult, result);
  }
}