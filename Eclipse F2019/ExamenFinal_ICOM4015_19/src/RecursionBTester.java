import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class RecursionBTester {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testPowerMod() {
		assertEquals("Incorrect powerMod(9,1,10)", 9, RecursionB.powerMod(9, 1, 10));
		assertEquals("Incorrect powerMod(3,2,6)", 3, RecursionB.powerMod(3, 2, 6));
		assertEquals("Incorrect powerMod(13,3,7)", 6, RecursionB.powerMod(13, 3, 7));
		assertEquals("Incorrect powerMod(7,7,4)", 3, RecursionB.powerMod(7, 7, 4));
		assertEquals("Incorrect powerMod(15,2,9)", 0, RecursionB.powerMod(15, 2, 9));
		assertEquals("Incorrect powerMod(2,2,3)", 1, RecursionB.powerMod(2, 2, 3));
		assertEquals("Incorrect powerMod(2,8,100)", 56, RecursionB.powerMod(2, 8, 100));
		assertEquals("Incorrect powerMod(13,9,7)", 6, RecursionB.powerMod(13, 9, 7));


        thrown.expect(StackOverflowError.class);
        assertEquals("StackOverflowError was expected", 0,
                RecursionB.powerMod(12, 100000, 6));

	}


	@Test
	public void deleteK(){
		String testString1 = "Java is cool, Java is cool.";
		assertEquals("Incorrect result for \"Java is cool, Java is cool.\"", " Java is cool.", RecursionB.deleteK(testString1, "Java is cool,", 1));
		String testString2 = "wowowowowowh";
		assertEquals("Incorrect result for \"wowowowowow\"", "ooh", RecursionB.deleteK(testString2, "wow", 4));
		String testString3 = "Hello World";
		assertEquals("Incorrect result for \"Hello World\"", "Hello World", RecursionB.deleteK(testString3, "Hello", 0));
		String testString4 = "";


		for(int i=0; i<10000; i++){
			testString4 = testString4.concat("o");
		}
		thrown.expect(StackOverflowError.class);
		assertEquals("StackOverflowError was expected", "",
				RecursionB.deleteK(testString4,"o" , 10000));
	}

	@Test
	public void testKCommittees() {
		
		HashSet< String> assembly1 = new HashSet< String>(Arrays.asList("juan","pedro","maria"));
		ArrayList< Set< String>> result0 = RecursionB.kCommittees(assembly1, 0);
		assertEquals("kStrings returns list of incorrect size", 1, result0.size());
		assertTrue("Expected committee not found", result0.contains(new HashSet< String>()));
		
		ArrayList< Set< String>> result1 = RecursionB.kCommittees(assembly1, 3);
		assertEquals("kCommittees returns list of incorrect size", 1, result1.size());
		assertTrue("Expected committee not found", result1.contains(new HashSet< String>(Arrays.asList("juan","pedro","maria"))));
		
		ArrayList< Set< String>> result2 = RecursionB.kCommittees(assembly1, 2);
		assertEquals("kCommittees returns list of incorrect size", 3, result2.size());
		assertTrue("Expected committee not found", result2.contains(new HashSet< String>(Arrays.asList("juan","pedro"))));
		assertTrue("Expected committee not found", result2.contains(new HashSet< String>(Arrays.asList("pedro","maria"))));
		assertTrue("Expected committee not found", result2.contains(new HashSet< String>(Arrays.asList("maria", "juan"))));

		HashSet< String> assembly2 = new HashSet< String>(Arrays.asList("name0","name1","name2","name3","name4","name5"));
		ArrayList< Set< String>> result3 = RecursionB.kCommittees(assembly2, 2);
		assertEquals("kCommittees returns list of incorrect size", 15, result3.size());
		assertTrue("Expected committee not found", result3.contains(new HashSet< String>(Arrays.asList("name0","name1"))));
		assertTrue("Expected committee not found", result3.contains(new HashSet< String>(Arrays.asList("name0","name2"))));
		assertTrue("Expected committee not found", result3.contains(new HashSet< String>(Arrays.asList("name0","name3"))));
		assertTrue("Expected committee not found", result3.contains(new HashSet< String>(Arrays.asList("name0","name4"))));
		assertTrue("Expected committee not found", result3.contains(new HashSet< String>(Arrays.asList("name0","name5"))));
		assertTrue("Expected committee not found", result3.contains(new HashSet< String>(Arrays.asList("name1","name2"))));
		assertTrue("Expected committee not found", result3.contains(new HashSet< String>(Arrays.asList("name1","name3"))));
		assertTrue("Expected committee not found", result3.contains(new HashSet< String>(Arrays.asList("name1","name4"))));
		assertTrue("Expected committee not found", result3.contains(new HashSet< String>(Arrays.asList("name1","name5"))));
		assertTrue("Expected committee not found", result3.contains(new HashSet< String>(Arrays.asList("name2","name3"))));
		assertTrue("Expected committee not found", result3.contains(new HashSet< String>(Arrays.asList("name2","name4"))));
		assertTrue("Expected committee not found", result3.contains(new HashSet< String>(Arrays.asList("name2","name5"))));
		assertTrue("Expected committee not found", result3.contains(new HashSet< String>(Arrays.asList("name3","name4"))));
		assertTrue("Expected committee not found", result3.contains(new HashSet< String>(Arrays.asList("name3","name5"))));
		assertTrue("Expected committee not found", result3.contains(new HashSet< String>(Arrays.asList("name4","name5"))));

	}

}