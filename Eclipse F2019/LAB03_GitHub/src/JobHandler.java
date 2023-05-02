public class JobHandler {
	
	/**
	 * A method that returns the salary bonus for an employee.
	 * The bonus is determined by the user's current salary
	 * and their current seniority:
	 * 1. According to the seniority the following is the determined bonus:
	 * 		a) If the seniority is of 1:
	 * 			- The bonus is 0.5% of their salary, plus 200.
	 * 		b) If the seniority is of 2:
	 * 			- The bonus is 1% of their salary, plus 150.
	 * 		c) If the seniority is of 3:
	 * 			- The bonus is 5% of their salary, plus 100.
	 * 		d) Otherwise:
	 * 			- The bonus is 0.1% of their salary 300 .
	 * 
	 * @param seniority
	 * @param yearlySalary 
	 * @return bonus
	 */
	public static int salaryBonus(int seniority, double yearlySalary) {
		double bonus = (0.1/100);
		// Use switch statement
		// Hint: Modify bonus
		
		switch(seniority) {
		case 1:
			bonus = ((bonus * 5) * yearlySalary) + 200;
			break;
			
		case 2:
			bonus = ((bonus * 10) * yearlySalary) + 150;
			break;
			
		case 3:
			bonus = ((bonus * 50) * yearlySalary) + 100;
			break;
			
		default:
			bonus = ((bonus) * yearlySalary) + 300;
			break;
		}
		
		
		
		
		
		return (int) bonus;
	}
	
	/**
	 * A method that helps determine if an employee qualifies for a job.
	 * To determine if the employee qualifies we need to meet the following requirements:
	 * 1. The employee's rank must be higher than 0
	 * 2. To know if an employee qualify,
	 *    simply check if the employee rank is higher or equal to the job's rank
	 * 		a) If the user has a seniority of 1, the user gains a 5 rank bonus
	 * 		b) If the user has a seniority of 2, the user gains a 10 rank bonus
	 * 		c) If the user has a seniority of 3, the user gains a 20 rank bonus
	 * 		b) Otherwise there is a bonus of 1.
	 * 
	 * @param jobRank
	 * @param personRank
	 * @param seniority
	 * @return
	 */
	public static boolean promotionQualify(int jobRank, int eRank, int seniority) {
		if(eRank <= 0) { return false;}
		
		// Use switch statement
		// Hint: Modify eRank
//		if (eRank >= jobRank) {
			switch(seniority) {
			case 1:
				eRank+=5;
				break;
				
			case 2:
				eRank+=10;
				break;
				
			case 3:
				eRank+=20;
				break;
				
			default:
				eRank+=1;
				break;
			}
//		}
		
		return eRank >= jobRank;
	}
}