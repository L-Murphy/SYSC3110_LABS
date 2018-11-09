public class BuddyInfo {

	private String name;
	private String address;
	private String number;
	private int age;
	
	public BuddyInfo(String name, String address, String number, int age) {
		this.name = name;
		this.address = address;
		this.number = number;
		this.age = age;
	}
	
	public BuddyInfo(BuddyInfo b) {
		this(b.getName(), b.getAddress(), b.getNumber(), b.getAge());
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public String toString() {
		return (this.name+ ": " + this.address + ", " + this.number);
	}
	
	public String greeting() {
		return "Greetings " + this.name;
	}

	public boolean isOver18() {
		return this.age > 18;
	}
}
