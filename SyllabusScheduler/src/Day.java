
public class Day {
	private String topic;
	private String notes;
	
	public Day() {
		topic = null;
		notes = null;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public void print() {
		System.out.println("	" + topic);
		System.out.println(notes+ "/n");
	}
	
}