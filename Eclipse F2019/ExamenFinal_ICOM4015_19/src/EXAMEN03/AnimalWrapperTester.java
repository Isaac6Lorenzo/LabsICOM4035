package EXAMEN03;import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class AnimalWrapperTester {
	AnimalWrapper.Animal[] allAnimals;
	AnimalWrapper.Animal[] insects;
	AnimalWrapper.Animal[] cats;

	@Before
	public void setUp() {

		allAnimals = new AnimalWrapper.Animal[10];
		allAnimals[0] = new AnimalWrapper.Cat("lion", AnimalWrapper.Type.LAND, AnimalWrapper.Feed.CARNIVORE, 200);
		allAnimals[1] = new AnimalWrapper.Cat("cat", AnimalWrapper.Type.LAND, AnimalWrapper.Feed.CARNIVORE, 10);
		allAnimals[2] = new AnimalWrapper.Cat("leopard", AnimalWrapper.Type.LAND, AnimalWrapper.Feed.CARNIVORE, 150);
		allAnimals[3] = new AnimalWrapper.Cat("tiger", AnimalWrapper.Type.LAND, AnimalWrapper.Feed.CARNIVORE, 300);
		allAnimals[4] = new AnimalWrapper.Cat("lynx", AnimalWrapper.Type.LAND, AnimalWrapper.Feed.CARNIVORE, 100);
		allAnimals[5] = new AnimalWrapper.Insect("spider", AnimalWrapper.Type.INSECT, AnimalWrapper.Feed.CARNIVORE, 0.1f, AnimalWrapper.Insect.WingType.None);
		allAnimals[6] = new AnimalWrapper.Insect("mosquito", AnimalWrapper.Type.INSECT, AnimalWrapper.Feed.CARNIVORE, 0.01f, AnimalWrapper.Insect.WingType.Foldable);
		allAnimals[7] = new AnimalWrapper.Insect("Butterfly", AnimalWrapper.Type.INSECT, AnimalWrapper.Feed.HERBIVORE, 0.2f, AnimalWrapper.Insect.WingType.Unfoldable);
		allAnimals[8] = new AnimalWrapper.Insect("coakroach", AnimalWrapper.Type.INSECT, AnimalWrapper.Feed.OMNIVORE, 0.2f, AnimalWrapper.Insect.WingType.Foldable);
		allAnimals[9] = new AnimalWrapper.Insect("ant", AnimalWrapper.Type.INSECT, AnimalWrapper.Feed.HERBIVORE, 0.001f, AnimalWrapper.Insect.WingType.None);

		cats = new AnimalWrapper.Animal[5];
		cats[0] = new AnimalWrapper.Cat("lion", AnimalWrapper.Type.LAND, AnimalWrapper.Feed.CARNIVORE, 200);
		cats[1] = new AnimalWrapper.Cat("cat", AnimalWrapper.Type.LAND, AnimalWrapper.Feed.CARNIVORE, 10);
		cats[2] = new AnimalWrapper.Cat("leopard", AnimalWrapper.Type.LAND, AnimalWrapper.Feed.CARNIVORE, 150);
		cats[3] = new AnimalWrapper.Cat("tiger", AnimalWrapper.Type.LAND, AnimalWrapper.Feed.CARNIVORE, 300);
		cats[4] = new AnimalWrapper.Cat("lynx", AnimalWrapper.Type.LAND, AnimalWrapper.Feed.CARNIVORE, 100);
		
		insects = new AnimalWrapper.Animal[5];
		insects[0] = new AnimalWrapper.Insect("spider", AnimalWrapper.Type.INSECT, AnimalWrapper.Feed.CARNIVORE, 0.1f, AnimalWrapper.Insect.WingType.None);
		insects[1] = new AnimalWrapper.Insect("mosquito", AnimalWrapper.Type.INSECT, AnimalWrapper.Feed.CARNIVORE, 0.01f, AnimalWrapper.Insect.WingType.Foldable);
		insects[2] = new AnimalWrapper.Insect("Butterfly", AnimalWrapper.Type.INSECT, AnimalWrapper.Feed.HERBIVORE, 0.21f, AnimalWrapper.Insect.WingType.Unfoldable);
		insects[3] = new AnimalWrapper.Insect("coakroach", AnimalWrapper.Type.INSECT, AnimalWrapper.Feed.OMNIVORE, 0.2f, AnimalWrapper.Insect.WingType.Foldable);
		insects[4] = new AnimalWrapper.Insect("ant", AnimalWrapper.Type.INSECT, AnimalWrapper.Feed.HERBIVORE, 0.001f, AnimalWrapper.Insect.WingType.None);
		
	}

	// Test for EX #1
	@Test
	public void testAbstractAnimalClass() {
		AnimalWrapper.Cat lion = new AnimalWrapper.Cat("lion", AnimalWrapper.Type.INSECT, AnimalWrapper.Feed.CARNIVORE, 0);
		AnimalWrapper.Insect mosquito = new AnimalWrapper.Insect("mosquito", AnimalWrapper.Type.INSECT, AnimalWrapper.Feed.CARNIVORE, 0, AnimalWrapper.Insect.WingType.Foldable);
		assertTrue("Cat should be instance of abstract class Book", lion instanceof AnimalWrapper.Animal );
		assertTrue("Insect should be instance of abstract class Book", mosquito instanceof AnimalWrapper.Animal);

		boolean has4Fields = false;    	
		try {
			Class c = Class.forName("AnimalWrapper");
			Class cl[] = c.getDeclaredClasses();
			for(Class cls : cl) {
				if(cls.toString().contains("AnimalWrapper$Animal")) {
					Field[] fields = cls.getDeclaredFields();
					if(fields.length == 4)
						has4Fields = true;
					break;
				}
			}

		} catch (Exception e) {
			fail(e.toString());
		}
		assertTrue("The abstract Animal class should have 4 fields", has4Fields);

	}


	// Test for EX #2
	@Test
	public void testRefactoring() {
		// Check fields were moved to abstract class
		boolean fieldsMoved = true;
		try {
			Class c = Class.forName("AnimalWrapper");
			Class cl[] = c.getDeclaredClasses();
			for(Class cls : cl) {
				if(cls.toString().contains("AnimalWrapper$Cat") ||
						cls.toString().contains("AnimalWrapper$Insect")) {
					Field[] fields = cls.getDeclaredFields();
					for(Field f: fields) {
						if(f.toString().contains("commonName") || f.toString().contains("type") 
								|| f.toString().contains("feed") || f.toString().contains("maxWeight")) {
							fieldsMoved = false;
							break;
						}
					}
				}
			}

		} catch (Exception e) {
			fail(e.toString());
		}
		assertTrue("These clases still contain methods that should be in the abstract class", fieldsMoved);

		// testNumberOfFieldsCorrectForCat
		boolean hasNoFields = true;    	
		try {
			Class c = Class.forName("AnimalWrapper");
			Class cl[] = c.getDeclaredClasses();
			for(Class cls : cl) {
				if(cls.toString().contains("AnimalWrapper$Cat")) {
					Field[] fields = cls.getDeclaredFields();
					if(fields.length > 0)
						hasNoFields = false;
					break;
				}
			}

		} catch (Exception e) {
			fail(e.toString());
		}
		assertTrue("The Cat class should have no field", hasNoFields);

		// testNumberOfFieldsCorrectForInsect
		boolean has2Fields = false;    	
		try {
			Class c = Class.forName("AnimalWrapper");
			Class cl[] = c.getDeclaredClasses();
			for(Class cls : cl) {
				if(cls.toString().contains("AnimalWrapper$Insect")) {
					Field[] fields = cls.getDeclaredFields();
					if(fields.length == 1)
						has2Fields = true;
					break;
				}
			}

		} catch (Exception e) {
			fail(e.toString());
		}
		assertTrue("The Insect class should have 1 field", has2Fields);
	}


	// Test for EX #3
	@Test 
	public void testHasFlyingInterace() {
		boolean hasMethods = false;
		try {
			Class c = Class.forName("AnimalWrapper");
			Class cl[] = c.getDeclaredClasses();
			for(Class cls : cl) {
				if(cls.toString().contains("Flying")) {
					Method[] methods = cls.getDeclaredMethods();
					assertEquals("Flying interface should only contain one method", 1, methods.length);
					for(Method method: methods) {
						if(method.toString().contains("canFly()")) {
							hasMethods = true;
							break;
						}
					}
				}
			}
		} catch (Exception e) {
			fail(e.toString());
		}
		assertTrue("This interface Flying should contain the method canFly", hasMethods);
	}

	// Test for EX #4
	@Test 
	public void testCanFlyMethod() {
		// test Insect Implements canFly Method
		boolean hasMethod = false;    	
		try {
			Class c = Class.forName("AnimalWrapper");
			Class cl[] = c.getDeclaredClasses();
			for(Class cls : cl) {
				if(cls.toString().contains("AnimalWrapper$Animal")) {
					Method[] methods = cls.getDeclaredMethods();
					for(Method m : methods) {
						if(m.toString().contains("canFly"))
							hasMethod = true;
					}
					break;
				}
			}
		} catch (Exception e) {
			fail(e.toString());
		}
		assertTrue("The class Insect is missing implementation canFly()",hasMethod);

		assertFalse("Incorrect Animal canFly", allAnimals[0].canFly());
		assertFalse("Incorrect Animal canFly", allAnimals[2].canFly());
		assertFalse("Incorrect Animal canFly", allAnimals[3].canFly());
		assertTrue("Incorrect Animal canFly", insects[3].canFly());

	}

	// Test for EX #5
	@Test 
	public void testNewAbstractMethod() {
		//test Book Has Abstract Method PageCount
		boolean hasAbstractMethod = false;    	
		try {
			Class c = Class.forName("AnimalWrapper");
			Class cl[] = c.getDeclaredClasses();
			for(Class cls : cl) {
				if(cls.toString().contains("AnimalWrapper$Animal")) {
					Method method = cls.getMethod("getFullName");
					if(method.toString().contains("getFullName()"))
						hasAbstractMethod = true;
					break;
				}
			}

		} catch (Exception e) {
			fail(e.toString());
		}
		assertTrue("The class Animal is missing a abstract method pageCount()",hasAbstractMethod);

		// test Insect Implements Abstract getFullName Method
		boolean hasMethod = false;    	
		try {
			Class c = Class.forName("AnimalWrapper");
			Class cl[] = c.getDeclaredClasses();
			for(Class cls : cl) {
				if(cls.toString().contains("AnimalWrapper$Insect")) {
					Method[] methods = cls.getDeclaredMethods();
					for(Method m : methods) {
						if(m.toString().contains("getFullName()"))
							hasMethod = true;
					}
					break;
				}
			}

		} catch (Exception e) {
			fail(e.toString());
		}
		assertTrue("The class Insect is missing implementation getFullName()",hasMethod);


		// test Cat Implements Abstract PageCount Method
		hasMethod = false;    	
		try {
			Class c = Class.forName("AnimalWrapper");
			Class cl[] = c.getDeclaredClasses();
			for(Class cls : cl) {
				if(cls.toString().contains("AnimalWrapper$Cat")) {
					Method[] methods = cls.getDeclaredMethods();
					for(Method m : methods) {
						if(m.toString().contains("getFullName()"))
							hasMethod = true;
					}
					break;
				}
			}

		} catch (Exception e) {
			fail(e.toString());
		}
		assertTrue("The class Cat is missing implementation getFullName()",hasMethod);   	

	}	



	// Test for EX #6
	@Test
	public void testImplementComparable(){

		// test Animal Implements Comparable Method
		Boolean hasMethod = false;    	
		try {
			Class c = Class.forName("AnimalWrapper");
			Class cl[] = c.getDeclaredClasses();
			for(Class cls : cl) {
				if(cls.toString().contains("AnimalWrapper$Animal")) {
					Method[] methods = cls.getDeclaredMethods();
					for(Method m : methods) {
						if(m.toString().contains("compareTo"))
							hasMethod = true;
					}
					break;
				}
			}

		} catch (Exception e) {
			fail(e.toString());
		}
		assertTrue("The class Cat is missing compareTo method",hasMethod);       	

		// tests comparisons
		assertTrue("target is larger than other, should be > 0", allAnimals[2].compareTo(allAnimals[0]) < 0);
		assertTrue("target is smaller than other, should be < 0", allAnimals[0].compareTo(allAnimals[2]) > 0);
		assertTrue("target is smaller than other, should be < 0", allAnimals[6].compareTo(allAnimals[7]) > 0);
		assertTrue("target is smaller than other, should be < 0", allAnimals[7].compareTo(allAnimals[6]) < 0);
		assertTrue("target is smaller than other, should be 0", allAnimals[4].compareTo(allAnimals[4]) == 0);
	}

	@Rule
	public final ExpectedException exception = ExpectedException.none();

	// Test for EX #7    
	@Test
	public void testFindHeaviestAnimalMethod(){
		assertEquals("Heaviest animal is incorrect",3 , AnimalWrapper.Animal.findHeaviest(allAnimals));
		//library.get(0).setYear(1919);
		assertEquals("Heaviest animal is incorrect",2 , AnimalWrapper.Animal.findHeaviest(insects)); 
		//library.get(5).setYear(1019);
		assertEquals("Heaviest animal is incorrect",3 , AnimalWrapper.Animal.findHeaviest(cats)); 
		// Add 100,000 Insects to library to cause stack overflow
		AnimalWrapper.Animal[] bigAnimals= new AnimalWrapper.Insect[100000];
		for (int i = 0; i < 100000; i++) {
			bigAnimals[i] = new AnimalWrapper.Insect("dummy", AnimalWrapper.Type.INSECT, AnimalWrapper.Feed.CARNIVORE, 0, AnimalWrapper.Insect.WingType.None);
		}
		exception.expect(StackOverflowError.class);
		assertEquals("StackOverflowError was expected", 1975, 
				AnimalWrapper.Insect.findHeaviest(bigAnimals));
	}


	// Test for EX #8
	@Test
	public void testExistsTypeMethod(){
		assertTrue("Land exists",AnimalWrapper.Animal.existType(allAnimals, AnimalWrapper.Type.LAND));
		assertTrue("Insect exists",AnimalWrapper.Animal.existType(allAnimals, AnimalWrapper.Type.INSECT));
		assertFalse("Bird does not exist",AnimalWrapper.Animal.existType(allAnimals, AnimalWrapper.Type.BIRD));
		assertFalse("Reptile does not exist",AnimalWrapper.Animal.existType(allAnimals, AnimalWrapper.Type.REPTILE));
		assertFalse("Water does not exist",AnimalWrapper.Animal.existType(allAnimals, AnimalWrapper.Type.WATER));

		// Add 500,000 to library to cause stack overflow
		AnimalWrapper.Cat[] muchosanimals = new AnimalWrapper.Cat[500000];
		for (int i = 0; i < muchosanimals.length; i++) {
			muchosanimals[i] = new AnimalWrapper.Cat("", AnimalWrapper.Type.INSECT, AnimalWrapper.Feed.CARNIVORE, 0);
		}
		exception.expect(StackOverflowError.class);
		assertTrue("StackOverflowError was expected",
				AnimalWrapper.Cat.existType(muchosanimals, AnimalWrapper.Type.BIRD));	
	}	

}