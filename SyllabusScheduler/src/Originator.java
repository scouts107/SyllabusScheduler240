package proxyExample;

public class Originator {
   private Week[] state = new Week[17];
   private Syllabus s = Syllabus.getInstance();

   public void setState(){
	   for (int i = 0; i < s.weeks.length; i++)
			this.state[i] = new Week();
	   for (int i = 0; i < s.weeks.length; i++) {
		   this.state[i].setTopic(s.weeks[i].getTopic());
		   for (int j = 0; j < 7; j++)
			   this.state[i].setDay(s.weeks[i].getDay(j), j);
	   }
   }

   public Memento save(){
	   return new Memento(state);
   }

   public void restore(Memento memento){
      state = memento.getState();
   }
}
