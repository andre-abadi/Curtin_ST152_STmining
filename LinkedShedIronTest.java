package stmining;

import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sajuuk
 */
public class LinkedShedIronTest {

    private ShipmentOrder so;
    private LinkedShedIron instance;

    public LinkedShedIronTest() {
    }

    @Before
    public void setUp() {

      //create an ore to be used
      Ore ironOre = new Ore("iron","kilos");
      //create some OrePiles to be used
      OrePile op1 = new OrePile(ironOre,1000,50);
      OrePile op2 = new OrePile(ironOre,2000,60);
      OrePile op3 = new OrePile(ironOre,3000,70);
      OrePile op4 = new OrePile(ironOre,4000,80);


      //initialize our shed
      instance = new LinkedShedIron("Jackson");

      //add some piles to the shed and then kill their original spots
      //to make sure they stick
      instance.addPile(op1);
      op1 = null;
      instance.addPile(op2);
      op2 = null;
      instance.addPile(op3);
      op3 = null;
      instance.addPile(op4);
      op4 = null;

      //create shipment order for the shed to fulfil
      so = new ShipmentOrder(ironOre, 100, "John", "Perth", 6500);

      //kill the ore object to make sure it was taken up by orepiles
      ironOre = null;
    }

    @After
    public void tearDown() {
      //kill the shed, all its children will be killed
      //and all spawning children copies have already been killed
      instance = null;
      so = null;
    }

  /**
   * Test of getName method, of class LinkedShedIron.
   */
  @Test
  public void testGetName() {
    System.out.println("getName");
    String expResult = "Jackson";
    String result = instance.getName();
    assertEquals(expResult, result);
  }

  /**
   * Test of setName method, of class LinkedShedIron.
   */
  @Test
  public void testSetName() {
    System.out.println("setName");
    String inputName = "TwoSheds";
    instance.setName(inputName);
    assertEquals(inputName, instance.getName());
  }

  /**
   * Test of getOreType method, of class LinkedShedIron.
   */
  @Test
  public void testGetOreType() {
    System.out.println("getOreType");
    String expResult = "iron";
    String result = instance.getOreType();
    assertEquals(expResult, result);
  }

  /**
   * Test of addPile method, of class LinkedShedIron.
   */
  @Test
  public void testAddPile() {
    System.out.println("addPile");
    Ore ironOre2 = new Ore("iron","kilos");
    OrePile op5 = new OrePile(ironOre2,5000,90);
    instance.addPile(op5);
    int result = 0;
    Iterator<OrePile> iter = instance.iterator();
    //iterate through shed to find last pile
    while (iter.hasNext() == true) {
      result = iter.next().getWeight();
    }
    int expResult = op5.getWeight();
    assertEquals(expResult, result);
  }

  /**
   * Test of totalOreWeight method, of class LinkedShedIron.
   */
  @Test
  public void testTotalOreWeight() {
    System.out.println("totalOreWeight");
    int expResult = 10000;
    int result = instance.totalOreWeight();
    assertEquals(expResult, result);
  }

  /**
   * Test of totalMetalWeight method, of class LinkedShedIron.
   */
  @Test
  public void testTotalMetalWeight() {
    System.out.println("totalMetalWeight");
    int expResult = 7000;
    int result = instance.totalMetalWeight();
    assertEquals(expResult, result);
  }

  /**
   * Test of satisfyOrder method, of class LinkedShedIron.
   */
  @Test
  public void testSatisfyOrder() {
    System.out.println("satisfyOrder");
    instance.satisfyOrder(so);
    assertEquals(9375, so.getShippedOreWt());
  }

  /**
   * Test of iterator method, of class LinkedShedIron.
   */
  @Test
  public void testIterator() {
    System.out.println("iterator");
    int expResult = 3000;
    Iterator<OrePile> iter = instance.iterator();
    int result = iter.next().getWeight();
    result += iter.next().getWeight();
    assertEquals(expResult, result);
  }

}