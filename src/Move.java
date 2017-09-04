
public class Move implements Command {
	
	private Ball ball;
	public int initX, initY, initVelX, initVelY;
	
	public Move(Ball ball){
		this.ball = ball;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		initX = ball.getX();
		initY = ball.getY();
		initVelX = ball.getVelX();
		initVelY = ball.getVelY();
		
		ball.setX(initX + initVelX);
		ball.setY(initY + initVelY);

	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		ball.setX(initX);
		ball.setY(initY);

	}

}
