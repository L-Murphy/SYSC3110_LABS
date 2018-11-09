/** SYSC 2101 - Prof-Student-TA Example
 * 
 *
 */

import java.util.Date;


public class TeachingAssistant implements CourseListener {
	private String name;
	private Date midterm;
	private Date assignment;

	public TeachingAssistant(String aName) {
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
	
	public void mark(Date date) {
		this.assignment = date;
		System.out.println(name + " : I will start marking assignments on " + this.assignment);
	}
	
	public void midtermAnnounced(CourseEvent e) {
		this.proctor(e.getMidterm());
	}
	
	public void assignmentPostponed(CourseEvent e) {
		this.mark(e.getAssignment());
	}
	
	public void postponedMidterm(CourseEvent e) {
		this.postpone(e.getMidterm());
	}
}
