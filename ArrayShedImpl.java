package stmining;

/**
 * an implementation for the common variables and methods of the shed interface
 * @author sajuuk
 */

public class ArrayShedImpl {

  /** identifier for this shed */
  private String name;

  /** name of ore held in shed */
  private String oreType;

  /**
   * gets name
   * @return name of shed
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
   * gets oreType
   * @return oreType name of ore stored shed
   */
  public String getOreType() {
    return oreType;
  }

}
