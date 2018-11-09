import java.util.LinkedList;

public class AddressBook {
	private LinkedList<BuddyInfo> book;
	
	public AddressBook() {
		book = new LinkedList<BuddyInfo>();
	}


	public void addBuddy(BuddyInfo Buddy){
		if(Buddy != null) {
			book.add(Buddy);	
		}
	}
	
	public void removeBuddy(BuddyInfo Buddy) {
		if(book.contains(Buddy)) {
			book.remove(Buddy);
		}
		else {
			System.out.print("Buddy does not exist");
		}
	}
	
	public LinkedList<BuddyInfo> getBuddyList(){
		return book;
	}
	
	public void masterLiam() {
		System.out.println("Liam is the master of the universe!");
	}
	/*
	public static void main(String args[]) {
		System.out.println("Address Book");
		BuddyInfo aBud = new BuddyInfo("Matt", "Kemptville", 613555);
		AddressBook aBook = new AddressBook();
		aBook.addBuddy(aBud);
		aBook.removeBuddy(aBud);
		System.out.println("Hello World I have a friend!");
	}*/
}
	

