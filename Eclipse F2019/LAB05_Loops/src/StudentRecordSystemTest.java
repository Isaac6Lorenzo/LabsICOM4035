import static org.junit.Assert.*;

import org.junit.Test;

public class StudentRecordSystemTest {

	 @Test
	 public void recordsToStringTest() {
	  String[] expectedStrings = new String[3];
	  expectedStrings[0] = "ID: 802174579, Name: Juan, Gender: M, GPA: 3.40";
	  expectedStrings[1] = "ID: 802122423, Name: Julia, Gender: F, GPA: 3.35";
	  expectedStrings[2] = "ID: 802113349, Name: Eliezer, Gender: M, GPA: 3.90";
	  StudentRecordSystem studentRecordSystem = StudentRecordSystem.initializeInstance(6);
	  String[] actualStrings = studentRecordSystem.recordsToString();
	  assertEquals("The size of array of Strings doesn't have the right length.", 0, actualStrings.length);
	  
	  StudentRecordSystem.StudentRecord[] sr = new StudentRecordSystem.StudentRecord[3];

	  sr[0] = new StudentRecordSystem.StudentRecord("802174579", "Juan", StudentRecordSystem.Gender.MALE, 3.40);
	  sr[1] = new StudentRecordSystem.StudentRecord("802122423", "Julia", StudentRecordSystem.Gender.FEMALE, 3.35);
	  sr[2] = new StudentRecordSystem.StudentRecord("802113349", "Eliezer", StudentRecordSystem.Gender.MALE, 3.90);
	  studentRecordSystem.addAllStudents(sr);

	  actualStrings = studentRecordSystem.recordsToString();
	  assertEquals("The size of array of Strings doesn't have the right length.", 3, actualStrings.length);
	  assertEquals("Student Juan has incorrect record.", expectedStrings[0], actualStrings[0]);
	  assertEquals("Student Julia has incorrect record.", expectedStrings[1], actualStrings[1]);
	  assertEquals("Student Eliezer has incorrect record.", expectedStrings[2], actualStrings[2]);
	 }

	 @Test
	 public void containsTest() {
	  StudentRecordSystem studentRecordSystem = StudentRecordSystem.initializeInstance(2);
	  StudentRecordSystem.StudentRecord[] sr = new StudentRecordSystem.StudentRecord[3];

	  sr[0] = new StudentRecordSystem.StudentRecord("802122423", "Julia", StudentRecordSystem.Gender.FEMALE, 3.35);
	  sr[1] = new StudentRecordSystem.StudentRecord("802113679", "Pedro", StudentRecordSystem.Gender.MALE, 3.00); 
	  sr[2] = new StudentRecordSystem.StudentRecord("802113349", "Eliezer", StudentRecordSystem.Gender.MALE, 3.90);
	  studentRecordSystem.addAllStudents(sr);

	  assertFalse(studentRecordSystem.contains(new StudentRecordSystem.StudentRecord("802121234", "Margarita", StudentRecordSystem.Gender.FEMALE, 4.00)));
	  
	  sr = new StudentRecordSystem.StudentRecord[2];
	  sr[0] = new StudentRecordSystem.StudentRecord("802118754", "Dillan", StudentRecordSystem.Gender.MALE, 2.50);
	  studentRecordSystem.addAllStudents(sr);
	  StudentRecordSystem.StudentRecord studentRecord = new StudentRecordSystem.StudentRecord("802113349", "Eliezer", StudentRecordSystem.Gender.MALE, 3.90);
	  
	  assertTrue(studentRecordSystem.contains(studentRecord));
	 }

}
