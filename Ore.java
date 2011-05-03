package stmining;

/**
 * describes an ore that can be stored
 * @author sajuuk
 */
public class Ore {

  /** name of this ore */
  private String oreName;

  /** units of measure for the ore */
  private String units;

  /**
   * constructor that populates all fields
   * @param type name that the ore will have
   * @param measure unit of measure used
   * @param cost price of ore
   */
  public Ore (String type, String measure) {
    oreName = type;
    units = measure;
  }

  /**
   * copy-constructor
   * @param ore another Ore object
   */
  public Ore (Ore ore) {
    oreName = ore.getOreType();
    units = ore.getUnits();
  }

  /**
   * gets oreName
   * @return name of ore
   */
  public String getOreType () {
    return oreName;
  }

  /**
   * gets units
   * @return units of measure used with ore
   */
  public String getUnits () {
    return units;
  }
  
  /** 
   * sets units
   * @param inputUnits the desired units of measure
   */
  public void setUnits (String inputUnits) {
      units = inputUnits;
  }
}
