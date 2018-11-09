
public interface CourseListener {
	public void midtermAnnounced(CourseEvent e);
	public void assignmentPostponed(CourseEvent e);
	public void postponedMidterm(CourseEvent e);
}
