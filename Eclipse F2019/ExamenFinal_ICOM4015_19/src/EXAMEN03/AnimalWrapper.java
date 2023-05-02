package EXAMEN03;
/**
 * Wrapper class used to enclose all classes as static nested classes.
 * These classes would normally be top-level classes, but are enclosed
 * for compatibility with the Moodle JUnit plugin.
 */

public class AnimalWrapper {

	public enum Type { WATER, REPTILE, BIRD, LAND, INSECT }
	public enum Feed { CARNIVORE, HERBIVORE, OMNIVORE}


	public static abstract class Animal implements Comparable<Animal>, Flying {

		/** EXERCISE #1 -- ADD ABSTRACT Animal CLASS
		 * 
		 * Re-factor Insect and Cat classes.
		 * An abstract class that holds the properties and implements the methods that are
		 * common to existing Insect and Cat classes. All the moved properties must remain 
		 * PRIVATE and the moved methods PUBLIC. A method that is different in the subclasses
		 * should be an abstract method in this abstract class and then overridden, unless
		 * such method behaves equally in both subclasses.
		 * 
		 * The abstract class should supply an appropriate constructor to be used by 
		 * subclass constructors to initialize the private properties defined in the abstract class.
		 */
		// ADD YOUR CODE HERE
		// Common Methods and Properties for Insect and Cat classes
		public String CommonName;
		public Type type;
		public Feed feed;
		public float maxWeight;


		public Animal(String commonName, Type type, Feed feed,  float maxWeight) {
			setCommonName(commonName);
			setType(type);
			setFeed(feed);
			setMaxWeight(maxWeight);
		}
		public abstract String getCommonName();
		public abstract Type getType();
		public abstract Feed getFeed();
		public abstract float getMaxWeight(); 
		

		public abstract void setCommonName(String CommonName); 
		public abstract void setType(Type type); 
		public abstract void setFeed(Feed feed); 
		public abstract void setMaxWeight(Float weight); 

		
		/** EXERCISE #8 IMPLEMENT SEARCH RECURSIVE METHOD
		 * 
		 *  RECURSIVELY returns true if and only if some animal of the specified (enum) Type 
		 *  exists in the given array of Animals
		 */
		public static boolean existType(Animal[] animals, Type type) {
			return existType(animals, type, 0, animals.length-1);
		}
		// TODO Complete the following helper method
		public static boolean existType(Animal[] animals, Type type, int start, int end) {
//			if(animals.length == 0) {
//				return false;
//			}
//			
//			//ADD YOUR CODE HERE
//			for (int i = start; i < end; i++) {
//				if (animals[i].getType() == type) {
//					System.out.println("true");
//					return true;
//					
//				}
//			}
		//	existType(animals, type);
			return false; //Dummy return
		}

		/** EXERCISE #7 IMPLEMENT MAX RECURSIVE METHOD
		 * 
		 *  This method finds the heaviest Animal in an array of Animals.
		 * 
		 *  The method MUST BE RECURSIVE
		 */
		public static int findHeaviest(Animal[] myAnimals) {
			return findHeaviest(myAnimals, 0, myAnimals.length);	
		}

		public static int findHeaviest(Animal[] myAnimals, int start, int end) {
			float maxWeight = myAnimals[0].getMaxWeight();
			int count =0;
		//	start = end -1;
			//ADD YOUR CODE HERE
//			if(end == myAnimals.length ) {
//				return end--;
//			}
//			for (int i = start; i < end; i++) {
//				if (myAnimals[i].getMaxWeight() >= maxWeight) {
//					maxWeight = myAnimals[i].getMaxWeight();
//					count++;
//				}
//			}
//			System.out.println(count);
//			findHeaviest(myAnimals);	
			return (int)maxWeight;	// Dummy return
		}
		
		public abstract boolean canFly();
		
		
		/** EXERCISE #5 (Part A) ADD ABSTRACT METHOD getFullName() that returns a String
		 * representing the combination of the commonName with the name of the Animal subclass.
		 * For example the fullName for a lion will be "Cat(lion)"
		 * 
		 *  Each subclass of Building will implement this method
		 */
		// YOUR CODE HERE
		public abstract String getFullName();
		
		/** EXERCISE #6 IMPLEMENT COMPARABLE INTERFACE METHOD in Animal class
		 *
		 * Compares Animals based on commonName in lexicographic (dicionary) order.
		 * 
		 */

		public int compareTo(Animal otherAnimal) {

			// TODO ADD YOUR CODE HERE
			String animalOne = this.getCommonName();
			String animalTwo = otherAnimal.getCommonName();
			int value = animalOne.compareTo(animalTwo);
			return value; // Dummy return
		}        

	}

	/**
	 * Exercise #2 (Part A)
	 * Re-factor this class to remove any property or method that was 
	 * moved to the Abstract Animal class.  You should modify the
	 * constructor to call the super constructor appropriately.
	 * 
	 * This class represents Insects
	 */
	public static class Insect extends Animal {

		public enum WingType { None, Foldable, Unfoldable }
		private WingType wingType;

		public String getCommonName() {return CommonName;}
		public Type getType() {return type;}
		public Feed getFeed() {return feed;}
		public float getMaxWeight() {return maxWeight;}
		public WingType getWingType() { return this.wingType; }

		public void setCommonName(String CommonName) {this.CommonName = CommonName;}
		public void setType(Type type) {this.type = type;	}
		public void setFeed(Feed feed) {this.feed = feed;	}
		public void setMaxWeight(Float weight) {this.maxWeight = weight; }
		public void setWingType(WingType newWingType) {  this.wingType = newWingType; }

		public Insect(String commonName, Type type, Feed feed, float maxWeight, WingType wingType) {
			super(commonName, type, feed, maxWeight);
			this.wingType = wingType;
		}

		/**
		 * EXERCISE #4 (Part A) -- IMPLEMENT NEW CanFly interface in Insect class.
		 *  Insects can fly if they have any type of wing
		 *  
		 */
		public boolean canFly() {
			if(this.getWingType().equals(getWingType().Foldable) || (this.getWingType().equals(getWingType().Unfoldable)) ) {
				return true;
			}
			return false; // Dummy Return}
		}
		

		/** EXERCISE #5 (Part B) ADD ABSTRACT METHOD getFullName() that returns a String to the Insect class
		 * representing the combination of the commonName with the name of the Animal subclass.
		 * For example the fullName for a "butterfly" will be "Insect(butterfly)"
		 * 
		 */
		// YOUR CODE HERE
		@Override
		public String getFullName() {
			// TODO Auto-generated method stub
			return "Insect" + "(" +getCommonName()+")";
		} 
	} 


	/**
	 * Exercise #2 (Part B)
	 * Re-factor this class to remove any property or method that was 
	 * moved to the Abstract Animal class.  You should modify the
	 * constructor to call the super constructor appropriately.
	 * 
	 * This class represents an Cat animal species
	 * 
	 */
	public static class Cat extends Animal {
				
		public String getCommonName() {return CommonName;}
		public Type getType() {return type;}
		public Feed getFeed() {return feed;}
		public float getMaxWeight() {return maxWeight;}

		public void setCommonName(String CommonName) {this.CommonName = CommonName;}
		public void setType(Type type) {this.type = type;	}
		public void setFeed(Feed feed) {this.feed = feed;	}
		public void setMaxWeight(Float weight) {this.maxWeight = weight; }

		public Cat(String commonName, Type type, Feed feed,  float maxWeight) {
			super(commonName, type, feed, maxWeight);
		}

		/** EXERCISE #5 (Part C) ADD ABSTRACT METHOD getFullName() that returns a String to the Cat class
		 * representing the combination of the commonName with the name of the Animal subclass.
		 * For example the fullName for a "lion" will be "Cat(lion)"
		 * 
		 */
		// YOUR CODE HERE
		@Override
		public String getFullName() {

			return "Cat"+ "(" +getCommonName()+")";
		} 

		/**
		 * EXERCISE #4 (Part B) -- IMPLEMENT NEW CanFly interface in Cat class.
		 *
		 * No Cats can fly.
		 */
		public boolean canFly() {			
			return false; // Dummy Return
		}
		
		

	} 


	/** EXERCISE #3 -- DEFINE A NEW Flying INTERFACE 
	 * 
	 * An interface that represents a potentially flying object.
	 * It should contain the method canFly() that returns true if the object can fly.
	 */
	public static interface Flying {
		/**
		 *  A method that returns if the animal can fly
		 */
		public abstract boolean canFly();
	}

}