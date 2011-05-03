package stmining;

/**
 * an interface describing the necessary functions of an ore shed
 * @author sajuuk
 */
public interface IShed  extends Iterable<OrePile>{

  /**
   * gets name of shed
   * @return name of the shed
   */
  public String getName();

  /**
   * sets name of shed
   * @param inputName desired name of shed
   */
  public void setName(String inputName);

  /**
   * gets name of ore in shed
   * @return name of ore stored
   */
  public String getOreType();

  /**
   * adds OrePile to shed
   * @param orePile the OrePile object to be added
   */
  public void addPile(OrePile orePile);

  /**
   * calculates total weight of all ore stored
   * @return total weight of all ore in shed
   */
  public int totalOreWeight();

  /**
   * calculates the weight of metal in all stored ore
   * @return weight of metal in shed
   */
  public int totalMetalWeight();

  /**
   * remove OrePiles from shed until specified order is fulfilled
   * @param ShpOrdr ShipmentOrder to be processed by shed
   */
  public void satisfyOrder(ShipmentOrder ShpOrdr);

}
