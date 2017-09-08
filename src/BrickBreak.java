import java.util.List;

public class BrickBreak implements Command {
	
	private List<Brick> brickList;
	private Brick brick;
	private int pos;
	private boolean hit;
	
	public BrickBreak(List<Brick> brickList, Brick brick, int pos, boolean hit){
		this.brickList = brickList;
		this.brick = brick;
		this.pos = pos;
		this.hit = hit;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		if (hit){
			System.out.println(pos);
			brickList.remove(pos);
		}
		System.out.println(this.hit);
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		if (hit){
			System.out.println("Here");
			brickList.add(pos, brick);
		}
		System.out.println(this.hit);
	}

}
