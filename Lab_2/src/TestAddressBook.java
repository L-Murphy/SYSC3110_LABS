import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestAddressBook {
	private AddressBook book;
	private BuddyInfo budOne;
	private BuddyInfo budTwo;
	@Before
	public void setUp() throws Exception {
		this.book = new AddressBook();
		this.budOne = new BuddyInfo("Liam", "123 First Avenue", "613 555 2525", 20);
		this.budTwo = new BuddyInfo("Matthew", "123 Second Street", "613 545 4555", 25);
	}

	@After
	public void tearDown() throws Exception {
		book = null;
	}

	@Test
	public void testAddingToBook() {
		assertEquals(0, book.size());
		book.addBuddy(budOne);
		assertEquals(1, book.size());
		book.addBuddy(budTwo);
		assertEquals(2, book.size());
	}
	@Test
	public void testRemoval() {
		book.addBuddy(budOne);
		book.addBuddy(budTwo);
		book.removeBuddy(budOne);
		assertEquals(1, book.size());
	}
	
	@Test
	public void testClear() {
		assertEquals(0, book.size());
		book.addBuddy(budOne);
		book.addBuddy(budTwo);
		book.clear();
		assertEquals(0, book.size());
	}


}
