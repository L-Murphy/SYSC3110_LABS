import java.util.ArrayList;

public class AddressBook {
	private ArrayList<BuddyInfo> book;
	
	public AddressBook() {
		book = new ArrayList<BuddyInfo>();
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
	
	public ArrayList<BuddyInfo> getBuddyList(){
		return book;
	}
	
	public int size() {
		return book.size();
	}
	
	public void clear() {
		while(size() != 0) {
			book.remove(0);
		}
	}
}
	

