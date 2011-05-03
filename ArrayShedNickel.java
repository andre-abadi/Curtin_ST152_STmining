package stmining;

/**
 * A stack based implementation of the Shed interface.
 * This class extends the common shed features of ShedImpl.
 * Stack logic and variables adapted from
 *  LaFore's Data Structures and Algorithms in Java, 2nd Ed,
 *  Pages 120-122
 * @author    sajuuk
 */

public class ArrayShedNickel extends ArrayShedImpl{

  /** maximum size of the shed */
  private int maxSize;

  /** array of orePile objects */
  private OrePile[] orePileStack;

  /** top of the stack */
  private int top;

  /**
   * constructor that populates all fields
   * @param maxOrePiles maximum number of OrePiles the shed can take
   */
  public ArrayShedNickel (int maxOrePiles) {
    maxSize = maxOrePiles;
    orePileStack = new OrePile[maxSize];
    top = -1;
  }

  /**
   * adds an OrePile to the top of the stack
   * @param orePile OrePile object to be added to the stack
   */
  public void addPile(OrePile orePile) {
    if (top + 1 == maxSize) {
      throw new IllegalStateException("cannot add item; stack is full");
    }
    else {
      //increment the top of the stack
      top += 1;
      orePileStack[top] = new OrePile(orePile);
    }
  }

  /**
   * iterates down array to find cumulative ore weight of all OrePiles
   * @return total weight of ore in the stack
   */
  public int totalOreWeight() {
    int index = top;
    int totalWeight = 0;
    while (index != 0) {
      totalWeight += orePileStack[index].getWeight();
      index -= 1;
    }
    return totalWeight;
  }

  /**
   * iterates through array and finds cumulative metal weight of all OrePiles
   * @return total weight of metal in the stack
   */
  public int totalMetalWeight() {
    int index = top;
    int totalMetal = 0;
    while (index != 0) {
      totalMetal += orePileStack[index].metalWeight();
      index -= 1;
    }
    return totalMetal;
  }

  /**
   * calls for the ShipmentOrder object to begin processing the order
   * @param ShpOrdr the ShipmentOrder object
   */
  public void satisfyOrder(ShipmentOrder ShpOrdr) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

}
