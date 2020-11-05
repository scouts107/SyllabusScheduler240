public class Originator {
   private Week[] state;

   public void setState(Week[] state){
      this.state = state;
   }

   public Week[] getState(){
      return state;
   }

   public Memento saveStateToMemento(){
      return new Memento(state);
   }

   public void getStateFromMemento(Memento memento){
      state = memento.getState();
   }
}