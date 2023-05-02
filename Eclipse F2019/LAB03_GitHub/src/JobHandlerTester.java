import static org.junit.Assert.*;

import org.junit.Test;

public class JobHandlerTester {
	
//	Exercise 5A Tester
	@Test
	public void bonusTest() {
		assertEquals("The method salaryBonus() for employee e1 should return 307", 307, JobHandler.salaryBonus(0, 7000));
		assertEquals("The method salaryBonus() for employee e2 should return 250", 250, JobHandler.salaryBonus(1, 10000));
		assertEquals("The method salaryBonus() for employee e3 should return 650", 650, JobHandler.salaryBonus(2, 50000));
		assertEquals("The method salaryBonus() for employee e4 should return 1000", 5100, JobHandler.salaryBonus(3, 100000));
		assertEquals("The method salaryBonus() for employee e5 should return 550", 550, JobHandler.salaryBonus(1, 70000));		
		assertEquals("The method salaryBonus() for employee e6 should return 700", 550, JobHandler.salaryBonus(2, 40000));
		
	}

//	Exercise 5B Tester
	@Test
	public void promotionQualifyTest() {
		assertFalse("The method promotionQuality() for the given combination should return false", JobHandler.promotionQualify(90, 84, 1));
		assertTrue("The method promotionQuality() for the given combination should return true", JobHandler.promotionQualify(10, 9, 0));
		assertTrue("The method promotionQuality() for the given combination should return true", JobHandler.promotionQualify(40, 35, 1));
		assertTrue("The method promotionQuality() for the given combination should return true", JobHandler.promotionQualify(20, 10, 2));
		assertTrue("The method promotionQuality() for the given combination should return true", JobHandler.promotionQualify(60, 40, 3));
		assertFalse("The method promotionQuality() for the given combination should return false", JobHandler.promotionQualify(80, 0, 0));
		assertFalse("The method promotionQuality() for the given combination should return false", JobHandler.promotionQualify(40, -10, 1));
	}
}
