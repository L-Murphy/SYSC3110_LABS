/** SYSC 2101 - Prof-Student-TA Example
 * 
 *
 */

import java.util.Date;
import java.util.Observer;
import java.util.Observable;

public class Student implements Observer{
	private String name;
	private Date midterm;

	public void update(Observable o, Object arg) {
		Prof p = (Prof)o;  //cast o as type Prof
		if((int)arg == 0 ) {  //if the argument is 0 then setMidterm was called
			this.study(p.getMidterm());
		}
		else { //else postponed midterm
			this.party(p.getMidterm());
		}
	
	}
	public Student(String aName) {
		super();
		this.name = aName;
	}

	public String getName() {
		return this.name;
	}

	public void study(Date date){
		this.midterm = date;
		System.out.println(name + " : Doh! I have to study hard for my midterm on " + this.midterm);
	}
	
	public void party(Date date){
		this.midterm = date;
		System.out.println(name + " : Alright! I get to party since my midterm isn't until " + this.midterm);
	}
}
