package proxyExample;

public class Memento {
	private Week[] state;
	
	public Memento(Week[] state) {
		this.state = state;
	}
	
	public Week[] getState() {
		return state;
	}
}
