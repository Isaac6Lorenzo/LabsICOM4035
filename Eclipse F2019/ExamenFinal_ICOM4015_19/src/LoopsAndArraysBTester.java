import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class LoopsAndArraysBTester {
	
	LoopsAndArraysB.Trooper t0;
	LoopsAndArraysB.Trooper t1;
	LoopsAndArraysB.Trooper t2;
	LoopsAndArraysB.Trooper t3;
	LoopsAndArraysB.Trooper t4;
	LoopsAndArraysB.Trooper t5;
	LoopsAndArraysB.Trooper t6;
	LoopsAndArraysB.Trooper t7;
	LoopsAndArraysB.Trooper t8;
	LoopsAndArraysB.Trooper t9;

	@Before
	public void loadTroopers() {
		t0 = new LoopsAndArraysB.Trooper("Anakin",LoopsAndArraysB.Trooper.Rank.CADET,80);
		t1 = new LoopsAndArraysB.Trooper("Jabba", LoopsAndArraysB.Trooper.Rank.LIEUTENANT,300);
		t2 = new LoopsAndArraysB.Trooper("Wampa ", LoopsAndArraysB.Trooper.Rank.SERGEANT,200);
		t3 = new LoopsAndArraysB.Trooper("Storm", LoopsAndArraysB.Trooper.Rank.COLONEL,700);
		t4 = new LoopsAndArraysB.Trooper("Jorus", LoopsAndArraysB.Trooper.Rank.SERGEANT,225);
		t5 = new LoopsAndArraysB.Trooper("Binks", LoopsAndArraysB.Trooper.Rank.MAJOR,400);
		t6 = new LoopsAndArraysB.Trooper("Windu", LoopsAndArraysB.Trooper.Rank.TROOPER,150);
		t7 = new LoopsAndArraysB.Trooper("JarJar", LoopsAndArraysB.Trooper.Rank.LIEUTENANT,325);
		t8 = new LoopsAndArraysB.Trooper("Hutt", LoopsAndArraysB.Trooper.Rank.CADET,90);
		t9 = new LoopsAndArraysB.Trooper("Ackbar", LoopsAndArraysB.Trooper.Rank.CAPTAIN,350);
	}
	
	  @Test
	    public void testLowerRankExists() {
	    	LoopsAndArraysB.Trooper[] emptySquad = {};
	    	LoopsAndArraysB.Trooper[] oneTrooperSquad = { t4 } ; // Sgt
	    	LoopsAndArraysB.Trooper[] firstSquad = { t0, t2, t4, t6, t8};  // Cd,Sgt,Sgt,Trp,Cd 
	    	LoopsAndArraysB.Trooper[] secondSquad = { t1, t3, t5, t7, t9}; // Lt,Col,Mjr,Lt,Cd

	    	LoopsAndArraysB.Trooper t20 = new LoopsAndArraysB.Trooper("Jacen", LoopsAndArraysB.Trooper.Rank.CAPTAIN,375);
	    	LoopsAndArraysB.Trooper t30 = new LoopsAndArraysB.Trooper("Exar", LoopsAndArraysB.Trooper.Rank.TROOPER,425);
	    	LoopsAndArraysB.Trooper t40 = new LoopsAndArraysB.Trooper("Maverick", LoopsAndArraysB.Trooper.Rank.COLONEL,425);
	    	
	    	assertFalse("No Trooper exists in empty list.", t20.lowerRankExists(emptySquad));
	    	assertFalse("No Trooper exists in empty list.", t30.lowerRankExists(emptySquad));
	    	
	    	assertTrue("There is a lower ranking Trooper.", t20.lowerRankExists(oneTrooperSquad));
	    	assertFalse("There is not a lower ranking Trooper.", t30.lowerRankExists(oneTrooperSquad));
	    	assertTrue("There is a lower ranking Trooper.", t40.lowerRankExists(oneTrooperSquad));
	    	
	    	assertTrue("There is a lower ranking Trooper.", t20.lowerRankExists(firstSquad));
	    	assertTrue("There is a lower ranking Trooper.", t30.lowerRankExists(firstSquad));
	    	assertTrue("There is not a lower ranking Trooper.", t40.lowerRankExists(firstSquad));
    	
	    	assertTrue("There is a lower ranking Trooper.", t20.lowerRankExists(secondSquad));
	    	assertFalse("There is not a lower ranking Trooper.", t30.lowerRankExists(secondSquad));
	    	assertTrue("There is not a lower ranking Trooper.", t40.lowerRankExists(secondSquad));    	
	    }
	    

	  @Test
	  public void testFindMinSeniority() {
		  LoopsAndArraysB.Trooper[] emptySquad = {};
		  LoopsAndArraysB.Trooper[] oneTrooperSquad = { t4 } ; // Sgt
		  LoopsAndArraysB.Trooper[] firstSquad = { t0, t2, t4, t6, t8};  // Cd,Sgt,Sgt,Trp,Cd 
		  LoopsAndArraysB.Trooper[] secondSquad = { t1, t3, t5, t9, t7}; // Lt,Col,Mjr,Cd,Lt

		  assertNotEquals("Returned the last Trooper", t8, LoopsAndArraysB.Trooper.findMinSeniority(firstSquad));	
		  assertNotEquals("Returned the first Trooper", t9, LoopsAndArraysB.Trooper.findMinSeniority(secondSquad));

		  assertEquals("It should return null", null, LoopsAndArraysB.Trooper.findMinSeniority(emptySquad));
		  assertEquals("It should return the only Trooper", t4, LoopsAndArraysB.Trooper.findMinSeniority(oneTrooperSquad));
		  assertEquals("Incorrect Trooper", t0, LoopsAndArraysB.Trooper.findMinSeniority(firstSquad));
		  assertNotEquals("Should return first Trooper with lowest rank", t8, LoopsAndArraysB.Trooper.findMinSeniority(firstSquad));

		  assertEquals("Incorrect Trooper", t1, LoopsAndArraysB.Trooper.findMinSeniority(secondSquad));
		  assertNotEquals("Returned highest ranking Trooper", t3, LoopsAndArraysB.Trooper.findMinSeniority(secondSquad));
	  }

   
	  @Test
	  public void testSquadsAvgFlightHrs() {
		  
		 double delta = 0.00001;
		 
		  LoopsAndArraysB.Trooper[] emptySquad = {};
		  LoopsAndArraysB.Trooper[] oneTrooperSquad = { t4 } ; 
		  LoopsAndArraysB.Trooper[] firstSquad = { t0, t2, t4, t6, t8};  
		  LoopsAndArraysB.Trooper[] secondSquad = { t1, t3, t5, t9, t7}; 
		  LoopsAndArraysB.Trooper[] thirdSquad = { t0, t6, t8};

		  assertEquals(0.0, LoopsAndArraysB.Trooper.squadsAvgFlightHrs(emptySquad), delta);
		  assertNotEquals("Should return zero", 1.0, LoopsAndArraysB.Trooper.squadsAvgFlightHrs(emptySquad));
		  
		  assertEquals(225.0, LoopsAndArraysB.Trooper.squadsAvgFlightHrs(oneTrooperSquad), delta);
		  assertNotEquals("Should not return 1.0", 1.0, LoopsAndArraysB.Trooper.squadsAvgFlightHrs(oneTrooperSquad));
		  
		  assertEquals(149.0, LoopsAndArraysB.Trooper.squadsAvgFlightHrs(firstSquad), delta);
		  assertNotEquals("Returned total hours", 745.0, LoopsAndArraysB.Trooper.squadsAvgFlightHrs(firstSquad));
		  
		  assertEquals(415.0, LoopsAndArraysB.Trooper.squadsAvgFlightHrs(secondSquad), delta);
		  assertEquals(106.66666, LoopsAndArraysB.Trooper.squadsAvgFlightHrs(thirdSquad), delta);
	  }
    
    @Test
    public void testIntersectionOfSquads() {
    	LoopsAndArraysB.Trooper[] emptySquad = {};
    	LoopsAndArraysB.Trooper[] oneTrooperSquad = { t4 } ; 
    	LoopsAndArraysB.Trooper[] firstSquad = { t0, t2, t4, t6, t8};  
    	LoopsAndArraysB.Trooper[] secondSquad = { t1, t3, t5, t9, t7}; 
    	LoopsAndArraysB.Trooper[] thirdSquad = { t3, t5, t8}; 

    	LoopsAndArraysB.Trooper[] assert1Result = LoopsAndArraysB.Trooper.intersectionOfSquads(emptySquad, emptySquad);
    	assertFalse("It should .", assert1Result==emptySquad);
    	assertEquals("It should have returned an empty squad array", 0 ,assert1Result.length);
    	
    	LoopsAndArraysB.Trooper[] assert2Result = LoopsAndArraysB.Trooper.intersectionOfSquads(firstSquad, emptySquad);
    	LoopsAndArraysB.Trooper[] expectedResult2 = new LoopsAndArraysB.Trooper[firstSquad.length];
    	assertFalse("It should return a new array instance.", assert2Result==firstSquad);
    	assertFalse("It should return a new array instance.", assert2Result==emptySquad);
//    	assertEquals("Array size is incorrect, may contain null values", 5 ,assert2Result.length);
//     	assertTrue("Items in array are out of order.", Arrays.equals(expectedResult2 ,assert2Result));	
    
    	LoopsAndArraysB.Trooper[] assert3Result = LoopsAndArraysB.Trooper.intersectionOfSquads(emptySquad, firstSquad);
    	LoopsAndArraysB.Trooper[] expectedResult3 = new LoopsAndArraysB.Trooper[firstSquad.length];
    	assertFalse("It should return a new array instance.", assert3Result==emptySquad);
    	assertFalse("It should return a new array instance.", assert3Result==firstSquad);
//    	assertEquals("Array size is incorrect, may contain null values", 5 ,assert3Result.length); 	
//    	assertTrue("Items in array are out of order.", Arrays.equals(expectedResult3 ,assert3Result));	
    	
    	LoopsAndArraysB.Trooper[] assert4Result = LoopsAndArraysB.Trooper.intersectionOfSquads(oneTrooperSquad, firstSquad);
    	LoopsAndArraysB.Trooper[] expectedResult4 = { t4, null, null, null, null, null};
    	assertFalse("It should return a new array instance.", assert4Result==oneTrooperSquad);
    	assertFalse("It should return a new array instance.", assert4Result==firstSquad);
//    	assertEquals("Array size is incorrect, may contain null values", 6 ,assert4Result.length); 	
//    	assertTrue("Items in array are out of order.", Arrays.equals(expectedResult4 ,assert4Result));
    	
    	LoopsAndArraysB.Trooper[] assert5Result = LoopsAndArraysB.Trooper.intersectionOfSquads(firstSquad, oneTrooperSquad);
    	LoopsAndArraysB.Trooper[] expectedResult5 = { t4, null, null, null, null, null};
    	assertFalse("It should return a new array instance.", assert5Result==firstSquad);
    	assertFalse("It should return a new array instance.", assert5Result==oneTrooperSquad);
//    	assertEquals("Array size is incorrect, may contain null values", 6 ,assert5Result.length); 	
//    	assertTrue("Items in array are out of order.", Arrays.equals(expectedResult5 ,assert5Result));	

    	LoopsAndArraysB.Trooper[] assert6Result = LoopsAndArraysB.Trooper.intersectionOfSquads(firstSquad, firstSquad);
    	LoopsAndArraysB.Trooper[] expectedResult6 = { t0, t2, t4, t6, t8, null, null, null, null, null};
    	assertFalse("It should return a new array instance.", assert6Result==firstSquad);
    	assertFalse("It should return a new array instance.", assert6Result==firstSquad);
//    	assertEquals("Array size is incorrect, may contain null values", 10 ,assert6Result.length); 	
//    	assertTrue("Items in array are out of order.", Arrays.equals(expectedResult6 ,assert6Result));	
    	
    	LoopsAndArraysB.Trooper[] assert7Result = LoopsAndArraysB.Trooper.intersectionOfSquads(secondSquad, thirdSquad);
    	LoopsAndArraysB.Trooper[] expectedResult7 = { t3, t5, null, null, null, null, null, null};
    	assertFalse("It should return a new array instance.", assert7Result==secondSquad);
    	assertFalse("It should return a new array instance.", assert7Result==thirdSquad);
//    	assertEquals("Array size is incorrect, may contain null values", 8 ,assert7Result.length); 	
//    	assertTrue("Items in array are out of order.", Arrays.equals(expectedResult7,assert7Result));		
    	
    }
}