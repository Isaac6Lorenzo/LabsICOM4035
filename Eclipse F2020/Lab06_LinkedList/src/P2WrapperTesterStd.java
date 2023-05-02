import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class P2WrapperTesterStd {
	P2Wrapper.List<String> L = null;
	
	@Before
	public void setUp() throws Exception {
		L = new P2Wrapper.SinglyLinkedList<String>();

	}
	
	

	@Test
	public void testCase1() {
		L.clear();
		L.add("Bob");
		L.changeOddEven();
		assertEquals("On L = {Bob}, L.changeOddEven() fails to produce L = {Bob} ", 
				true, L.size() == 1 && L.isMember("Bob"));
	}
	
	@Test
	public void testCase2() {
		L.clear();
		L.add("Bob");
		L.add("Jil");
		L.changeOddEven();
		assertEquals("On L = {Bob, Jil}, L.changeOddEven() fails to produce L = {Bob, Jil} ", 
				true, L.size() == 2 && L.get(1)=="Jil" && L.get(0)=="Bob");
	}

	@Test
	public void testCase3() {
		L.clear();
		L.add("Kim");
		L.add("Bob");
		L.add("Jil");
		L.add("Xi");
		L.add("Joe");
		L.changeOddEven();
		assertEquals("On L = {Kim, Bob, Jil, Xi, Joe}, L.changeOddEven() fails to produce "
				+ "L = {Kim, Jil, Joe, Bob, Xi} ", 
				true, L.size() == 5 && L.get(0)=="Kim" && L.get(1)=="Jil" &&
				L.get(2)=="Joe" && L.get(4)=="Xi" && L.get(3)=="Bob");
	}
	
	@Test
	public void testCase4() {
		L.clear();
		L.add("Bob");
		L.add("Ned");
		L.add("Jil");
		L.add("Amy");
		L.add("Kim");
		L.changeOddEven();
		assertEquals("On L = {Bob, Ned, Jil, Amy, Kim}, L.changeOddEven() fails to produce "
				+ "L = {Bob, Jil, Kim, Ned, Amy} ", 
				true, L.size() == 5 && L.get(2)=="Kim" && L.get(1)=="Jil" &&
				L.get(3)=="Ned" && L.get(4)=="Amy" && L.get(0)=="Bob");
	}
	
	
}