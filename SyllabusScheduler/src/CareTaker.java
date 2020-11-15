import java.util.ArrayList;
import java.util.List;

public class CareTaker {
   private ArrayList<Memento> mementoList = new ArrayList<Memento>();

   public void addMemento(Memento state){
      mementoList.add(state);
   }

   public Memento getMemento(){
      return mementoList.get(0);
   }
}
