package stmining;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sajuuk
 */
public class OreTest {

    Ore ore;

    public OreTest() {
    }

    @Before
    public void setUp() {
        ore = new Ore("iron","grams");
    }

    @After
    public void tearDown() {
        ore = null;
    }

    /**
     * Test of getOreType method, of class Ore.
     */
    @Test
    public void testGetOreType() {
        System.out.println("getOreType");
        String expResult = "iron";
        String result = ore.getOreType();
        assertEquals(expResult, result);
    }

    /**
     * Test of getUnits method, of class Ore.
     */
    @Test
    public void testGetUnits() {
        System.out.println("getUnits");
        String expResult = "grams";
        String result = ore.getUnits();
        assertEquals(expResult, result);
    }

    /**
     * Test of setUnits method, of class Ore.
     */
    @Test
    public void testSetUnits() {
        System.out.println("setUnits");
        String inputUnits = "kilograms";
        ore.setUnits(inputUnits);
    }

}