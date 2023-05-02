package EXAMEN02;

public class UPRMClass {
	
	private Student[] roster;
	private int studentCount;
	
	/**
	 * A method to initialize an UPRMClass data structure
	 */
	public UPRMClass() {
		roster = new Student[3];
		studentCount = 0;
	}
	
	/**
	 * A method to initialize an UPRMClass data structure with the given space reserved.
	 */
	public UPRMClass(int initialSpace) {
		roster = new Student[initialSpace];
		studentCount = 0;
	}
	
	public UPRMClass(Student[] initialClass) {
		roster = initialClass;
		studentCount = initialClass.length;
				
	}
	
	public int size() {
		return studentCount;
	}
	
	public Student getStudent(int index) {
		if(index < 0 || index >= studentCount) return null;
		return roster[index];
	}
	
	public Student[] getInternalArray() {
		return roster;
	}
		
	public UPRMClass add(Student student) {
		if(studentCount >= roster.length) {
			Student[] newRoster = new Student[roster.length*2];
			for(int i = 0; i < roster.length; i++) {
				newRoster[i] = roster[i];
			}
			roster = newRoster;
		}
		roster[studentCount++] = student;
		return this;
	}
	
	/**
	 * Exercise #1
	 * Adds all the given students into the instance roster.
	 * HINT: You may find the add method useful
	 * @param students
	 */
	public void addAll(Student[] students) {
		// Add code here!
	}
	
	/**
	 * Exercise #2
	 * Returns true if and only if target and parameter Classes have the same ammount of students
	 * and all the students are the same.
	 */
	@Override
	public boolean equals(Object o) {
		if (o instanceof UPRMClass) {
			UPRMClass otherClass = (UPRMClass) o;
			// Add Code Here
			return true; // Dummy return

		}
		return false;
	}

	/**
	 * Exercise #3
	 * Returns the average years between all the students that are in the given major.
	 * @return
	 */
	public int averageYearsInCollege(String major) { 
		// Add code here
		return 0; // Dummy return
	}
	
	/**
	 * Exercise #4
	 * Returns the first student with the lowest GPA.
	 * @return
	 */
	public Student minGPA() {
		// Add code here
		return null; // Dummy return
	}
	
	
	/**
	 * Exercise #5
	 * Returns true if there is a repeated student in the roster, false otherwise.
	 * @return
	 */
	public boolean repeatedStudent() {
		// Add code here
		return false; // Dummy return
	}
	

	public static class Student {
		
		private String id;
		private String name;
		private String major;
		private double gpa;
		private int yearsInCollege;
	
		public Student(String id, String name, String major, double gpa, int yearsInCollege) {
			this.id = id;
			this.name = name;
			this.major = major;
			this.gpa = gpa;
			this.yearsInCollege = yearsInCollege; 
		}
	
		// Getters
		public String getID() {
			return id;
		}
	
		public String getName() {
			return name;
		}
	
		public String getMajor() {
			return major;
		}
	
		public double getGPA() {
			return gpa;
		}
	
		public int getYearsInCollege() {
			return yearsInCollege;
		}
	
		/**
		 * Returns true if and only if target and parameter StudentRecord's have equal ID's
		 */
		@Override
		public boolean equals(Object o) {
			if (o instanceof Student) {
				Student sr = (Student) o;
				return this.getID().equals(sr.getID());
			}
			return false;
		}
	}
}