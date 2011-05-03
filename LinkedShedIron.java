package stmining;

import java.util.Iterator;

/**
 * An iron shed has ore added to front and removed from rear (a queue).
 * It wraps a linked-list-based queue and holds ore only of type iron.
 * @author sajuuk
 */
public class LinkedShedIron implements IShed, Iterable<OrePile>{

  /** our queue that models the OrePiles in the shed **/
  private LinkedQueue<OrePile> queue;

  /** name of the shed **/
  private String name;

  /** because our shed is an iron shed then it must contain iron **/
  private String oreType = "iron";

  /**
   * constructor that initializes queue and sets shed name
   * @param shedName is the identifier that the shed is to be given
   */
  public LinkedShedIron (String shedName) {
    name = shedName;
    queue = new LinkedQueue<OrePile>();
  }

  /**
   * gets name
   * @return name of the shed
   */
  public String getName() {
    return name;
  }

  /**
   * sets name
   * @param inputName desired name of shed
   */
  public void setName(String inputName) {
    name = inputName;
  }

  /**
   * gets name of ore stored
   * @return ore type stored here
   */
  public String getOreType() {
    return oreType;
  }

  /**
   * adds OrePile to the front of the shed (back of queue)
   * @param orePile the OrePile to be added
   */
  public void addPile(OrePile orePile) {
    //check that our OrePile matches OreType with our shed
    if (orePile.getOre().getOreType().equals(oreType)) {
      queue.enqueue(orePile);
    }
    else {
     throw new IllegalArgumentException("OreType does not match shed OreType");
    }
  }

  /**
   * calculates the total weight of ore in this shed
   * @return total weight of ore in the shed
   */
  public int totalOreWeight() {
    //variable to keep count of total weight
    int total = 0;
    //spawn a new iterator to go through queue
    Iterator<OrePile> iterator = queue.iterator();
    //iterate the iterator
    do {
      //pull the current OrePile and then iterate by one
      OrePile current = iterator.next();
      //pull out the current OrePile's weight
      int subtotal = current.getWeight();
      //and add current OrePile's weight to the total weight
      total += subtotal;
    }
    //and we break this when iterator has no next
    while (iterator.hasNext() == true);
    //then return the total
    return total;
  }

  /*
   * calculates the total weight of metal in this shed
   * @return total weight of metal in the shed
   */
  public int totalMetalWeight() {
    //variable to keep count of total weight
    int totalMetal = 0;
    //spawn a new iterator to go through queue
    Iterator<OrePile> iterator = queue.iterator();
    //iterate the iterator
    do {
      //pull the current OrePile and then iterate by one
      OrePile current = iterator.next();
      //pull out the current OrePile's METAL weight
      int subtotalMetal = current.metalWeight();
      //and add current OrePile's weight to the total weight
      totalMetal += subtotalMetal;
    }
    //and we break this when iterator has no next
    while (iterator.hasNext() == true);
    //then return the total
    return totalMetal;
  }

  public void satisfyOrder(ShipmentOrder ShpOrdr) {
    //count the amount of ore shipped, this will be passed back to
    //shipment order to tell it how much ore was shipped
    int shippedOreSoFar = ShpOrdr.getShippedOreWt();
    int orderedMetalLeft = ShpOrdr.getOrderedMetalWht();

    //firstly check if shed has enough metal to satisfy order
    if (ShpOrdr.getOrderedMetalWht() > totalMetalWeight()) {
      throw new IllegalArgumentException("Not enough ore to satisfy order");
    }

    //then keep dequeueing until required metal amount is satisfied
    while (orderedMetalLeft > 0) {
      int currentOrePileMetal = queue.peek().getValue().metalWeight();
      if (currentOrePileMetal <= orderedMetalLeft) {
        //dequeue the OrePile at front of queue
        OrePile dequeued = queue.dequeue().getValue();
        //reduce the amount of ordered metal to go by the amount
        //of metal in the dequeued OrePile
        orderedMetalLeft -= dequeued.metalWeight();
        //increment the amount of ore shipped so far by the
        //weight of the dequeued ore pile
        shippedOreSoFar += dequeued.getWeight();
      } else
      //otherwise the current OrePile must have MORE metal than needed
      //so we'll reduce its weight by the amount left to order
      {
        System.out.println("Metal left to process: " + orderedMetalLeft);
        OrePile front = queue.peek().getValue();
        System.out.println("Front OrePile has metal: " + front.metalWeight());
        System.out.println("Front OrePile has weight: " + front.getWeight());
        int grade = front.getGrade();
        System.out.println("Grade as percentage: " + grade);
        double gradeDecimal = grade / (double)100;
        System.out.println("Grade as decimal: " + gradeDecimal);
        double inverseGradeDec = 1/ gradeDecimal;
        System.out.println("Inverse of grade as decimal: " + inverseGradeDec);
        int metalTaken = orderedMetalLeft;
        System.out.println("Metal to be taken: " + metalTaken);
        double oreTakenDouble = metalTaken * inverseGradeDec;
        System.out.println("Calculated ore to be taken: " + oreTakenDouble);
        int oreTaken = (int)oreTakenDouble;
        System.out.println("As an int: " + oreTaken);

        orderedMetalLeft -= oreTaken;
        shippedOreSoFar += oreTaken;
      }
    }
    ShpOrdr.setShippedOreWt(shippedOreSoFar);
    //and once oreredMetalLeft reaches 0 and breaks out of above loop...
    //set the order as having been completed
    ShpOrdr.orderCompleted();
  }

  /**
   * iterator method that spawns a new iterator for the queue in the shed
   * @return iterator for this class
   */
  public Iterator<OrePile> iterator() {
    return queue.iterator();
  }
}
