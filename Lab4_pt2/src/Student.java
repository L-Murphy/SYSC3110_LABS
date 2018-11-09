/** SYSC 2101 - Prof-Student-TA Example
 * 
 *
 */

import java.util.Date;

public class Student implements CourseListener{
	private String name;
	private Date midterm;
	private Date assignment;
	
	public Student(String aName) {
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
	
	public void work(Date date) {
		this.assignment = date;
		System.out.println(name + ": please push it back!!! I can't finish it for " + this.assignment);
	}
	
	public void midtermAnnounced(CourseEvent e) {
		this.study(e.getMidterm());
	}
	
	public void assignmentPostponed(CourseEvent e) {
		this.work(e.getAssignment());
	}
	
	public void postponedMidterm(CourseEvent e) {
		this.party(e.getMidterm());
	}
}
