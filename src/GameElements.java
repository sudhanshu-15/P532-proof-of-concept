import java.util.ArrayList;

public class GameElements implements Observer {
	
	private ArrayList gameElements;
	private Observable gameObservable; 
	
	public GameElements(Observable gameObservable){
		gameElements = new ArrayList<Observer>();
		this.gameObservable = gameObservable;
		gameObservable.register(this);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		for (int i = 0; i < gameElements.size(); i++){
			Observer o = (Observer) gameElements.get(i);
			o.update(o);
		}
	}
	
	public void add(Observer o){
		gameElements.add(o);
	}

	public void remove(Observer o){
		int i = gameElements.indexOf(o);
		gameElements.remove(i);
	}

	@Override
	public void update(Observer observer) {
		// TODO Auto-generated method stub
		
	}

}
