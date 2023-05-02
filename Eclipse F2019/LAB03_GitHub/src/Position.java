
public class Position {
	private String positionCode; //Position Code
	private int reqRank;//Rank required to be here
	private double hSalary;//Position Salary
	private boolean available;//Position Availability
	private boolean jobType; //Full Time [True] Part Time [False];
	
	public Position(String pCode, int rank, double salary, boolean availability, boolean jobType) {
		setPositionCode(pCode);
		setRank(rank);
		setSalary(salary);
		setAvailability(availability);
		setJobType(jobType);
	}

	public String getPositionCode() {
		return positionCode;
	}

	public void setPositionCode(String positionCode) {
		this.positionCode = positionCode;
	}

	public int getRank() {
		return reqRank;
	}

	public void setRank(int reqRank) {
		this.reqRank = reqRank;
	}

	public double getSalary() {
		return hSalary;
	}

	public void setSalary(double hSalary) {
		this.hSalary = hSalary;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailability(boolean available) {
		this.available = available;
	}

	public boolean getJobType() {
		return jobType;
	}

	public void setJobType(boolean jobType) {
		this.jobType = jobType;
	}
	
	/**
	 * A method that calculates an average yearly salary.
	 * 1. The calculation depends what type of job it is:
	 * 		a) If the position is part time 20 hours is determined.
	 * 		b) If the position is full time 40 hours is determined.
	 * 
	 * Hint: Given an hourly salary to calculate a yearly salary we 
	 * use the following formula: 
	 * 		yearlySalary = HoursPerWeek * SalaryByHour * WeeksAMonth * MonthsAYear.
	 * @return 
	 */
	public double getYearlySalary() {
		//Code [Use If/Else]
			
		double SalaryByHour = this.hSalary;
		double WeeksAMonth = 4.5;
		int MonthsAYear = 12;
//		Position p1 = new Position("CEO-2",    100,        120.00,          true,                 true);
//		public Position(String pCode ,      int rank,      double salary, boolean availability, boolean jobType) {
		
		if(jobType == true) {
			//full_time = 40 h
			//System.out.println("full_time = 40 h\n" );

			int HoursPerWeek = 40;
			double yearlySalary = HoursPerWeek * SalaryByHour * WeeksAMonth * MonthsAYear;
			return yearlySalary;
		}
		
		if(jobType == false) {
			//part_time = 20 h
		//	System.out.println("part_time = 20 h\n" );
			int HoursPerWeek = 20;
			double yearlySalary = HoursPerWeek * SalaryByHour * WeeksAMonth * MonthsAYear;
			return yearlySalary;
		}
		
		return 0; 
	}
	
	
	
	
	
	
}
