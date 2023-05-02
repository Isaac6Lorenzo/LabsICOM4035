package EXAMEN01;

public class MotorVehicle {
	
	private String make;			// Make (e.g. Ford, Fiat, Chevrolet)
	private String model;			// Model (e.g. Mustang, Rav4, Corvette)
	private String licensePlate;	// License plate (e.g. MVR-175)
	private int year;				// Year (e.g. 2012)
	private double mileage;			// Total miles traveled by MotorVehicle
	private int warrantyYears;		// Warranty in years
	private double warrantyMileage;	// Warranty in miles
									// Warranty expires as soon as warrantyYears pass or 
									// warrantyMileage is achieved.
	
	/**
	 * Constructor that creates a new MotorVehicle object where the
	 * values (information) for all the properties are provided as arguments.
	 */
	public MotorVehicle(String make, String model, String licensePlate, int year, double mileage, int wy, double wm) {
		this.make = make;
		this.model = model;
		this.licensePlate = licensePlate;
		this.year = year;
		this.mileage = mileage;
		this.warrantyYears = wy;
		this.warrantyMileage = wm;
	}

	/**
	 * EXERCISE: #1
	 * 
	 * Finish the copy constructor which can be used to create a new identical copy of the parameter MotorVehicle.
	 * The new MotorVehicle will have the same values for all the properties as the parameter MotorVehicle.
	 * Hint: Think about how are we going to retrieve all the needed instance variables from the given parameter.
	 */
	public MotorVehicle(MotorVehicle mv) {
		// TODO -- YOUR CODE HERE
		this.make = mv.make;
		this.model = mv.model;
		this.licensePlate = mv.licensePlate;
		this.year = mv.year;
		this.mileage = mv.mileage;
		this.warrantyYears =mv.warrantyYears;
		this.warrantyMileage = mv.warrantyMileage;

	}
	
	// Getters
	public String getMake() {
		return make;
	}
	public String getModel() {
		return model;
	}
	public String getLicensePlate() {
		return licensePlate;
	}
	public int getYear() {
		return year;
	}
	public double getMileage() {
		return mileage;
	}
	
	public int getWarrantyYears() {
		return warrantyYears;
	}

	public double getWarrantyMileage() {
		return warrantyMileage;
	}
	
	public void setMake(String make) {
		this.make = make;
	}
	
	public void setModel(String model) {
		this.model = model;
//		public class MotorVehicle {
//
//		}

	}
	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public void setMileage(double mileage) {
		this.mileage = mileage;
	}
	
	public void setWarrantyYears(int warrantyYears) {
		this.warrantyYears = warrantyYears;
	}

	public void setWarrantyMileage(double warrantyMileage) {
		this.warrantyMileage = warrantyMileage;
	}
	
	// Instance methods
	
	/**
	 * EXERCISE: #2
	 * 
	 * Adds the given additionalMiles to the target MotorVehicle mileage. 
	 */
	public void addMileage(double additionalMiles) {
		// TODO -- YOUR CODE HERE
		this.mileage = this.mileage + additionalMiles;
	}
	
	/**
	 * EXERCISE: #3
	 * 
	 * Returns the average miles per year traveled by the target MotorVehicle.
	 * Cannot return 0 nor negative values. 
	
	 * If the Car has less than one year, the average miles will be simply
	 * be the current mileage.  Otherwise it can be computed as follows:
	 * Average Mileage = mileage / (currentYear - VehicleYear)
	 * 
	 * HINT: Math's max method may be of help.
	 */
	public double milesPerYear(int currentYear) {
		// TODO -- YOUR CODE HERE
		if((currentYear - this.year) < 1) {
			return this.mileage;
		}
		else if((currentYear-this.year) >= 1) {
			double averageMile = mileage /(currentYear -this.year);
			return averageMile;
		}	
		
        return 0.0; // dummy return
	}
	
	/**
	 * EXERCISE: #4
	 * 
	 * Returns true if the target MotorVehicle is still under warranty.
	 * A MotorVehicle is still under warranty if it has NOT surpassed
	 * the warranty years NOR the warranty mileage
public class MotorVehicle {

}

	 */
	public boolean underWarranty(int currentYear) {
		// TODO -- YOUR CODE HERE
		int time =  this.year + this.warrantyYears;
		if (currentYear <= time) {
			return true;
		}
		else
        return false; // dummy return
	}
	
	
	/**
	 * EXERCISE: #5
	 * 
	 * Returns true if the target MotorVehicle is older than two years,
	 * hence needs to be inspected. 
	 */
	public boolean needsInspection(int currentYear) {
		// TODO -- YOUR CODE HERE
		if((currentYear - this.year) > 2) {
			return true;			
		}
		else
			return false; // dummy return

	}
	
	/**
	 * EXERCISE: #6
	 * 
	 * Returns the monetary value of the car which is given by the following:
	 * The difference between the warranty mileage and current mileage (If the 
	 * difference is negative default it to 0) to the power of the division of
	
	 * the year the warranty ends by the current year.
	 * There can't be negative value here.
	 *
	 * HINT: The Math class methods pow and/or max can be of help.
	 *
	 */
	public double getMotorVehicleValue(double currentYear) {
		// TODO -- YOUR CODE HERE
		double value = this.warrantyMileage - this.mileage;
		double division = (this.warrantyYears + this.year) / currentYear;
		if(value >= 0) {
			return Math.pow(value, division);

		}
		else{
			return 0.0;
		}
		
		
		
		//return 0.0 ; // dummy return
	}
}