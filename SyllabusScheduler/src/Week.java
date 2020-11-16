package proxyExample;

public class Week {
	private String[] days= new String[7];
	private String topic;
	
	public Week() {
		topic = "a";
		for (int i= 0; i<days.length; i++)
			days[i] = "*";
	}
	
	public String getDay(int i) {
		return days[i];
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public void setDay(String day, int i) {
		days[i]= day;
	}
	
	public void print() {
		System.out.println("		"+ topic);
		for(int i = 0; i < 7; i++) {
			System.out.println(days[i]);
		}
	}
}
