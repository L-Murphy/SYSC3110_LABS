import java.util.Scanner;

public class BuddyInfo {

	private  String name;
	private  String adress;
	private  String number;
	
	public BuddyInfo(String name, String adress, String number) {
		this.name = name;
		this.adress = adress;
		this.number = number;
	}


	public String getName() {
		return this.name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAdress() {
		return adress;
	}


	public void setAdress(String adress) {
		this.adress = adress;
	}


	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}
	
	public String toString() {
		return ("\n" + this.name+ "$" + this.adress + "$" + this.number);
		
	}
	
	public static BuddyInfo importBud(String bud) {
		//Scanner scanner = new Scanner(bud);
		if(bud != null) {
			String[] arr = bud.split("$");
			return new BuddyInfo(arr[0], arr[1], arr[2]);	
		}
		return null;
	}

}
