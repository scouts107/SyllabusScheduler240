
public class Syllabus {
	private static Syllabus syllabus = null;
	
	public Week[] weeks;
	public String name;
	
	private Syllabus() {
		weeks = new Week[17];
		name = "Name";
		for (int i = 0; i < weeks.length; i++)
			weeks[i] = new Week();
	}
	public static Syllabus getInstance() {
		if(syllabus == null)
			syllabus = new Syllabus();
		return syllabus;
	}
	public Week getWeek(int i) {
		return weeks[i];
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
}
