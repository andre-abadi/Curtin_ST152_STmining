package stmining;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sajuuk
 */
public class LinkTest {

    Link<OrePile> instance;

    public LinkTest() {
    }

    @Before
    public void setUp() {
      Ore ore = new Ore("iron","grams");
      OrePile object = new OrePile(ore,1000,50);
      instance = new Link<OrePile>(object);
    }

    @After
    public void tearDown() {
      instance = null;
    }

  /**
   * Test of getNext method, of class Link.
   */
  @Test
  public void testGetNext() {
    System.out.println("getNext");
    assertEquals(null, instance.getNext());
  }

  /**
   * Test of setNext method, of class Link.
   */
  @Test
  public void testSetNext() {
    System.out.println("setNext");
    Ore ore = new Ore("aluminium","tonnes");
    OrePile orepile = new OrePile(ore,3000,70);
    Link<OrePile> newNext = new Link<OrePile>(orepile);
    instance.setNext(newNext);
    assertEquals(orepile.getWeight(),
            instance.getNext().getValue().getWeight());
  }

  /**
   * Test of getValue method, of class Link.
   */
  @Test
  public void testGetValue() {
    System.out.println("getValue");
    int expResult = 1000;
    int result = instance.getValue().getWeight();
    assertEquals(expResult, result);
  }

  /**
   * Test of setValue method, of class Link.
   */
  @Test
  public void testSetValue() {
    System.out.println("setValue");
    Ore ore = new Ore("lead","micrograms");
    OrePile object = new OrePile(ore,2000,60);
    instance.setValue(object);
    assertEquals(object.getWeight(), instance.getValue().getWeight());
  }

}