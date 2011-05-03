package stmining;

/**
 * A circular queue-based implementation of the Shed interface.
 * This class extends the common shed features of ShedImpl.
 * Queue logic and variables adapted from
 *  LaFore's Data Structures and Algorithms in Java, 2nd Ed,
 *  Pages 138-140
 * @author    sajuuk
 */

public class ArrayShedIron extends ArrayShedImpl{

    /** array of items */
  private OrePile[] orePileQueue;

  /** the maximum size of the queue */
  private int maxSize;

  /** array index of front-most item */
  private int front;

  /** array index of rear-most item */
  private int rear;

  /** number of items in queue */
  private int nItems;

  /**
   * constructor that populates all fields
   * @param maxOrePiles the maximum number of OrePiles the shed can take
   */
  public ArrayShedIron(int maxOrePiles) {
    maxSize = maxOrePiles;
    orePileQueue = new OrePile[maxSize];
    front = 0;
    rear = -1;
    nItems = 0;
  }

  /**
   * adds an OrePile to the rear of the queue
   * @param orePile the OrePile to be added to the queue
   */
  public void addPile(OrePile orePile) {
    //checks that queue (array) isn't full and has room for another OrePile
    if (nItems == maxSize) {
      throw new IllegalStateException("cannot add item; queue is full");
    }
    else {
      //if the rear variable already points to last element of array
      if (rear == maxSize - 1) {
        //set it to -1 so that when it is incremented by 1 below
        //it will loop around to index 0; the start of the array
        rear = -1;
      }
      //last OrePile is OrePile at array index rear
      //so we insert the new orePile AFTER the last OrePile (rear + 1)
      int index = rear + 1;
      orePileQueue[index] = orePile;
      //and increment the rear array index
      rear += 1;
      //and increment the number of items in the queue
      nItems += 1;

    }
  }

  /**
   * removes front-most object from queue
   * @return newly removed OrePile
   */
  public OrePile removePile() {
    //checks that we are not removing from an empty queue
    if (nItems == 0) {
      throw new IllegalStateException("cannot remove item; queue is empty");
    }
    else {
      //initialise removedItem by creating new OrePile
      //with OrePile constructor that copies
      //the OrePile at the front of the queue
      OrePile removedItem = new OrePile(orePileQueue[front]);
      //increment the front of queue to next OrePile
      front += 1;
      //decrement the number of items in the queue
      nItems -= 1;
      return removedItem;
   }
  }

  /**
   * iterates through queue finding cumulative OrePile total weights
   * @return total weight of all OrePiles in queue
   */
  public int totalOreWeight() {
    //counter for total weight of OrePiles
    int totalWeight = 0;
    //counter for array index
    int index = front;

    do {
      //add indexed OrePile's weight to totalWeight
      totalWeight += orePileQueue[index].getWeight();
      
      //loop back to start of array if end reached
      if (index == maxSize -1) {
        index = 0;
      }
      else {
      //otherwise just increment up the array
        index += 1;
      }
    //until index hits rear (rear value added before loops exits)
    } while (index != rear);
    return totalWeight;
  }

  /**
   * iterates through array and finds cumulative metal weight of all OrePiles
   * @return total weight of metal in the queue
   */
  public int totalMetalWeight() {
    //counter for total metal weight in all of the OrePiles
    int totalMetal = 0;
    //counter for array index
    int index = front;

    do {
      //add indexed OrePile's to totalWeight
      int weight = orePileQueue[index].getWeight();
      int grade = orePileQueue[index].getGrade();
      int metalWeight = weight * grade;
      totalMetal += metalWeight;

      //loop back to start of array if end reached
      if (index == maxSize -1) {
        index = 0;
      }
      else {
      //otherwise just increment up the array
        index += 1;
      }
    //until index hits rear (rear value added before loops exits)
    } while (index != rear);
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