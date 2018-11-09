import java.util.LinkedList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

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
	
	public void export() {
		String bookString = "";
		for(BuddyInfo b : book) {
			bookString += b.toString() + "";
		}
		BufferedWriter out;
		try {
			out = new BufferedWriter(new FileWriter("address.txt"));
			out.write(bookString);
			out.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
	

