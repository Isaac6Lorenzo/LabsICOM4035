import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class CollectionsBTester {

	public CollectionsB.Player p0;
	public CollectionsB.Player p1;
	public CollectionsB.Player p2;
	public CollectionsB.Player p3;
	public CollectionsB.Player p4;
	public CollectionsB.Player p5;
	public CollectionsB.Player p6;
	public CollectionsB.Player p7;
	public CollectionsB.Player p8;
	public CollectionsB.Player p9;

	public Set< CollectionsB.Player> empty;
	public Set< CollectionsB.Player> allPlayers;
	public Set< CollectionsB.Player> allUPRMUPRB;
	public Set< CollectionsB.Player> allUPRAUPRP;
	public Set< CollectionsB.Player> dontNeedTraining;
	public Set< CollectionsB.Player> needTraining;
	public Set< CollectionsB.Player> needTrainingUPRMUPRB;
	public Set< CollectionsB.Player> dontNeedTrainingUPRMUPRB;
	
	public Set< CollectionsB.Player> allMales;
	public Set< CollectionsB.Player> allFemales;
	
	@Before
	public void setUp() {

		p0 = new CollectionsB.Player(00, "Juan", "Perez",CollectionsB.Gender.MALE, 320, CollectionsB.Team.UPRM);
		p1 = new CollectionsB.Player(10, "Juana", "Perez",CollectionsB.Gender.FEMALE, 351, CollectionsB.Team.UPRB);
		p2 = new CollectionsB.Player(20, "Pedro", "Rivera",CollectionsB.Gender.MALE, 282, CollectionsB.Team.UPRP);
		p3 = new CollectionsB.Player(30, "Petra", "Rivera",CollectionsB.Gender.FEMALE, 393, CollectionsB.Team.UPRM);
		p4 = new CollectionsB.Player(40, "Jose", "Rosas",CollectionsB.Gender.MALE, 364, CollectionsB.Team.UPRA);
		p5 = new CollectionsB.Player(50, "Josefa", "Rosas",CollectionsB.Gender.FEMALE, 335, CollectionsB.Team.UPRB);
		p6 = new CollectionsB.Player(60, "Carmelo", "Rivera",CollectionsB.Gender.MALE, 276, CollectionsB.Team.UPRM);
		p7 = new CollectionsB.Player(70, "Carmela", "Rivera",CollectionsB.Gender.FEMALE, 397, CollectionsB.Team.UPRB);
		p8 = new CollectionsB.Player(80, "Millo", "Diaz",CollectionsB.Gender.MALE, 398, CollectionsB.Team.UPRP);
		p9 = new CollectionsB.Player(90, "Milla", "Diaz",CollectionsB.Gender.FEMALE, 399, CollectionsB.Team.UPRA);

		empty = new HashSet< CollectionsB.Player>();
		allPlayers = new HashSet< CollectionsB.Player>();
		allPlayers.add(p0); allPlayers.add(p1); allPlayers.add(p2); allPlayers.add(p3); allPlayers.add(p4);
		allPlayers.add(p5); allPlayers.add(p6); allPlayers.add(p7); allPlayers.add(p8); allPlayers.add(p9);
		
		allUPRMUPRB = new HashSet< CollectionsB.Player>();
		allUPRMUPRB.add(p0); allUPRMUPRB.add(p1); allUPRMUPRB.add(p3); allUPRMUPRB.add(p5); allUPRMUPRB.add(p6); allUPRMUPRB.add(p7);
		
		allUPRAUPRP = new HashSet< CollectionsB.Player>();
		allUPRAUPRP.add(p2); allUPRAUPRP.add(p4); allUPRAUPRP.add(p8); allUPRAUPRP.add(p9);
		
		dontNeedTraining = new HashSet< CollectionsB.Player>();
		dontNeedTraining.add(p0); dontNeedTraining.add(p1); dontNeedTraining.add(p4);dontNeedTraining.add(p8);
		
		needTraining = new HashSet< CollectionsB.Player>();
		needTraining.add(p2); needTraining.add(p6);
		
		needTrainingUPRMUPRB = new HashSet< CollectionsB.Player>();
        needTrainingUPRMUPRB.add(p6);

		dontNeedTrainingUPRMUPRB = new HashSet< CollectionsB.Player>();
		dontNeedTrainingUPRMUPRB.add(p0); dontNeedTrainingUPRMUPRB.add(p1);dontNeedTrainingUPRMUPRB.add(p3); 
		dontNeedTrainingUPRMUPRB.add(p5); dontNeedTrainingUPRMUPRB.add(p7);
		
		allMales = new HashSet< CollectionsB.Player>();
		allMales.add(p0); allMales.add(p2);allMales.add(p4); 
		allMales.add(p6); allMales.add(p8);
		
		allFemales = new HashSet< CollectionsB.Player>();
		allFemales.add(p1); allFemales.add(p3);allFemales.add(p5); 
		allFemales.add(p7); allFemales.add(p9);
		
	}

	@Test
	public void testGetUPRMUPRBTrainingCandidatesBasic() {
		assertEquals(empty, CollectionsB.getTrainingCandidates(empty));
		assertEquals(empty, CollectionsB.getTrainingCandidates(allUPRAUPRP));
		assertEquals(empty, CollectionsB.getTrainingCandidates(dontNeedTraining));
		assertNotEquals(empty, CollectionsB.getTrainingCandidates(allPlayers));
	}

	@Test
	public void testGetUPRMUPRBTrainingCandidatesAdvanced() {		
		assertEquals(needTrainingUPRMUPRB, CollectionsB.getTrainingCandidates(needTrainingUPRMUPRB));
		assertFalse(needTrainingUPRMUPRB == CollectionsB.getTrainingCandidates(needTrainingUPRMUPRB));
		assertEquals(needTrainingUPRMUPRB, CollectionsB.getTrainingCandidates(allPlayers));
		assertFalse(needTrainingUPRMUPRB == CollectionsB.getTrainingCandidates(allPlayers));		
		assertNotEquals(needTrainingUPRMUPRB, CollectionsB.getTrainingCandidates(allUPRAUPRP));
	}

	@Test
	public void testgetDifferenceBasic() {
		assertEquals(empty, CollectionsB.getDifference(empty, empty));
		assertNotEquals("the first set is empty", empty, CollectionsB.getDifference(allPlayers, allUPRMUPRB));
		assertFalse(allUPRAUPRP == CollectionsB.getDifference(allPlayers, allUPRMUPRB));
	}
		
	@Test
	public void testgetDifferenceAdvanced() {	
		assertEquals(empty, CollectionsB.getDifference(empty, empty));
		assertEquals(allUPRAUPRP, CollectionsB.getDifference(allPlayers, allUPRMUPRB));
		assertFalse(allUPRAUPRP == CollectionsB.getDifference(allPlayers, allUPRMUPRB));
		assertNotEquals(allUPRAUPRP, CollectionsB.getDifference(allUPRMUPRB, allPlayers));
		assertEquals(dontNeedTrainingUPRMUPRB, CollectionsB.getDifference(allUPRMUPRB, needTraining));
		assertEquals(needTrainingUPRMUPRB, CollectionsB.getDifference(allUPRMUPRB, dontNeedTrainingUPRMUPRB));
		assertFalse(needTrainingUPRMUPRB == CollectionsB.getDifference(allUPRMUPRB, dontNeedTrainingUPRMUPRB));
	}

	@Test
	public void testgenderCountBasic() {
		assertEquals(0, (int) CollectionsB.genderCount(empty).size()); 
		assertNotEquals(1, (int) CollectionsB.genderCount(allPlayers).get(CollectionsB.Gender.MALE));
		assertNotEquals(1, (int) CollectionsB.genderCount(allUPRMUPRB).get(CollectionsB.Gender.MALE));
	}
	
	@Test
	public void testgenderCountAdvanced() {	
		assertEquals(5, (int) CollectionsB.genderCount(allPlayers).get(CollectionsB.Gender.MALE));
		assertEquals(5, (int) CollectionsB.genderCount(allPlayers).get(CollectionsB.Gender.FEMALE));
		assertEquals(2, (int) CollectionsB.genderCount(allUPRMUPRB).get(CollectionsB.Gender.MALE));
		assertEquals(4, (int) CollectionsB.genderCount(allUPRMUPRB).get(CollectionsB.Gender.FEMALE));
		assertEquals(null, CollectionsB.genderCount(allFemales).get(CollectionsB.Gender.MALE)); 
		assertEquals(null, CollectionsB.genderCount(allMales).get(CollectionsB.Gender.FEMALE)); 	
		assertEquals(1, CollectionsB.genderCount(allFemales).size()); 
	}
}