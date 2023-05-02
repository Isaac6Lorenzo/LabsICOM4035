package EXAMEN01;

import static org.junit.Assert.*;
import org.junit.Test;

public class MotorVehicleTest {
	
	@Test
	public void testCopyContructor() {
		MotorVehicle mv2 = new MotorVehicle("Mazda", "CX/9", "ABC123", 2011, 150000, 5, 5000);
		MotorVehicle mv1 = new MotorVehicle(mv2);
		assertEquals("Incorrect MotorVehicle getter/constructor", "Mazda", mv1.getMake());
		assertEquals("Incorrect MotorVehicle getter/constructor", "CX/9", mv1.getModel());
		assertEquals("Incorrect MotorVehicle getter/constructor", "ABC123", mv1.getLicensePlate());
		assertEquals("Incorrect MotorVehicle getter/constructor", 2011, mv1.getYear());
		assertEquals("Incorrect MotorVehicle getter/constructor", 150000, mv1.getMileage(), 1e-10);
		assertNotEquals("Incorrect MotorVehicle getter/constructor", mv1, mv2);
	}
	
	@Test
	public void testAddMileage() {
		MotorVehicle mv1 = new MotorVehicle("VW", "Golf", "XYZ984", 2017, 5000, 5, 5000);
		mv1.addMileage(5000);
		assertEquals("Incorrect addMileage", 10000, mv1.getMileage(), 1e-10);
		mv1.addMileage(5000);
		assertEquals("Incorrect addMileage", 15000, mv1.getMileage(), 1e-10);
	}

	@Test
	public void testMilesPerYear() {
		MotorVehicle mv1 = new MotorVehicle("Mazda", "CX/9", "ABC123", 2011, 150000, 5, 5000);
		assertEquals("Incorrect milesPerYear", 25000, mv1.milesPerYear(2017), 1e-10);
		MotorVehicle mv2 = new MotorVehicle("Toyota", "Rav4", "ABC124", 2015, 31000, 5, 5000);
		assertEquals("Incorrect milesPerYear", 15500, mv2.milesPerYear(2017), 1e-10);
	}
	
	@Test
	public void testUnderWarranty() {
		MotorVehicle mv1 = new MotorVehicle("Mazda", "CX/9", "ABC123", 2011, 150000, 5, 50000);
		assertFalse("Incorrect underWarranty",mv1.underWarranty(2017));
		MotorVehicle mv2 = new MotorVehicle("Toyota", "Rav4", "ABC124", 2015, 25000, 2, 30000);
		assertFalse("Incorrect underWarranty",mv2.underWarranty(2017));
		MotorVehicle mv3 = new MotorVehicle("Toyota", "Rav4", "ABC125", 2015, 31000, 3, 30000);
		assertFalse("Incorrect underWarranty",mv3.underWarranty(2017));
		MotorVehicle mv4 = new MotorVehicle("Toyota", "Rav4", "ABC126", 2015, 31000, 4, 40000);
		assertTrue("Incorrect underWarranty",mv4.underWarranty(2017));
	}
	
	@Test
	public void testNeedsInspection() {
		MotorVehicle mv1 = new MotorVehicle("Mazda", "CX/9", "ABC123", 2011, 150000, 5, 50000);
		assertTrue("Car needs to be inspected",mv1.needsInspection(2017));
		
		MotorVehicle mv2 = new MotorVehicle("Toyota", "Rav4", "ABC124", 2015, 25000, 2, 30000);
		assertFalse("Car does not need inspection",mv2.needsInspection(2017));
		
	}
	
	@Test
	public void testGetMotorVehicleValue() {
		MotorVehicle mv1 = new MotorVehicle("Mazda", "CX/9", "ABC123", 2011, 1500, 5, 50000);
		MotorVehicle mv2 = new MotorVehicle("Toyota", "Rav4", "ABC124", 2015, 20000, 2, 30000);
		MotorVehicle mv3 = new MotorVehicle("Toyota", "Rav4", "ABC125", 2015, 31000, 3, 30000);
		
		assertEquals(49818, mv1.getMotorVehicleValue(2011), 1);
		assertEquals(48500, mv1.getMotorVehicleValue(2016), 1);
		assertEquals(47984, mv1.getMotorVehicleValue(2018), 1);
		
		assertEquals(10091, mv2.getMotorVehicleValue(2015), 1);
		assertEquals(10000, mv2.getMotorVehicleValue(2017), 1);
		assertEquals(9864, mv2.getMotorVehicleValue(2020), 1);

		assertEquals(0, mv3.getMotorVehicleValue(2015), 1);
		assertEquals(0, mv3.getMotorVehicleValue(2017), 1);
		assertEquals(0, mv3.getMotorVehicleValue(2020), 1);

	}
}