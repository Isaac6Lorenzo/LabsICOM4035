package EXAMEN02;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class UPRMClassTest {

	UPRMClass.Student s1;
	UPRMClass.Student s2;
	UPRMClass.Student s3;
	UPRMClass.Student s4;
	UPRMClass.Student s5;
	UPRMClass.Student s6;
	UPRMClass.Student s7;


	UPRMClass empty;
	UPRMClass onlyOne;
	UPRMClass allDifferent;
	UPRMClass allTheSame;
	UPRMClass allINSO;
	UPRMClass noINSO;
	UPRMClass all;
	UPRMClass mixed;
	
	Random rand;

	@Before
	public void setUp() {
		s1 = new UPRMClass.Student("012-82-0101", "Student", "CIIC", 4.0, 1);
		s2 = new UPRMClass.Student("012-82-0102", "Student", "MATE", 3.5, 3);
		s3 = new UPRMClass.Student("012-82-0103", "Student", "INSO", 3.0, 5);
		s4 = new UPRMClass.Student("012-82-0104", "Student", "FISI", 2.8, 4);
		s5 = new UPRMClass.Student("012-82-0105", "Student", "INSO", 3.8, 6);
		s6 = new UPRMClass.Student("012-82-0106", "Student", "CIIC", 2.5, 2);
		s7 = new UPRMClass.Student("012-82-0107", "Student", "INSO", 3.3, 2);


		empty = new UPRMClass();
		onlyOne = new UPRMClass();
		onlyOne.add(s5);
		allDifferent = new UPRMClass();
		allDifferent.add(s1).add(s2).add(s3);
		allTheSame = new UPRMClass();
		allTheSame.add(s7).add(s7).add(s7);
		allINSO = new UPRMClass();
		allINSO.add(s3).add(s5).add(s7);
		noINSO = new UPRMClass();
		noINSO.add(s1).add(s2).add(s4).add(s6);
		all = new UPRMClass();
		all.add(s1).add(s2).add(s3).add(s4).add(s5).add(s6);
		mixed = new UPRMClass();
		mixed.add(s6).add(s5).add(s2).add(s1).add(s4).add(s3).add(s3);

		rand = new Random();

	}
	
	@Test
	public void testAddAll() {
		UPRMClass.Student[] noStudent = {};
		UPRMClass.Student[] oneStudent = {s1};
		UPRMClass.Student[] twoStudents = {s2, s3};
		
		UPRMClass.Student[] emptyStudent = empty.getInternalArray();
		empty.addAll(noStudent);
		
		assertEquals("No students should be added.", 0, empty.size());
		assertEquals("The inner array should not be modified.", 3, empty.getInternalArray().length);
		assertTrue("The array instance should not be changed.", emptyStudent == empty.getInternalArray());
		
		
		empty.addAll(oneStudent);
		assertEquals("A students should be added.", 1, empty.size());
		assertEquals("The inner array should not be modified.", 3, empty.getInternalArray().length);
		assertTrue("The array instance should not be changed.", emptyStudent == empty.getInternalArray());
		assertTrue("The student instance should not be different.", emptyStudent == empty.getInternalArray());
		assertTrue("The array instance should not be changed.", s1 == empty.getStudent(0));

		
		
		empty.addAll(twoStudents);
		assertEquals("A students should be added.", 3, empty.size());
		assertEquals("The inner array should not be modified.", 3, empty.getInternalArray().length);
		assertTrue("The student instance should not be different.", emptyStudent == empty.getInternalArray());
		assertTrue("The array instance should not be changed.", s1 == empty.getStudent(0));
		assertTrue("The array instance should not be changed.", s2 == empty.getStudent(1));
		assertTrue("The array instance should not be changed.", s3 == empty.getStudent(2));
		
		empty.addAll(twoStudents);
		assertEquals("A students should be added.", 5, empty.size());
		assertEquals("The inner array should be modified.", 6, empty.getInternalArray().length);
		assertTrue("The array instance should be changed.", emptyStudent != empty.getInternalArray());
		assertTrue("The array instance should not be changed.", s1 == empty.getStudent(0));
		assertTrue("The array instance should not be changed.", s2 == empty.getStudent(1));
		assertTrue("The array instance should not be changed.", s3 == empty.getStudent(2));
		assertTrue("The array instance should not be changed.", s2 == empty.getStudent(3));
		assertTrue("The array instance should not be changed.", s3 == empty.getStudent(4));
	}
	
	@Test
	public void testEquals() {
		assertFalse("Object does not equal null.", empty.equals(null));
		assertTrue("Object is equal to itself.", empty.equals(empty));
		assertTrue("Object is equal to itself.", all.equals(all));
		assertFalse("Object does not equal to parameter.", empty.equals(all));
		assertFalse("Object does not equal to parameter.", all.equals(empty));
		assertFalse("Object does not equal to parameter.", noINSO.equals(all));
		assertFalse("Object does not equal to parameter.", all.equals(noINSO));
		
		UPRMClass otherClass = new UPRMClass();
		otherClass.add(s1).add(s2).add(s4).add(s6);
		assertTrue("Object does equal to parameter.", otherClass.equals(noINSO));
		assertTrue("Object does equal to parameter.", noINSO.equals(otherClass));
	}
	
	@Test
	public void testAverageYearsInCollege() {
		assertEquals("Should return 0.", 0, empty.averageYearsInCollege("INSO"));
		assertEquals("Should return 0.", 0, onlyOne.averageYearsInCollege("CIIC"));
		assertEquals("Should return 6.", 6, onlyOne.averageYearsInCollege("INSO"));
		assertEquals("Should return 0.", 0, noINSO.averageYearsInCollege("INSO"));
		assertEquals("Should return 1.", 1, noINSO.averageYearsInCollege("CIIC"));
		assertEquals("Should return 4.", 4, allINSO.averageYearsInCollege("INSO"));
		assertEquals("Should return 5.", 5, mixed.averageYearsInCollege("INSO"));
		assertEquals("Should return 1.", 1, mixed.averageYearsInCollege("CIIC"));
	}
	
	@Test
	public void testMinGPA() {
		assertTrue("Should return null.", empty.minGPA()==null);
		assertEquals("Should return s3", s3, allINSO.minGPA());
		assertEquals("Should return s6", s6, all.minGPA());
		assertEquals("Should return s5", s5, onlyOne.minGPA());
		assertEquals("Should return s6", s6, mixed.minGPA());
		assertEquals("Should return s4", s6, noINSO.minGPA());
	}
	
	@Test
	public void testRepeatedStudent() {
		assertFalse("There are no repeated students", empty.repeatedStudent());
		assertFalse("There are no repeated students", onlyOne.repeatedStudent());
		assertFalse("There are no repeated students", all.repeatedStudent());
		assertTrue("There are repeated students", allTheSame.repeatedStudent());
		assertTrue("There are repeated students", mixed.repeatedStudent());

	}

}