import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestBuddyInfo {
	private BuddyInfo buddy;
	@Before
	public void setUp() throws Exception {
		buddy = new BuddyInfo("Liam", "123 First Avenue", "613 555 2525", 20);
	}

	@After
	public void tearDown() throws Exception {
		buddy = null;
	}

	@Test
	public void testGetMethods() {
		assertEquals("Liam", buddy.getName());
		assertEquals("123 First Avenue", buddy.getAddress());
		assertEquals("613 555 2525", buddy.getNumber());
		assertEquals(20, buddy.getAge());
	}
	
	@Test
	public void testSetMethods() {
		buddy.setName("Matthew");
		assertEquals("Matthew", buddy.getName());
		buddy.setAddress("123 New York Ave");
		assertEquals("123 New York Ave", buddy.getAddress());
		buddy.setNumber("614 553 4646");
		assertEquals("614 553 4646", buddy.getNumber());
		buddy.setAge(15);
		assertEquals(15, buddy.getAge());
	}
	
	@Test
	public void testConstructorChain() {
		BuddyInfo temp = new BuddyInfo(buddy);
		assertEquals("Liam", temp.getName());
		assertEquals("123 First Avenue", temp.getAddress());
		assertEquals("613 555 2525", temp.getNumber());
		assertEquals(20, temp.getAge());
	}
	
	@Test
	public void testToStringMethods() {
		assertEquals(buddy.getName()+ ": " + buddy.getAddress() + ", " + buddy.getNumber(), buddy.toString());
		assertEquals("Greetings " + buddy.getName(), buddy.greeting());
	}
	
	@Test
	public void testAge18() {
		buddy.setAge(10);
		assertEquals(10, buddy.getAge());
		assertFalse(buddy.isOver18());
	}

}
