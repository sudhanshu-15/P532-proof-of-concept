import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class CollisionDetection {
	private Ball b;
	private Paddle p;
	private BrickList bl;
	
	public CollisionDetection(Ball b, Paddle p, BrickList bl){
		this.b = b;
		this.p = p;
		this.bl = bl;
	}
	
	public void ballPaddle(){
		Rectangle ballCollider = b.createCollider(b.getX(), b.getY(), 20, 20);
		Rectangle paddleCollider = p.createCollider(p.getX(), p.getY(), p.getWidth(), p.getHeight());
		if(ballCollider.intersects(paddleCollider)){
			b.setVelX(-b.getVelX());
			b.setVelY(-b.getVelY());
		}
	}
	
	public ArrayList<Integer> brickBall(){
		Rectangle ballCollider = b.createCollider(b.getX(), b.getY(), 20, 20);
		List<Integer> deadBrick = new ArrayList<Integer>();
		for(Brick br : bl.getBrickL()){
			if(ballCollider.intersects(br.collider) && !br.isDead()){
				b.setVelY(-b.getVelY());
				int i = bl.getBrickL().indexOf(br);
				deadBrick.add(i);
			}
		}
		return (ArrayList<Integer>) deadBrick;
	}
	
}
