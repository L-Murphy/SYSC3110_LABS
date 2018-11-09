/** SYSC 2101 - Prof-Student-TA Example
 * 
 *
 */

import java.util.Date;
import java.util.Observer;
import java.util.Observable;

public class TeachingAssistant implements Observer {
	private String name;
	private Date midterm;

	@Override
	public void update(Observable o, Object arg) {
		Prof p = (Prof)o;
		if((int)arg == 0 ) { 
			this.proctor(p.getMidterm());
		}
		else {
			this.postpone(p.getMidterm());
		}
	}
	
	public TeachingAssistant(String aName) {
		super();
		this.name = aName;
	}

	public String getName() {
		return this.name;
	}

	public void proctor(Date date){
		this.midterm = date;
		System.out.println(name + " : I have to proctor a midterm on " + this.midterm);
	}
	
	public void postpone(Date date){
		this.midterm = date;
		System.out.println(name + " : Now the midterm is on " + this.midterm);
	}
}
