public class Originator {
   private Week[] state = new Week[17];

   public void setState(Week[] state){
	   for (int i = 0; i < state.length; i++)
			this.state[i] = new Week();
	   for (int i = 0; i < state.length; i++) {
		   this.state[i].setTopic(state[i].getTopic());
		   for (int j = 0; j < 7; j++)
			   this.state[i].setDay(state[i].getDay(j), j);
	   }
   }

   public Memento save(){
	   return new Memento(state);
   }

   public void restore(Memento memento){
      state = memento.getState();
   }
}
