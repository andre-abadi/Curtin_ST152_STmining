package stmining;

/**
 * a model of a pile of ore
 * @author    sajuuk
 */

public class OrePile {

  /** ore of which this orePile is composed */
  private Ore ore;

  /** weight of OrePile */
  private int weight;

  /** percentage metal by weight in this orePile */
  private int grade;

  /**
   * constructor that populates all fields
   * @param or is an ore object of which this pile is composed
   * @param wt is the weight of this pile of ore
   * @param grd is the grade of this pile of ore
   */
  public OrePile (Ore or, int wt, int grd) {
    //uses copy-constructor of Ore class
    ore = new Ore(or);
    checkWeight(wt);
    weight = wt;
    checkGrade(grd);
    grade = grd;
  }

  /**
   * copy-constructor
   * @param orepile another OrePile object
   */
  public OrePile (OrePile orepile) {
    //uses copy-constructor of Ore class
    ore = new Ore(orepile.getOre());
    checkWeight(orepile.getWeight());
    weight = orepile.getWeight();
    checkGrade(orepile.getGrade());
    grade = orepile.getGrade();
  }
  
  /**
   * gets ore
   * @return the Ore object-variable of this OrePile
   */
  public Ore getOre () {
    return ore;
  }

  /**
   * gets weight
   * @return weight of OrePile
   */
  public int getWeight () {
    return weight;
  }

  /**
   * sets weight
   * @param inputWeight the desired weight of the OrePile
   */
  public void setWeight (int inputWeight) {
    checkWeight(inputWeight);
    weight = inputWeight;
  }

  /**
   * gets grade
   * @return percentage metal by weight of the OrePile
   */
  public int getGrade () {
    return grade;
  }

  /**
   * gets grade
   * @param inputGrade the desired grade of the OrePile
   * @see #getGrade() 
   */
  public void setGrade (int inputGrade) {
    checkGrade(inputGrade);
    grade = inputGrade;
  }

  /**
   * calculates the weight of metal in this OrePile
   * @return the weight of metal in this OrePile
   */
  public int metalWeight () {
    int metalQuantity = grade * weight;
    metalQuantity /= 100; //because percentage was not in decimal
    return metalQuantity;
  }

  /**
   * throws an exception if weight is not positive
   * @param testWeight the weight to be checked
   */
  private void checkWeight(int testWeight) {
    if (testWeight <= 0) {
      throw new IllegalArgumentException("Weight must be >0");
    }
  }

  /**
   * throws an exception if grade is not between 0 and 100
   * @param testGrade the grade to be checked
   */
  private void checkGrade (int testGrade) {
    if (testGrade<=0 || testGrade >100) {
      throw new IllegalArgumentException("0<Grade<100 not satisfied");
    }
  }
}