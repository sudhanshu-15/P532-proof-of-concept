import java.awt.event.KeyEvent;

public class PaddleMove implements Command {
	
	private Paddle paddle;
	private int initX;
	private int direction;
	
	public PaddleMove(Paddle p){
		this.paddle = p;
		this.direction = paddle.getDirection();
		this.initX = paddle.getX();
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		initX = paddle.getX();
		
		if(direction == KeyEvent.VK_RIGHT){
			if(paddle.getX() >= 540){
				paddle.setX(540);
			}else{
				paddle.setX(paddle.getX() + 30);
			}
		}
		
		if(direction == KeyEvent.VK_LEFT){
			if(paddle.getX() <= 5){
				paddle.setX(5);
			}else{
				paddle.setX(paddle.getX() - 30);
			}
		}
		paddle.setDirection(1000);
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		paddle.setX(initX);

	}

}
