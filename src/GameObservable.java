import java.util.ArrayList;
import java.util.List;

public class GameObservable implements Observable {
	
	private ArrayList observerList;
	
	public GameObservable(){
		observerList = new ArrayList<Observer>();
	}

	@Override
	public void register(Observer o) {
		// TODO Auto-generated method stub
		observerList.add(o);
	}

	@Override
	public void unregister(Observer o) {
		// TODO Auto-generated method stub
		int i = observerList.indexOf(o);
		observerList.remove(i);

	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		for(int i = 0; i < observerList.size(); i++){
			Observer obs = (Observer) observerList.get(i);
			obs.update();
		}

	}
	
	public void frameChanged(){
		notifyObservers();
	}
	
	public void setTime(int time){
		
	}

}
