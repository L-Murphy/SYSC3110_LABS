/** SYSC 2101 - Prof-Student-TA Example
 * 
 *
 */

import java.util.ArrayList;
import java.util.Date;

public class Prof {
	private String name;
	private Date midtermDate;
	private Date assignmentDate;
	private ArrayList<CourseListener> courseListeners;
	
	public Prof(String aName) {
		this.name = aName;
		this.courseListeners = new ArrayList<CourseListener>();
	}
	
	public Date getMidterm() {
		return this.midtermDate;
	}

	public Date getAssignment() {
		return this.assignmentDate;
	}
	public String getName() {
		return this.name;
	}
	
	public void addCourseListener(CourseListener c) {
		this.courseListeners.add(c);
	}
	
	public void removeCourseListener(CourseListener c) {
		this.courseListeners.remove(c);
	}
	
	public void setMidterm(Date date) {
		this.midtermDate = date;
		CourseEvent e = new CourseEvent(this);
		for (CourseListener cl : courseListeners) {
			cl.midtermAnnounced(e);
		}
	}
	
	public void postponeMidterm(Date date){
		this.midtermDate = date;
		CourseEvent e = new CourseEvent(this);
		for (CourseListener cl : courseListeners) {
			cl.postponedMidterm(e);
		}
	}
	
	public void assignmentPostponed(Date date) {
		this.assignmentDate = date;
		CourseEvent e = new CourseEvent(this);
		for (CourseListener cl : courseListeners) {
			cl.assignmentPostponed(e);
		}
	}

	public static void main(String[] args) {

		Prof p = new Prof("Babak");
		Student s = new Student("Homer");
		Student s2 = new Student("Bart");
		TeachingAssistant ta = new TeachingAssistant("Michael");
		
		p.addCourseListener(s2);
		p.addCourseListener(s);
		p.addCourseListener(ta);
	
		Date midterm = new Date();
		p.setMidterm(midterm);
	
		p.postponeMidterm(new Date(midterm.getTime() + 1000000000));
	}

}
