package EXAMEN01;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class WalletTest {

	private Wallet zeroAll;
	private Wallet oneOfEach;
	private Wallet twoOfEach;
	private Wallet allOneHundred;
	private Wallet wallet1;
	private Wallet wallet2;
	private Wallet wallet3;

	@Before
	public void setUp() {
		zeroAll = new Wallet(0,0,0,0,0);
		oneOfEach = new Wallet(1,1,1,1,1); // $176
		twoOfEach = new Wallet(2,2,2,2,2); // $322
		allOneHundred = new Wallet(100,20,5,2,1); // $500
		wallet1 = new Wallet(4, 1, 1, 3, 2); 
		wallet2 = new Wallet(3, 1, 0, 2, 2); 
		wallet3 = new Wallet(4,3,1,1,239);
	}
	
	@Test
	public void testCopyConstructor() {
		Wallet newZero = new Wallet(zeroAll);
		assertEquals(newZero, zeroAll);
		Wallet newAllHundred = new Wallet(allOneHundred);
		assertEquals(newAllHundred, allOneHundred);
		Wallet newWallet = new Wallet(wallet3);
		assertEquals(newWallet, wallet3);
	}


	@Test
	public void testAmountConstructor() {
		Wallet newZero = new Wallet(0);
		assertEquals(newZero, zeroAll);
		Wallet hundredSeventySix = new Wallet(176);
		assertEquals(hundredSeventySix, oneOfEach);
		Wallet highNumber = new Wallet(23989);
		assertEquals(highNumber, wallet3);
	}

	@Test
	public void testGetAmount() {
		assertEquals(0, zeroAll.getAmount()); 
		assertEquals(176, oneOfEach.getAmount()); 
		assertEquals(500, allOneHundred.getAmount()); 
		assertEquals(379, wallet1.getAmount()); 
		assertEquals(23989, wallet3.getAmount()); 
	}

	@Test
	public void testAddWallet() {
		assertTrue(zeroAll == zeroAll.add(zeroAll));
		assertEquals(zeroAll,zeroAll.add(zeroAll));
		assertEquals(oneOfEach,new Wallet(zeroAll).add(oneOfEach));
		assertEquals(oneOfEach,new Wallet(oneOfEach).add(zeroAll));
		assertEquals(twoOfEach,new Wallet(oneOfEach).add(oneOfEach));
		assertEquals(new Wallet(7, 2, 1, 5, 4),new Wallet(wallet1).add(wallet2));

	}
	
	@Test 
	public void testCanPayBill() {
		assertTrue(zeroAll.canPayBill(0));
		assertFalse(zeroAll.canPayBill(1));
		assertTrue(oneOfEach.canPayBill(100));
		assertTrue(oneOfEach.canPayBill(175));
		assertTrue(oneOfEach.canPayBill(176));
		assertFalse(oneOfEach.canPayBill(177));
		assertTrue(wallet3.canPayBill(23989));
		assertFalse(wallet3.canPayBill(26355));
	}
	
	@Test
	public void testAverageBill() {
		assertEquals(0, zeroAll.averageBills());
		assertEquals(1, oneOfEach.averageBills());
		assertEquals(2, wallet1.averageBills());
		assertEquals(49, wallet3.averageBills());
	}
}