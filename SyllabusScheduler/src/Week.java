
public class Week {
	private Day[] days= new Day[7];
	private String topic;
	
	public Day getDay() {
		return days[1];
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	
	public void print() {
		System.out.println("		"+ topic);
		for(int i = 0; i < 7; i++) {
			days[i].print();
		}
	}
}