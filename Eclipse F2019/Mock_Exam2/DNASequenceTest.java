import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class DNASequenceTest {

	DNASequence DNASequenceL5;
	DNASequence DNASequenceL5R;
	DNASequence DNASequenceL10;
	DNASequence DNASequenceL15;
	DNASequence DNASequenceL20;
	DNASequence DNASequence5;
	DNASequence DNASequence6;
	DNASequence DNASequence7;
	DNASequence DNASequence8;

	DNASequence[] empty;
	DNASequence[] onlyOne;
	DNASequence[] allSame;
	DNASequence[] contained1;
	DNASequence[] contained2;
	DNASequence[] contained3;
	DNASequence[] contained4;
	DNASequence[] contained5;
	DNASequence[] notContained;

	// Methods annotated with @Before are repeatedly executed once before running each test method
	@Before
	public void setUp() {
		DNASequenceL5 = new DNASequence("AGTCG", "dna");
		DNASequenceL5R = new DNASequence("GCTGA", "dna");
		DNASequenceL10 = new DNASequence("AGTCGGCTGA", "dna");
		DNASequenceL15 = new DNASequence("AGTCGGCTGACCCCC", "dna");
		DNASequenceL20 = new DNASequence("AGTCGGCTGACCCCCATATA", "dna");

		empty = new DNASequence[] {null, null, null};
		onlyOne = new DNASequence[] { DNASequenceL5, null, null };
		allSame = new DNASequence[] { DNASequenceL10, DNASequenceL10, DNASequenceL10, null };
		contained1 = new DNASequence[] { DNASequenceL5, DNASequenceL10, null};
		contained2 = new DNASequence[] { DNASequenceL5, DNASequenceL5R, DNASequenceL10, null };
		contained3 = new DNASequence[] { DNASequenceL5R, DNASequenceL5, DNASequenceL10, null };
		contained4 = new DNASequence[] { DNASequenceL5, DNASequenceL10, null };
		contained5 = new DNASequence[] { DNASequenceL10, DNASequenceL10, null, null };
		notContained = new DNASequence[] { DNASequenceL5, DNASequenceL5R, null };
	}
		
		@Test
		public void testIsProtein() {
			DNASequence s1 = new DNASequence(new DNASequence("GGGCCCTTTGGGAAA", "dna"));
			assertFalse("Incorrect isProtein in DNASequence", s1.isProtein());
			DNASequence s2 = new DNASequence(new DNASequence("GGGCCCTTTCCCAAA", "protein"));
			assertTrue("Incorrect isProtein in DNASequence", s2.isProtein());		
		}
	
		@Test
		public void testContains() {
			DNASequence s1 = new DNASequence(new DNASequence("GGGCCCTTTGGGAAA", "dna"));
			DNASequence p1 = new DNASequence("GCC", "dna");
			DNASequence p2 = new DNASequence("GCG", "dna");
			assertTrue("Incorrect contains in DNASequence", s1.contains(p1));
			assertFalse("Incorrect contains in DNASequence", s1.contains(p2));
			DNASequence s2 = new DNASequence(new DNASequence("AAAAAAAAAAAAA", "dna"));
			DNASequence p3 = new DNASequence("AAA", "dna");
			DNASequence p4 = new DNASequence("GGG", "dna");
			assertTrue("Incorrect contains in DNASequence", s2.contains(p3));
			assertFalse("Incorrect contains in DNASequence", s2.contains(p4));
		}
	
		@Test
		public void testAppend() {
			DNASequence s1 = new DNASequence(new DNASequence("GGGCCCTTTGGGAAA", "dna"));
			DNASequence p1 = new DNASequence("GCC", "dna");
			DNASequence s2 = s1.append(p1);
			assertNotNull("Incorrect append in DNASequence class", s2);
			DNASequence s3 = new DNASequence("GGGCCCTTTGGGAAA" + "GCC", "dna");
			assertFalse("Incorrect append in DNASequence class", s1 == s2);
			assertEquals("Incorrect append in DNASequence class", s3.getSequence(), s2.getSequence());
			s2 = s2.append(p1);
			assertNotNull("Incorrect append in DNASequence class", s2);
			DNASequence s4 = new DNASequence("GGGCCCTTTGGGAAA" + "GCC" + "GCC", "dna");
			assertEquals("Incorrect append in DNASequence class", s4.getSequence(), s2.getSequence());
		}

	@Test
	public void testLongestSequence() {
		assertEquals(null, DNASequence.longestSequence(empty));
		assertNotNull(DNASequence.longestSequence(onlyOne));
		assertEquals(onlyOne[0], DNASequence.longestSequence(onlyOne));
		assertNotNull(DNASequence.longestSequence(allSame));
		assertEquals(allSame[0], DNASequence.longestSequence(allSame));
		assertNotNull(DNASequence.longestSequence(contained2));
		assertEquals(contained2[2], DNASequence.longestSequence(contained2));
	}

	@Test
	public void testConcatenate() {
		assertNotNull(DNASequence.concatenate(empty));
		assertEquals(new DNASequence("", "dna"), DNASequence.concatenate(empty));
		assertNotNull(DNASequence.concatenate(onlyOne));
		assertEquals(DNASequenceL5, DNASequence.concatenate(onlyOne));
		assertNotNull(DNASequence.concatenate(notContained));
		assertEquals(DNASequenceL10, DNASequence.concatenate(notContained));
	}


	@Test
	public void testExists() {
		assertFalse(DNASequenceL10.exists(empty));
		assertFalse(DNASequenceL10.exists(onlyOne));
		assertTrue(DNASequenceL5.exists(onlyOne));
		assertTrue(DNASequenceL10.exists(allSame));
		assertTrue(DNASequenceL10.exists(contained3));
	}

	@Test
	public void testAddSequence() {
		assertTrue(Arrays.equals(onlyOne, DNASequenceL5.addSequence(empty)));
		assertTrue(Arrays.equals(contained4, DNASequenceL10.addSequence(onlyOne)));
		assertTrue(Arrays.equals(allSame, DNASequenceL10.addSequence(contained5)));
	}

	@Test
	public void testCompletelyContained() {
		assertFalse(DNASequence.someCompletelyContained(empty));
		assertFalse(DNASequence.someCompletelyContained(notContained));
		assertTrue(DNASequence.someCompletelyContained(contained1));
		assertTrue(DNASequence.someCompletelyContained(contained2));
		assertTrue(DNASequence.someCompletelyContained(contained3));
		assertTrue(DNASequence.someCompletelyContained(contained4));
		assertTrue(DNASequence.someCompletelyContained(contained5));
	}
}