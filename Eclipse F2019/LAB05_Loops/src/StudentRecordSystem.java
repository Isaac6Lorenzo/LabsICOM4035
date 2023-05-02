import java.util.ArrayList;

public class StudentRecordSystem {

	private static StudentRecordSystem studentRecordSystem;
	private StudentRecord[] studentRecords;
	private int totalStudentRecords; // Actual number of student records currently in the system.

	static {
		studentRecordSystem = new StudentRecordSystem();
	}

	private StudentRecordSystem() {
	}

	public static StudentRecordSystem initializeInstance(int maxNumberOfStudentRecords) {
		studentRecordSystem.studentRecords = new StudentRecord[maxNumberOfStudentRecords];
		studentRecordSystem.totalStudentRecords = 0;
		return studentRecordSystem;
	}

// Getters
	public StudentRecord[] getStudentRecords() {
		return studentRecords;
	}

	public int getTotalStudentRecords() {
		return totalStudentRecords;
	}

	/*
	 * **IMPORTANT** Method for testers, Other methods should be done using Arrays.
	 * The use of Lists or any of it's functions is forbidden.
	 */

	public void addAllStudents(StudentRecord[] sr) {
		ArrayList<StudentRecord> list = new ArrayList<StudentRecord>();
		for (int i = 0; i < totalStudentRecords; i++) {
			list.add(studentRecords[i]);
		}
		for (StudentRecord s : sr) {
			list.add(s);
		}
		studentRecords = list.toArray(new StudentRecord[0]);
		totalStudentRecords += sr.length;
	}

	/*
	 * EXERCISE: #1
	 *
	 * IMPLEMENT USING AN ENHANCED FOR LOOP (For-each).
	 *
	 * Adds a new student record with the given parameters.
	 *
	 * HINT: Create a new array twice the size of the original array and move all
	 * the elements to this mew array if the totalStudentRecords exceeds the
	 * capacity of the current array.
	 */
	public void addStudentRecord(String id, String name, Gender gender, double gpa) {
//Write your code here
		
		StudentRecord[] newRecord = this.getStudentRecords();
		this.studentRecords = new StudentRecord[this.getTotalStudentRecords() * 2];
		this.addAllStudents(newRecord);
		
		
//		StudentRecord newRecord = new StudentRecord(id, name, gender, gpa);
//		int index = 0;
//		if (totalStudentRecords == studentRecords.length) {
//			StudentRecord[] studentRecord = new StudentRecord[totalStudentRecords * 2];
//			for (StudentRecord s : studentRecords) {
//				studentRecord[index] = s;
//				index++;
//			}
//
//			this.studentRecords = studentRecord;
//
//		}
//		studentRecords[totalStudentRecords] = newRecord;
//		totalStudentRecords++;

	}

	/*
	 * Enum of type Gender representing male or female.
	 */
	public enum Gender {
		MALE('M'), FEMALE('F');
		private final char letter;

		Gender(char letter) {
			this.letter = letter;
		}

		public char genderLetter() {
			return letter;
		}
	}

	/*
	 * Inner class representing student records in the student record system.
	 */
	public static class StudentRecord {

		private String id;
		private String name;
		private Gender gender;
		private double gpa;

		public StudentRecord(String id, String name, Gender gender, double gpa) {
			this.id = id;
			this.name = name;
			this.gender = gender;
			this.gpa = gpa;
		}

		public String toString() {
			return String.format("ID: " + id + ", Name: " + name + ", Gender: " + gender.genderLetter() + ", GPA: %.2f",
					gpa);
		}

// Getters
		public String getID() {
			return id;
		}

		public String getName() {
			return name;
		}

		public Gender getGender() {
			return gender;
		}

		public double getGPA() {
			return gpa;
		}
	}

	/*
	 * EXERCISE: #2A
	 *
	 * IMPLEMENT USING A REGULAR FOR LOOP.
	 *
	 * Returns an array of Strings where each entry represents a student record.
	 *
	 * HINT: Use the toString method in the Student Record inner class.
	 */
	public String[] recordsToString() {
// YOUR CODE GOES HERE.
		String[] newArray = new String[totalStudentRecords];
		for (int i = 0; i < totalStudentRecords; i++) {
			String student = studentRecords[i].toString();
			newArray[i] = student;
		}
		return newArray;
	}

	/*
	 * EXERCISE: #2B
	 *
	 * IMPLEMENT USING A WHILE LOOP.
	 *
	 * Returns true if this list contains the specified student. More formally,
	 * returns true if and only if this list contains at least one element e such
	 * that (o==null ? e==null : o.equals(e)).
	 *
	 *
	 */
	public boolean contains(StudentRecord s) {
// YOUR CODE GOES HERE.
		int index = 0;
		while (index < totalStudentRecords) {
			if (this.studentRecords[index].toString().equals(s.toString())) {
				return true;
			}
			index++;
		}
		return false;
	}

	/*
	 * EXERCISE: #3A
	 *
	 * IMPLEMENT WITH ANY LOOP.
	 *
	 * Returns the mean of the GPA's in student record system
	 *
	 */
	public double getMean() {
// YOUR CODE GOES HERE.
		double sum = 0;
		if (totalStudentRecords == 0) {
			return 0;
		}
		for (int i = 0; i < totalStudentRecords; i++) {
			sum += this.studentRecords[i].getGPA();
		}
		return sum / totalStudentRecords;
	}

	/*
	 * EXERCISE: #3B
	 *
	 * IMPLEMENT WITH ANY LOOP.
	 *
	 * Returns the standard deviation of the GPA's in student record system.
	 */
	public double getStandardDeviation() {
// YOUR CODE GOES HERE.
		double sum = 0;
		if (totalStudentRecords == 0) {
			return 0;
		}
		for (int i = 0; i < totalStudentRecords; i++) {
			sum += Math.pow(this.studentRecords[i].getGPA() - this.getMean(), 2);
		}
		return Math.sqrt(sum / totalStudentRecords - 1);
	}

}

//LO QUE YO ESCRIBI EN EL LAB 05

//import java.util.ArrayList;
//
//public class StudentRecordSystem {
//
//	private static StudentRecordSystem studentRecordSystem;
//	private StudentRecord[] studentRecords;
//	private int totalStudentRecords;	// Actual number of student records currently in the system.
//	
//	
//	/*
//	 * Inner class representing student records in the student record system.
//	 */
//	public static class StudentRecord {
//		
//		private String id;
//		private String name;
//		private Gender gender;
//		private double gpa;
//		
//		public StudentRecord(String id, String name, Gender gender, double gpa) {
//			this.id = id;
//			this.name = name;
//			this.gender = gender;
//			this.gpa = gpa;
//		}
//
//		public String toString() {
//			return String.format("ID: " + id + ", Name: " + name + ", Gender: " + gender.genderLetter() + ", GPA: %.2f", gpa);
//		}
//		
//		// Getters
//		public String getID() {
//			return id;
//		}
//		
//		public String getName() {
//			return name;
//		}
//		
//		public Gender getGender() {
//			return gender;
//		}
//		
//		public double getGPA() {
//			return gpa;
//		}
//	}
//	
//	
//	
//	static {
//		studentRecordSystem = new StudentRecordSystem();
//	}
//	
//	private StudentRecordSystem() {}
//	
//	public static StudentRecordSystem initializeInstance(int maxNumberOfStudentRecords){
//		studentRecordSystem.studentRecords = new StudentRecord[maxNumberOfStudentRecords];
//		studentRecordSystem.totalStudentRecords = 0;
//        return studentRecordSystem;
//    }
//	
//	// Getters
//	public StudentRecord[] getStudentRecords() {
//		return studentRecords;
//	}
//	
//	public int getTotalStudentRecords() {
//		return totalStudentRecords;
//	}
//	
//	/*                       **IMPORTANT**
//	 * Method for testers, Other methods should be done using Arrays.
//	 * The use of Lists or any of it's functions is forbidden.
//	 */
//	
//	public void addAllStudents(StudentRecord[] sr) {
//		ArrayList<StudentRecord> list = new ArrayList<StudentRecord>();
//		for(int i = 0; i<totalStudentRecords; i++) {
//			list.add(studentRecords[i]);
//		}
//		for(StudentRecord s: sr) {
//			list.add(s);
//		}
//		studentRecords = list.toArray(new StudentRecord[0]);
//		totalStudentRecords += sr.length;
//	}
//	
//    /*
//     * EXERCISE: #1
//     * 
//	 * IMPLEMENT USING AN ENHANCED FOR LOOP (For-each).
//	 * 
//	 * Adds a new student record with the given parameters.
//	 * 
//	 * HINT: Create a new array twice the size of the original array and move 
//	 * all the elements to this mew array if the totalStudentRecords exceeds 
//	 * the capacity of the current array.
//	 */
//	public void addStudentRecord(String id, String name, Gender gender, double gpa) {
//		//Write your code here	
//	
//		for(StudentRecord s: studentRecords) {
//
//		}
//		
//		
//	}
//	
//	/* 
//	 * EXERCISE: #2A
//     * 
//	 * IMPLEMENT USING A REGULAR FOR LOOP.
//	 * 
//	 * Returns an array of Strings where each entry represents a student record.
//	 * 
//	 * HINT: Use the toString method in the Student Record inner class.
//	 */
//	public String[] recordsToString() {
//		// YOUR CODE GOES HERE.
//		for(int i = 0; i <= totalStudentRecords; i++) {
//			
//			
//			
//			
//			return null;
//			
//		}
//		
//		
//		return null;
//	}
//	
//	/* 
//	 * EXERCISE: #2B
//     * 
//	 * IMPLEMENT USING A WHILE LOOP.
//	 * 
//	 * Returns true if this list contains the specified student. More 
//	 * formally, returns true if and only if this list contains at 
//	 * least one element e such that (o==null ? e==null : o.equals(e)).
//	 * 
//	 * 
//	 */
//	public boolean contains(StudentRecord s) {
//		// YOUR CODE GOES HERE.
//		
//		while(s.equals(studentRecords)) {
//			return true;
//			
//		}
//		
////	//	if (s.equals(studentRecords)) {
////			return true;
////		}
//		
//		
//		return false;
//	}
//	
//	/* 
//	 * EXERCISE: #3A
//     *
//	 * IMPLEMENT WITH ANY LOOP.
//	 * 
//	 * Returns the mean of the GPA's in student record system
//	 * 
//	 */
//	public double getMean() {
//		// YOUR CODE GOES HERE
//		double Sum = 0, Mean = 0;
//		for(int i=0; i<=getTotalStudentRecords(); i++) {
//			Sum = Sum + studentRecords[i].getGPA();
//		}
//		
//		Mean = (Sum/getTotalStudentRecords());
//		
//		
//		return Mean;
//	}
//	
//	/* 
//	 * EXERCISE: #3B
//     *
//	 * IMPLEMENT WITH ANY LOOP.
//	 * 
//	 * Returns the standard deviation of the GPA's in student record system.
//	 */
//	public double getStandardDeviation() {
//		// YOUR CODE GOES HERE.
//		double sum, mean, s, deno,nume1, nume2, num;
//		deno = totalStudentRecords -1;
//		sum = 0; //la sumatoria de todos los gpa y despues esa sum al cuadrado
//		nume1 = 0; // cada elemento al cuadrado primero y luego sumado al resto sum xsub^2
//		//formula sum (xsubi^2 - (xsubi)^2 /n= totalstudentrecords    / deno    y todo con sqrt de math 
//		///standard deviation
//		nume2 = Math.pow(sum, 2);
//		num = nume1+nume2;
//		
//		s = Math.sqrt(num/deno);
//		
//		
//		return 0;
//	}
//	
//	/* 
//	 * BONUS
//	 * 
//	 * IMPLEMENT WITH NESTED LOOPS.
//	 * 
//	 * Returns true if two instances of StudentRecord have the same name, false otherwise.
//	 * HINT: Use the Equals method.
//	 */
//	public boolean repeatedStudentNames() {
//		// YOUR CODE GOES HERE.
//		for(int i = 0; i<= getTotalStudentRecords(); i++) {
//			for(int j = 0; j<=getTotalStudentRecords(); j++) {
//				
//				if (studentRecords[i].equals(studentRecords[j])) {
//				
//				return true;
//				}
//			}
//		}
//		
//		
//		return false;
//	}
//	
//	/*
//	 * Enum of type Gender representing male or female.
//	 */
//	public enum Gender {
//		MALE('M'), FEMALE('F');
//		private final char letter;
//		Gender(char letter) { this.letter = letter; }
//		public char genderLetter() { return letter; }
//	}
//	
//	
//}
