package stmining;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sajuuk
 */
public class OrePileTest {
    OrePile orepile;

    public OrePileTest() {
    }

    @Before
    public void setUp() {
        Ore ore = new Ore("iron","grams");
        orepile = new OrePile(ore,100,50);
        ore = null;
    }

    @After
    public void tearDown() {
        orepile = null;
    }

    /**
     * Test of getOre method, of class OrePile.
     */
    @Test
    public void testGetOre() {
        System.out.println("getOre");
        String expResult = "iron";
        String result = orepile.getOre().getOreType();
        assertEquals(expResult, result);
        expResult = "grams";
        result = orepile.getOre().getUnits();
        assertEquals(expResult, result);
    }

    /**
     * Test of getWeight method, of class OrePile.
     */
    @Test
    public void testGetWeight() {
        System.out.println("getWeight");
        int expResult = 100;
        int result = orepile.getWeight();
        assertEquals(expResult, result);
    }

    /**
     * Test of setWeight method, of class OrePile.
     */
    @Test
    public void testSetWeight() {
        System.out.println("setWeight");
        int inputWeight = 200;
        orepile.setWeight(inputWeight);
        assertEquals(inputWeight,orepile.getWeight());
    }

    /**
     * Test of getGrade method, of class OrePile.
     */
    @Test
    public void testGetGrade() {
        System.out.println("getGrade");;
        int expResult = 50;
        int result = orepile.getGrade();
        assertEquals(expResult, result);
    }

    /**
     * Test of setGrade method, of class OrePile.
     */
    @Test
    public void testSetGrade() {
        System.out.println("setGrade");
        int inputGrade = 75;
        orepile.setGrade(inputGrade);
        assertEquals(inputGrade, orepile.getGrade());
    }

    /**
     * Test of metalWeight method, of class OrePile.
     */
    @Test
    public void testMetalWeight() {
        System.out.println("metalWeight");
        int expResult = 50;
        int result = orepile.metalWeight();
        assertEquals(expResult, result);
    }

}