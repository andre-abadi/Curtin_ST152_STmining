package stmining;

/**
 * models an order of ore from a customer
 * @author    sajuuk
 */

public class ShipmentOrder {

  /** unique identifier for this order */
  private int orderID;

  /** reference for creation of next orderID */
  private static int nextOrderID = 1;

  /** Ore requested in this order */
  private Ore ore;

  /** amount customer will pay per unit OF METAL*/
  private int pricePerUnit;

  /** name of the customer */
  private String customerName;

  /** destination of the order */
  private String shippingDestn;

  /** quantity of metal to be delivered */
  private int orderedMetalWt;

  /** quantity of Ore shipped so far */
  private int shippedOreWt;

  /** whether or not the order is complete */
  private boolean isPending;

  /**
   * constructor that populates all fields
   * @param orr Ore to be ordered
   * @param ppu price customer is to pay per unit of ore
   * @param name of customer
   * @param destination destination of order
   * @param metalQuantity weight of metal needed
   */
  public ShipmentOrder ( Ore orr,
                         int ppu,
                         String name,
                         String destination,
                         int metalQuantity) {
    orderID = nextOrderID;
    nextOrderID++; //increments the orderID for next order
    //copy-constructor of Ore class
    ore = new Ore(orr);
    checkPositive(ppu);
    pricePerUnit = ppu;
    customerName = name;
    shippingDestn = destination;
    checkPositive(metalQuantity);
    orderedMetalWt = metalQuantity;
    shippedOreWt = 0;
    isPending = true;
  }

  /**
   * gets orderID
   * @return unique identification number for this order
   */
  int getOrderID () {
    return orderID;
  }

  /**
   * gets Ore
   * @return Ore (object) for which this order has been placed
   */
  Ore getOre () {
    return ore;
  }

  /**
   * gets customerName
   * @return name of the customer
   */
  String getCustomerName () {
    return customerName;
  }

  /**
   * sets customerName
   * @param inputCustName desired name of customer
   */
  void setCustomerName (String inputCustName) {
    customerName = inputCustName;
  }

  /**
   * gets shippingDestn
   * @return destination of this order
   */
  String getShippingDestn () {
    return shippingDestn;
  }

  /**
   * sets shippingDestn
   * @param shippingDest the desired shipping destination
   */
  void setShippingDestn (String inputShipDestn) {
    shippingDestn = inputShipDestn;
  }

  /**
   * gets orderedMetalWht
   * @return weight of metal that has been ordered
   */
  int getOrderedMetalWht () {
    return orderedMetalWt;
  }

  /**
   * sets orderedMetalWht
   * @param inputOrderedMtl desired weight of metal to order
   */
  void setOrderedMetalWht (int inputOrderedMtl) {
    checkPositive(inputOrderedMtl);
    orderedMetalWt = inputOrderedMtl;
  }

  /**
   * gets pricePerUnit
   * @return the price per unit of metal for this order
   */
  int getPricePerUnit () {
    return pricePerUnit;
  }

  /**
   * sets pricePerUnit
   * @param inputPPU the desired ore price per unit shipped
   */
  void setPricePerUnit (int inputPPU) {
    checkPositive(inputPPU);
    pricePerUnit = inputPPU;
  }

  /**
   * gets shippedOreWt
   * @return the weight of ore shipped thus far
   */
  int getShippedOreWt () {
    return shippedOreWt;
  }

  /**
   * sets shippedOreWt A.K.A. shipOre()
   * @param inputShippedOreWt the desired weight of ore shipped so far
   */
  void setShippedOreWt (int inputShippedOreWt) {
    checkPositive(inputShippedOreWt);
    shippedOreWt = inputShippedOreWt;
  }

  /**
   * gets isPending
   * @return whether or not the order is still pending (unfinished)
   */
  boolean getIsPending () {
    return isPending;
  }

  /**
   * flips isPending to false: the order is complete
   */
  void orderCompleted() {
      isPending = false;
  }

  /**
   * calculates the average grade of the order to be delivered
   * @return average grade of ore delivered
   */
  int averageGrade () {
    if (isPending == true) {
      throw new IllegalStateException("order not finalised; "
                + "cannot calculate average grade of metal");
    }
    else {
      //this is a double because we will get a decimal out of this
      //and if we don't make it a double, the int would round to 0
      //and be useless
      double mean = orderedMetalWt;
      mean /= shippedOreWt;
      mean *= 100;
      //we will then cast to an int to keep things nice
      //note all decimals will round down: 59.9 rounds to 59.
      return (int)mean;
    }
  }

  /**
   * calculates the dollar-value of this shipment
   * @return value of shipment to nearest dollar
   */
  int shipmentValue () {
    int value = orderedMetalWt * pricePerUnit;
    return value;
  }

  /**
   * checks that the parameter is positive
   * @param testValue the value to be tested
   */
  private void checkPositive(int testValue) {
    if (testValue<=0) {
      throw new IllegalArgumentException("Given value must be >0");
    }
  }
}
