package stmining;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sajuuk
 */
public class ShipmentOrderTest {

    ShipmentOrder order;

    public ShipmentOrderTest() {
    }

    @Before
    public void setUp() {
        Ore ore = new Ore("iron","grams");
        order = new ShipmentOrder(ore,10,"John Doe","Guam",100);
        order.setShippedOreWt(300);
        ore = null;
    }

    @After
    public void tearDown() {
        order = null;
    }

    /**
     * Test of getOrderID method, of class ShipmentOrder.
     */
    @Test
    public void testGetOrderID() {
        System.out.println("getOrderID");
        int expResult = 1;
        int result = order.getOrderID();
        assertEquals(expResult, result);
    }

    /**
     * Test of getOre method, of class ShipmentOrder.
     */
    @Test
    public void testGetOre() {
        System.out.println("getOre");
        String expResult = "iron";
        String result = order.getOre().getOreType();
        assertEquals(expResult, result);
        expResult = "iron";
        result = order.getOre().getOreType();
        assertEquals(expResult, result);

    }

    /**
     * Test of getCustomerName method, of class ShipmentOrder.
     */
    @Test
    public void testGetCustomerName() {
        System.out.println("getCustomerName");
        String expResult = "John Doe";
        String result = order.getCustomerName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCustomerName method, of class ShipmentOrder.
     */
    @Test
    public void testSetCustomerName() {
        System.out.println("setCustomerName");
        String inputCustName = "Jane Doe";
        order.setCustomerName(inputCustName);
        assertEquals(inputCustName,order.getCustomerName());
    }

    /**
     * Test of getShippingDestn method, of class ShipmentOrder.
     */
    @Test
    public void testGetShippingDestn() {
        System.out.println("getShippingDestn");
        String expResult = "Guam";
        String result = order.getShippingDestn();
        assertEquals(expResult, result);
    }

    /**
     * Test of setShippingDestn method, of class ShipmentOrder.
     */
    @Test
    public void testSetShippingDestn() {
        System.out.println("setShippingDestn");
        String inputShipDestn = "Chad";
        order.setShippingDestn(inputShipDestn);
        assertEquals(inputShipDestn, order.getShippingDestn());
    }

    /**
     * Test of getOrderedMetalWht method, of class ShipmentOrder.
     */
    @Test
    public void testGetOrderedMetalWht() {
        System.out.println("getOrderedMetalWht");
        int expResult = 100;
        int result = order.getOrderedMetalWht();
        assertEquals(expResult, result);
    }

    /**
     * Test of setOrderedMetalWht method, of class ShipmentOrder.
     */
    @Test
    public void testSetOrderedMetalWht() {
        System.out.println("setOrderedMetalWht");
        int inputOrderedMtl = 400;
        order.setOrderedMetalWht(inputOrderedMtl);
        assertEquals(inputOrderedMtl, order.getOrderedMetalWht());
    }

    /**
     * Test of getPricePerUnit method, of class ShipmentOrder.
     */
    @Test
    public void testGetPricePerUnit() {
        System.out.println("getPricePerUnit");
        int expResult = 10;
        int result = order.getPricePerUnit();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPricePerUnit method, of class ShipmentOrder.
     */
    @Test
    public void testSetPricePerUnit() {
        System.out.println("setPricePerUnit");
        int inputPPU = 1;
        order.setPricePerUnit(inputPPU);
        assertEquals(inputPPU, order.getPricePerUnit());
    }

    /**
     * Test of getShippedOreWt method, of class ShipmentOrder.
     */
    @Test
    public void testGetShippedOreWt() {
        System.out.println("getShippedOreWt");
        int expResult = 300;
        int result = order.getShippedOreWt();
        assertEquals(expResult, result);
    }

    /**
     * Test of setShippedOreWt method, of class ShipmentOrder.
     */
    @Test
    public void testSetShippedOreWt() {
        System.out.println("setShippedOreWt");
        int inputShippedOreWt = 20;
        order.setShippedOreWt(inputShippedOreWt);
        assertEquals(inputShippedOreWt, order.getShippedOreWt());
    }

    /**
     * Test of getIsPending method, of class ShipmentOrder.
     */
    @Test
    public void testGetIsPending() {
        System.out.println("getIsPending");
        boolean expResult = true;
        boolean result = order.getIsPending();
        assertEquals(expResult, result);
    }

    /**
     * Test of orderCompleted method, of class ShipmentOrder
     */
    @Test
    public void testOrderCompleted() {
        System.out.println("orderCompleted");
        boolean expResult = false;
        order.orderCompleted();
        boolean result = order.getIsPending();
        assertEquals(expResult, result);
    }

    /**
     * Test of averageGrade method, of class ShipmentOrder.
     */
    @Test
    public void testAverageGrade() {
        System.out.println("averageGrade");
        int expResult = 33;
        order.orderCompleted();
        int result = order.averageGrade();
        assertEquals(expResult, result);
    }

    /**
     * Test of shipmentValue method, of class ShipmentOrder.
     */
    @Test
    public void testShipmentValue() {
        System.out.println("shipmentValue");
        int expResult = 1000;
        int result = order.shipmentValue();
        assertEquals(expResult, result);
    }

}