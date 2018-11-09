import java.util.EventObject;
import java.util.Date;

public class CourseEvent extends EventObject {

	private Date midtermDate;
	private Date assignmentDeadine;
	
	public CourseEvent(Object o) {
		super(o);
		Prof p = (Prof)o;
		this.midtermDate = p.getMidterm();
		this.assignmentDeadine = p.getAssignment();
	}
	
	public Date getMidterm() {
		return this.midtermDate;
	}
	
	public Date getAssignment() {
		return this.assignmentDeadine;
	}
}
