import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class CollectionsB {

	public enum Gender {MALE, FEMALE, OTHER}
	public enum Team {UPRM, UPRB, UPRA, UPRP, UPRC}

	public static class Player {
		private int number;    // player's uniform jersey number
		private String firstName;
		private String lastName;
		private Gender gender;
		private int level;    // represents level of expertise ... like a batting average
		private Team team;

		public Player(int number, String firstName, String lastName, Gender gender, int level, Team major) {
			this.number = number;
			this.firstName = firstName;
			this.lastName = lastName;
			this.gender = gender;
			this.level = level;
			this.team = major;
		}

		public int getNumber() { return number; }
		public String getFirstName() { return firstName; }
		public String getLastName() { return lastName; }		
		public Gender getGender() { return gender; }
		public double getLevel() { return level; }
		public Team getTeam() { return team; }

		public boolean equals(Object o) {
			if (o instanceof Player) {
				Player p = (Player) o;
				return (p.getNumber() == this.getNumber());
			}
			return false;
		}

		@Override 
		public int hashCode() { return this.number; }
	}

	/**
	 * EXERCICE #1
	 * A method that returns all players from (UPRM & UPRB) that can apply for extra training.
	 * A player is candidate for free extra training if their level is equal or less than 285.
	 * Hint: HashSet methods might be helpful, see the API.
	 * @param p
	 * @return
	 */
	public static Set<Player> getTrainingCandidates(Set<Player> p) {
		//		Set<Player> result = new HashSet<Player>();
		// TODO YOUR CODE HERE
		//		Player[] newArray = (Player[]) p.toArray();

		//		int count = 0;
		//		for (int i = 0; i < newArray.length; i++) {
		//			if ((newArray[i].getTeam() == Team.UPRM || newArray[i].getTeam() == Team.UPRB) && (newArray[i].getLevel() <= 285)) {
		//				count++;
		//			}
		//		}
		//		
		//		Player[] newArray2 = new Player[count];
		//		for (int j = 0; j < newArray.length; j++) {
		//			if ((newArray[j].getTeam() == Team.UPRM || newArray[j].getTeam() == Team.UPRB) && (newArray[j].getLevel() <= 285)) {
		//				for (int k = 0; k < newArray2.length; k++) {
		//					newArray2[k] = newArray[j];
		//				}
		//			}
		//		}

		//		List<Player> newList = Arrays.asList(newArray2);
		////		result = (HashSet<Player>) newList;
		
		//15 de mayo 2020
		HashSet<Player> HS = new HashSet<Player>();

		Iterator it = p.iterator();
		while(it.hasNext()) {
			Player player = (Player) it.next();
			if(player.getTeam() == Team.UPRM || player.getTeam() == Team.UPRB)
				if(player.getLevel() <= 285)
					HS.add(player);
		}
		
		Set<Player> result = new HashSet<Player>();
		Iterator<Player> it2 = HS.iterator();
		while(it2.hasNext()) {
			Player player = (Player) it2.next();
			result.add(player);
		}

		return result; // Dummy return

	}

	/**
	 * EXERCISE #2
	 * A method that returns a NEW set with the DIFFERENCE of two other sets of Players.
	 * The set difference A - B consists of the set of all elements in set A that are not in set B.
	 * Ex. If p1 = {1, 2, 3, 4} and p2 = {3, 4, 5, 6} the difference is {1, 2}.
	 * Hint: HashSet methods might be helpful, see the API.
	 * @param p1
	 * @param p2
	 * @return
	 */
	public static Set<Player> getDifference(Set<Player> p1, Set<Player> p2) {
		Set<Player> result = new HashSet<Player>(p1);
		// TODO YOUR CODE HERE
		for(Player p: p1) {
			if(!p2.contains(p))
				result.add(p);
		}
		return result; // Dummy return
	}


	/**
	 * EXERCISE #3
	 * A method that takes a collection of players and returns a map with
	 * the count of each gender (see enum Gender).
	 * @param players
	 * @return
	 */
	public static Map<Gender, Integer> genderCount(Collection<Player> players) {
		Map<Gender, Integer> result = new HashMap<Gender, Integer>();
		// TODO YOUR CODE HERE
		Integer countM = 0;
		Integer countF = 0;
		Integer countOther = 0;

		for (Player player : players) {
			if (player.getGender() == Gender.MALE) {
				countM++;
			}
			if (player.getGender() == Gender.FEMALE) {
				countF++;
			}
			if (player.getGender() == Gender.OTHER) {
				countOther++;
			}
		}
		if(countM ==0 && countF == 0 && countOther == 0)
			//			result.clear();
			return result;

		result.put(Gender.MALE, countM);
		result.put(Gender.FEMALE, countF);
		result.put(Gender.OTHER, countOther);

		return result; // Dummy return
	}


}