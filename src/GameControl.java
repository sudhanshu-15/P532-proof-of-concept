import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Arrays;

public class GameControl implements Observer{
	
	private Observable observable;
	private Command macro;
	private Ball b;
	private Paddle p;
	private BrickList bl;
	private CollisionDetection cd;
	private Boolean play;
	private ArrayList<MacroCommand> mcArray;
	
	public ArrayList<MacroCommand> getMcArray() {
		return mcArray;
	}

	public void setMcArray(ArrayList<MacroCommand> mcArray) {
		this.mcArray = mcArray;
	}

	public Boolean getPlay() {
		return play;
	}

	public void setPlay(Boolean play) {
		this.play = play;
	}

	public GameControl(Ball b, Paddle p, BrickList bl ,Observable observable){
		this.b = b;
		this.p = p;
		this.bl = bl;
		this.observable = observable;
		observable.register(this);
		cd = new CollisionDetection(b,p, bl);
		this.play = false;
		mcArray = new ArrayList<MacroCommand>();
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		if(play){
			b.checkBounds(575, 575);
			cd.ballPaddle();
			ArrayList<Integer> deadBrick = cd.brickBall();
//			System.out.println("Dead Brick: " + Arrays.toString(deadBrick.toArray()));
			Move bmove = new Move(b);
			PaddleMove pmove = new PaddleMove(p);
			BrickCommand brickC = new BrickCommand(bl, deadBrick);
			macro = new MacroCommand();
			((MacroCommand) macro).add(bmove);
			((MacroCommand) macro).add(pmove);
			((MacroCommand) macro).add(brickC);
			macro.execute();
			mcArray.add((MacroCommand) macro);
		}
		
	}

	public Observable getObservable() {
		return observable;
	}

	public void setObservable(Observable observable) {
		this.observable = observable;
	}
	
	public void reset(){
		b.reset();
		p.reset();
		bl.reset();
	}

}
