import java.util.ArrayList;

public class BrickCommand implements Command {
	
	private BrickList bl;
	private ArrayList<Brick> listbrick;
	private ArrayList<Integer> deadBrick;
	
	public BrickCommand(BrickList bl, ArrayList<Integer> deadBrick){
		this.bl = bl;
		listbrick = bl.getBrickL();
		this.deadBrick = deadBrick;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		for(Integer i : deadBrick){
			Brick b = listbrick.get(i);
			b.setDead(true);
		}
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		for(Integer i: deadBrick){
			Brick b = listbrick.get(i);
			b.setDead(!b.isDead());
		}

	}

}
