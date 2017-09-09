import java.util.List;

public class BrickBreak implements Command {
	
	private List<Brick> brickList;
	private Brick brick;
	private int pos;
	private boolean hit;
	
	public BrickBreak(Brick brick, boolean hit){
		this.brick = brick;
		this.hit = hit;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		brick.setDead(hit);
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		brick.setDead(false);
	}

}
