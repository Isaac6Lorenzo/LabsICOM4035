import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class LoopsAndArraysB {

	public static class Trooper implements Comparable<Trooper>{

		//Enumerated type for an officer's ranking from lowest to highest
		public enum Rank {CADET, TROOPER, SERGEANT, LIEUTENANT, CAPTAIN, MAJOR, COLONEL};

		private String nickName; // officer's nickName
		private Rank rank;       // officer's ranking (see enum)
		private int hours;       // officer's accumulated flight hours

		public Trooper(String nickName, Rank rank, int hours) {
			super();
			this.nickName = nickName;
			this.rank = rank;
			this.hours = hours;
		}

		@Override
		public String toString() {
			return "Trooper [nickName=" + nickName + ", rank=" + rank + ", hours=" + hours + "]";
		}

		public String getNickName() { return nickName; }
		public Rank getRank() {	return rank; }
		public int getHours() {	return hours;}

		public void setNickName(String nickName) {this.nickName = nickName;}
		public void setRank(Rank rank) { this.rank = rank; }
		public void setHours(int hours) { this.hours = hours; }


		//Equals method for comparing if another object is the same as this instance
		@Override
		public boolean equals(Object obj) {
			if(!(obj instanceof Trooper))
				return false;
			Trooper other = (Trooper) obj;
			return this.getNickName() == other.getNickName() &&
					this.getRank() == other.getRank() &&
					this.getHours() == other.getHours();
		}

		/**
		 * The compareTo method based on RANK that return 0 if RANKS are equal,
		 * positive if target instance is bigger and negative if the parameter is bigger.
		 */
		@Override
		public int compareTo(Trooper otherTrooper) {
			return this.getRank().ordinal() - otherTrooper.getRank().ordinal();
		}


		/**
		 * Exercise #1
		 * Determines if there is a Trooper with a lower ranking in the parameter squad.
		 * Hint: Use the compareTo Method.
		 * You should end Method as soon as the answer is known.
		 * @param squad
		 * @return
		 */
		public boolean lowerRankExists(Trooper[] squad) {
			// TODO ADD YOUR CODE HERE


			for(int i=0; i<squad.length; i++) {
				if(this.getRank().compareTo(squad[i].getRank()) > 0) {
					return true;
				}
			}

			return false;
		}



		/**
		 * Exercise #2
		 * Searches for the Trooper with the lowest ranking in the squad.
		 * Hint: Use the compareTo Method.
		 * @param squad
		 * @return
		 */
		public static Trooper findMinSeniority (Trooper[] squad) {
			// TODO ADD YOUR CODE HERE


			if (squad.length == 0) {
				return null;
			}
			Trooper min = squad[0];
			for (int i = 1; i < squad.length; i++) {
				if (squad[i].getRank().compareTo(min.getRank()) < 0) {
					min = squad[i];
				}
			}


			return min; // Dummy return
		}

		//		public static Trooper findMinSeniority(Trooper[] squad) {
		//			// TODO ADD YOUR CODE HERE
		//			Trooper min = squad[0];
		//			for (int i = 0; i < squad.length; i++) {
		//				for (int j = 1; j < squad.length; j++) {
		//					if (squad[i].getRank().compareTo(squad[j].getRank()) > 0) {
		//						min = squad[j];
		//					}
		//					else
		//						min = squad[i];
		//				}
		//			}
		//
		//			return min; // Dummy return
		//		}



		/**
		 * Exercise #3
		 * Returns the average of the number of flight time hours of all Troopers in the squad.
		 * Hint: Avoid division by zero.
		 * @param squad
		 * @return
		 */
		public static double squadsAvgFlightHrs(Trooper[] squad) {
			// TODO ADD YOUR CODE HERE
			double sum =0;
			double total=0;
			double size = squad.length;

			if(size == 0) return 0;

			for (int i = 0; i < squad.length; i++) {
				sum += squad[i].getHours();
			}
			total = sum / size;
			return total; //Dummy return
		}


		/**
		 * Exercise #4
		 * A method that returns a new array with the INTERSECTION between 2 squads
		 * You may assume the arrays have unique elements.
		 * Restriction: You can't use collections. Any nulls should be at the end.
		 * Hint: The new array should not be longer than the sum of the parameters arrays.
		 * @param squad1
		 * @param squad2
		 * @return
		 */
		public static Trooper[] intersectionOfSquads(Trooper[] squad1, Trooper[] squad2) {
			// TODO ADD YOUR CODE HERE
			if(squad1.length ==0 && squad2.length ==0) {
				squad1 = new Trooper[] {};
				return squad1;
			}
			
			else if(squad1.length >0 || squad2.length == 0 )
				return new Trooper[] {};
			
			else if(squad1.length == 0 || squad2.length > 0 )
				return new Trooper[] {};
			
			else if(squad2.length ==0) {
				return squad1;
				
			}
//			Trooper[] newTropper = new Trooper[squad1.length];
//			for(Trooper p: squad1) {
//				for(int i=0; i<squad2.length; i++) {
//					if(!squad2[i].equals(p))
//						newTropper[i] = (p);
//				}
//			}
//
//			for(Trooper p: squad2) {
//				for(int i=0; i<squad1.length; i++) {
//					if(!squad1[i].equals(p))
//						newTropper[i] = (p);
//				}
//			}
//			
//			for(int i=0; i< newTropper.length; i++) {
//				if(newTropper[i] == null) {
//					Trooper temp = newTropper[i];
//					newTropper[i] = newTropper[i+1]; 
//					newTropper[i+1] = temp;
//				}
//			}
			HashSet<Trooper> S1 = new HashSet<Trooper>();
			HashSet<Trooper> S2 = new HashSet<Trooper>();
			for (int i = 0; i < squad1.length; i++) {
				S1.add(squad1[i]);
			}
			for (int i = 0; i < squad2.length; i++) {
				S2.add(squad2[i]);
			}
			Set<Trooper> S3 = new HashSet<Trooper>();
			
			for (Trooper obj : S1){
				if (!S2.contains(obj))
					S3.add(obj);
			}
			for (Trooper obj : S2){
				if (!S1.contains(obj))
					S3.add(obj);
			}

			Trooper[] newT = new Trooper[1];
			Iterator it = S3.iterator();
			int i =0;
			while(it.hasNext()) {
				Trooper t = (Trooper) it.next();
				newT[i] = t;
				i++;
			}
			
			return newT; // Dummy return

		}
	}
}